package org.ma.thymeleaf.service;

import org.ma.thymeleaf.entitie.Person;
import org.ma.thymeleaf.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.Scanner;

@Service
public class AtFirst {
    @Bean
    CommandLineRunner go(PersonRepository personRepository) {
        return a -> {
            File file = ResourceUtils.getFile("classpath:users.csv");
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] lineUser = line.split(",");
                personRepository.save(new Person(null, lineUser[0], lineUser[1], lineUser[2]));
                System.out.println(line);
            }
        };
    }
}
