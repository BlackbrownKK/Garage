package com.example.garage.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "client")
public class Client {

    @Id
    @Column("client_id")
    private int clientId;

    @Column("enable")
    private boolean enable;

    @Column("client_first_name")
    private String clientFirstName;

    @Column("client_last_name")
    private String clientLastName;

    @Column("client_email")
    private String clientEmail;

    @Column("client_password")
    private String clientPassword;
}
