package com.example.garage.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("CLIENT")
public class Client {

    @Id
    @Column("CLIENT_ID")
    private int clientId;

    @Column("CLIENT_FIRST_NAME")
    private String clientFirstName;

    @Column("CLIENT_LAST_NAME")
    private String clientLastName;

    @Column("CLIENT_EMAIL")
    private String clientEmail;

    @Column("CLIENT_PASSWORD")
    private String clientPassword;
}
