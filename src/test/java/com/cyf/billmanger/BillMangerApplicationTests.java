package com.cyf.billmanger;

import com.cyf.billmanger.entities.Provider;
import com.cyf.billmanger.entities.User;
import com.cyf.billmanger.repository.ProviderRepository;
import com.cyf.billmanger.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
class BillMangerApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProviderRepository providerRepository;


    @Test
    void contextLoads() {
    }

    @Test
    void testUser(){
        List<User> userList = userRepository.findAll();
        System.out.println(userList.size());
    }

    @Test
    void testProvider(){
        List<Provider> providers = providerRepository.findAll();
        Provider provider = providers.get(3);
        provider.setId(UUID.randomUUID().toString());
        providerRepository.save(provider);
    }
}
