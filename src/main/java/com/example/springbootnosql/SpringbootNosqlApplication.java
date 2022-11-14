package com.example.springbootnosql;

import com.example.springbootnosql.account.Account;
import com.example.springbootnosql.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class SpringbootNosqlApplication {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootNosqlApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            Account account = new Account();
            account.setEmail("aaa@bbb");
            account.setUsername("yulseon");

            mongoTemplate.insert(account);

            System.out.println("finished");

            /**
             * repository를 통해서도 insert가 가능하다.
             */
            accountRepository.insert(account);
        };
    }
}
