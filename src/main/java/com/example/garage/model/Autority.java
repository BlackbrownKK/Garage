package com.example.garage.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;


import java.awt.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("AUTORITY")

public class Autority implements GrantedAuthority {

    @Id
    @Column("ID")
    private int id;
    @Column("CLIENT_ID")
    private int clientId;
    @Column("ROLE")
    private String role;

    @Override
    public String getAuthority() {
        return role;
    }
}

