package ru.artemme;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class MongoDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoDbApplication.class, args);
    }

    @Bean
    CommandLineRunner init(DomainRepository domainRepository) {
        return args -> {
            domainRepository.save(new Domain(1, "haha", true));

            Optional<Domain> obj = domainRepository.findById(1L);

            System.out.println("Domain: " + obj.get().getDomain() + "displayAds: " + obj.get().isDisplayAds());

            System.out.println("Trying to update record");

            domainRepository.updateDomain("haha", false);

            Optional<Domain> obj2 = domainRepository.findById(1L);

            System.out.println("2. Domain: " + obj2.get().getDomain() + "displayAds: " + obj2.get().isDisplayAds());

        };
    }
}
