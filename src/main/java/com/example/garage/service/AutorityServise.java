package com.example.garage.service;

import com.example.garage.model.Client;
import com.example.garage.repasitory.AutorityRepasitory;
import com.example.garage.repasitory.ClientRepasitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class AutorityServise implements UserDetailsService {

    private final ClientRepasitory clientRepasitory;

    private final AutorityRepasitory autorityRepasitory;

    @Autowired
    public AutorityServise(ClientRepasitory clientRepasitory, AutorityRepasitory autorityRepasitory) {
        this.clientRepasitory = clientRepasitory;
        this.autorityRepasitory = autorityRepasitory;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Client client = clientRepasitory.findAllByClientEmail(email);

        if (client != null) {
            return new org.springframework.security.core.userdetails.User(client.getClientEmail(),
                    client.getClientPassword(),
                    autorityRepasitory.findAllByClientId(client.getClientId()));

        } else throw new UsernameNotFoundException("Wrong username or password.");
    }
}
