package com.example.springbootnosql;

import com.example.springbootnosql.account.Account;
import com.example.springbootnosql.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Optional;

public class RedisRunner implements ApplicationRunner {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ValueOperations<String, String> values = stringRedisTemplate.opsForValue();
        values.set("yulseon", "yoo");
        values.set("springboot", "2.7.5");
        values.set("hello", "word");

        Account account = new Account();
        account.setEmail("ysyoo89@kakao.com");
        account.setUsername("yulseon");

        Optional<Account> byId = accountRepository.findById(account.getId());
        System.out.println(byId.get().getUsername());
        System.out.println(byId.get().getEmail());
    }
}
