package com.ifpr.delivery_pharmacia.repositories;

import com.ifpr.delivery_pharmacia.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaItemRepository extends JpaRepository<Item, Long> {


}
