package com.cyf.billmanger.Controller;

import com.cyf.billmanger.Service.ProviderService;
import com.cyf.billmanger.entities.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/provider")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @GetMapping("/list")
    public String providerList(Provider provider,Map map){
        List<Provider> providerList = providerService.getProviders(provider);
        map.put("providerList",providerList);
        map.put("providerName",provider.getProviderName());
        return "provider/list";
    }

    @GetMapping("/getProvider/{id}")
    public String getProviderById(@PathVariable("id") String id,
                                  @RequestParam(name = "type",required = false)String type,
                                          Map map){
        Provider provider = providerService.getProviderById(id);
        map.put("provider",provider);
        if("update".equals(type)){
            return "provider/update";
        }
        return "provider/view";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProvider(@PathVariable("id") String id){
        providerService.deleteProviderById(id);
        return "redirect:/provider/list";
    }

    @PostMapping("/save")
    public String saveProvider(Provider provider){
        providerService.saveProvider(provider);
        return "redirect:/provider/list";
    }
}
