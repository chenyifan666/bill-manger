package com.cyf.billmanger.Service;

import com.cyf.billmanger.entities.Provider;
import com.cyf.billmanger.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProviderService {

    List<Provider> getProviders();

    List<Provider> getProviders(Provider provider);

    Provider getProviderById(String id);

    void deleteProviderById(String id);

    void saveProvider(Provider provider);
}
