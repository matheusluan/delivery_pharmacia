package com.ifpr.delivery_pharmacia.models;


import com.ifpr.delivery_pharmacia.enums.RoleName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    RoleName roleName;

    @Override
    public String getAuthority() {
        return this.roleName.toString();
    }
}
