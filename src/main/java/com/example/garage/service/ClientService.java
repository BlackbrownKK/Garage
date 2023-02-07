package com.example.garage.service;

import com.example.garage.model.Autority;
import com.example.garage.model.Client;
import com.example.garage.repasitory.AutorityRepasitory;
import com.example.garage.repasitory.ClientRepasitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepasitory clientRepasitory;
    private final AutorityRepasitory autorityRepasitory;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ClientService(ClientRepasitory userRepository, AutorityRepasitory roleRepository, PasswordEncoder passwordEncoder) {
        this.clientRepasitory = userRepository;
        this.autorityRepasitory = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(Client incomingData) {

        Client savedUser = clientRepasitory.save(Client.builder()
                .clientFirstName(incomingData.getClientFirstName())
                .clientLastName(incomingData.getClientLastName())
                .clientEmail(incomingData.getClientEmail())
                .clientPassword(passwordEncoder.encode(incomingData.getClientPassword()))
                .build());

        autorityRepasitory.save(Autority.builder()
                .clientId(savedUser.getClientId())
                .role("USER")
                .build());
    }

    public Client findByEmail(String email) {
        return clientRepasitory.findAllByClientEmail(email);
    }

    public List<Client> findAll() {
        return clientRepasitory.findAll();
    }
}
