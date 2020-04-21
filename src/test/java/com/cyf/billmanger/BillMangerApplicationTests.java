package com.cyf.billmanger;

import com.cyf.billmanger.entities.Provider;
import com.cyf.billmanger.entities.User;
import com.cyf.billmanger.repository.ProviderRepository;
import com.cyf.billmanger.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
        System.out.println(providers.get(0));
    }
}
