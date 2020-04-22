package com.cyf.billmanger.Service.impl;

import com.cyf.billmanger.Service.ProviderService;
import com.cyf.billmanger.entities.Provider;
import com.cyf.billmanger.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ProviderServiceImpl implements ProviderService {
    @Autowired
    private ProviderRepository providerRepository;

    public List<Provider> getProviders(){
        return providerRepository.findAll();
    }

    public List<Provider> getProviders(Provider provider){
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("providerName",ExampleMatcher.GenericPropertyMatchers.contains());
        Example<Provider> example = Example.of(provider,exampleMatcher);
        return providerRepository.findAll(example);
    }

    public Provider getProviderById(String id){
        return providerRepository.findAllById(id);
    }

    @Override
    public void deleteProviderById(String id) {
        providerRepository.deleteById(id);
    }

    @Override
    public void saveProvider(Provider provider) {
        if(StringUtils.isEmpty(provider.getId())){
            provider.setId(UUID.randomUUID().toString());
        }
        provider.setCreateDate(new Date());
        providerRepository.save(provider);
    }
}
