package com.cyf.billmanger.controller;

import com.cyf.billmanger.Service.BillService;
import com.cyf.billmanger.Service.ProviderService;
import com.cyf.billmanger.dto.BillProvider;
import com.cyf.billmanger.entities.Bill;
import com.cyf.billmanger.entities.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/bill")
public class BillController {
    @Autowired
    private BillService billService;
    @Autowired
    private ProviderService providerService;

    @GetMapping("/list")
    public String getBills(Bill bill,Map map){
        List<BillProvider> billProviders = billService.getBillProviders(bill);
        List<Provider> providers = providerService.getProviders();
        map.put("pay",bill.getPay());
        map.put("pid",bill.getPid());
        map.put("billName",bill.getBillName());
        map.put("billProviders",billProviders);
        map.put("providers",providers);
        return "bill/list";
    }

    @GetMapping("/getBill/{bid}")
    public String getBill(@PathVariable("bid") String bid,
                          @RequestParam(name = "type",defaultValue = "view") String type,
                          Map map){
        BillProvider billProvider = billService.getBillProviderByBid(bid);
        map.put("billProvider",billProvider);
        if("view".equals(type)){
            return "bill/view";
        }else{
            List<Provider> providers = providerService.getProviders();
            map.put("providers",providers);
            return "bill/update";
        }
    }

    @PostMapping("/save")
    public String save(Bill bill){
        billService.save(bill);
        return "redirect:/bill/list";
    }

    @GetMapping("/toAdd")
    public String toAdd(Map map){
        List<Provider> providers = providerService.getProviders();
        map.put("providers",providers);
        return "/bill/add";
    }

    @DeleteMapping("/delete/{pid}")
    public String delete(@PathVariable("pid") String pid){
        billService.delete(pid);
        return "redirect:/bill/list";
    }
}
