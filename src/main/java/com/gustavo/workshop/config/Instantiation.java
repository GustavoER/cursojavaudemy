package com.gustavo.workshop.config;

import com.gustavo.workshop.domain.User;
import com.gustavo.workshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    private final UserRepository userRepository;

    @Autowired
    public Instantiation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        var maria = new User(null, "Maria Brown", "maria@gmail.com");
        var alex = new User(null, "Alex Green", "alex@gmail.com");
        var bob = new User(null, "Bob Grey", "b@gmail.com");
        userRepository.saveAll(Arrays.asList(maria, alex, bob));

    }
}
