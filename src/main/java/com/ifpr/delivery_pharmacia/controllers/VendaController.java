package com.ifpr.delivery_pharmacia.controllers;


import com.ifpr.delivery_pharmacia.S3.StorageService;
import com.ifpr.delivery_pharmacia.enums.VendaStatus;
import com.ifpr.delivery_pharmacia.models.*;
import com.ifpr.delivery_pharmacia.repositories.*;
import lombok.AllArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@RestController
@AllArgsConstructor
public class VendaController {

    VendaRepository repository;
    VendaItemRepository venda_item_repository;
    VendaReceitaRepository venda_receita_repository;
    UsuarioRepository cliente_repository;
    ProdutoRepository produto_repository;
    AtualizacaoRepository atualizacao_repository;

    @Autowired
    private StorageService service;
    static String diretorio_receitas = "~/imagens/receitas/";

    @GetMapping("/venda")
    public List<Venda> getAllVenda() {
        return repository.findAll();
    }

    @GetMapping("/venda/one")
    public Venda getVenda(@RequestParam Long id) {
        return repository.findById(id).get();
    }

    //Busca as atualizações da venda
    @GetMapping("/venda/atts/{id}")
    public List<Atualizacao> getAttsVenda(@PathVariable Long id) {

        Venda venda = repository.findById(id).get();
        return venda.getAtualizacoes();
    }


    @GetMapping("/venda/statusAndCliente")
    public List<Venda> getVendaByStatusAndCliente(@RequestParam VendaStatus status, @RequestParam Long cliente_id) {

        Usuario usuario = cliente_repository.findById(cliente_id).get();

        return repository.findByStatusAndCliente(status, usuario);
    }

    @GetMapping("/venda/cliente/{id}")
    public List<Venda> getVendaCliente( @PathVariable Long id) {

        Usuario usuario = cliente_repository.findById(id).get();

        return repository.findByCliente( usuario);
    }


    @GetMapping("/venda/status")
    public List<Venda> getVendaByStatus(@RequestParam VendaStatus status) {


        return repository.findByStatus(status);
    }

    @PostMapping("/venda/add")
    public Venda addVenda(@RequestBody Venda venda) {

        //chama o método que calcula os valores totais da venda
        venda = setValoresVenda(venda);

        venda.setStatus(VendaStatus.SOLICITADA);

        Atualizacao att = new Atualizacao();
        att.setStatus(VendaStatus.SOLICITADA);

        List<Atualizacao> atts = new ArrayList<>();
        atts.add(att);

        venda.setAtualizacoes(atts);

        return repository.save(venda);
    }


    @PostMapping("/venda/add_with_image")
    @Transactional
    public Venda addVendaComImagem(@ModelAttribute Venda venda, @RequestParam("imagens_receitas") MultipartFile[] uploadingFiles) {

        List<Receita> receitas = new ArrayList<>();

        try {

            //chama o método que calcula os valores totais da venda
            venda = setValoresVenda(venda);

            //Seta o status de SOLICITADA
            venda.setStatus(VendaStatus.SOLICITADA);

            //Seta a atualização com status de SOLICITADA
            Atualizacao att = new Atualizacao();
            att.setStatus(VendaStatus.SOLICITADA);

            List<Atualizacao> atts = new ArrayList<>();
            atts.add(att);

            venda.setAtualizacoes(atts);

            //Bloco pra pegar os arquivos enviados
            for (MultipartFile arquivo : uploadingFiles) {
                try {
                    if (!arquivo.isEmpty()) {
                        byte[] bytes = arquivo.getBytes();

                        String new_name = RandomString.make(25) + "." + FilenameUtils.getExtension(arquivo.getOriginalFilename());

                        Path caminho = Paths.get(diretorio_receitas + new_name);

                        Files.write(caminho, bytes);

                        Receita receita = new Receita();
                        receita.setArquivo(new_name);
                        receitas.add(receita);

                    }
                } catch (IOException e) {

                    throw new RuntimeException("Problemas na tentativa de salvar arquivo.", e);
                }
            }

            venda.setReceitas(receitas);
            return repository.save(venda);

        } catch (Exception e) {
            throw new RuntimeException("Problemas em salvar a venda.", e);
        }
    }


    @PutMapping("/venda/edit")
    public Venda editVenda(@RequestBody Venda venda) {
        return repository.save(venda);
    }

    @PutMapping("/venda/edit_status/{id}/{status}")
    public Venda editVendaStatus(@PathVariable Long id, @PathVariable VendaStatus status) {

        Venda venda = repository.findById(id).get();
        venda.setStatus(status);

        //Seta a atualização com status que veio no body
        Atualizacao att = new Atualizacao();
        att.setStatus(status);

        atualizacao_repository.save(att);

        List<Atualizacao> atts = new ArrayList<>();
        atts = venda.getAtualizacoes();
        atts.add(att);

        venda.setAtualizacoes(atts);

        return repository.save(venda);
    }

    //Bloco para calcular os valores totais da venda
    private Venda setValoresVenda(Venda venda){

        List<Item> venda_itens = new ArrayList<>();
        Float valor_total_venda_produtos = 0F;

        //Bloco pra calcular o valor total do item
        for (Item item : venda.getItens()) {
            Long id = item.getProduto().getId();
            Produto produto = produto_repository.findById(id).get();
            item.setProduto(produto);
            item.setValor_unitario(produto.getValor_unitario());
            item.setValor_total(produto.getValor_unitario() * item.getQuantidade());

            venda_itens.add(item);

            valor_total_venda_produtos += item.getValor_total();
        }

        venda.setItens(venda_itens);

        //Valor dos produtos
        venda.setValor_produtos(valor_total_venda_produtos);
        //Calcula o valor total da venda (itens + frete)
        venda.setValor_total(valor_total_venda_produtos + (venda.getValor_frete() != null ? venda.getValor_frete() : 0 ));

        return  venda;
    }
}
