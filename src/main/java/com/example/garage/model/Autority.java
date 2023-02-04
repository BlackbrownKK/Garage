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
@Table(name="autority")

public class Autority implements GrantedAuthority {

    @Id
    @Column("id")
    private int id;
    @Column("client_id")
    private int clientId;
    @Column("roles")
    private String role;

    @Override
    public String getAuthority() {
        return role;
    }
}

