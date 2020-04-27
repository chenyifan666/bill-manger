package com.cyf.billmanger.controller;

import com.cyf.billmanger.Service.BillService;
import com.cyf.billmanger.Service.ProviderService;
import com.cyf.billmanger.dto.BillProvider;
import com.cyf.billmanger.entities.Bill;
import com.cyf.billmanger.entities.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        List<BillProvider> billProviders = billService.getBillProviders();
        List<Provider> providers = providerService.getProviders();

        Iterator<BillProvider> iterator = billProviders.iterator();
        while (iterator.hasNext()){
            BillProvider billProvider = iterator.next();
            if(!StringUtils.isEmpty(bill.getBillName()) &&!billProvider.getBill().getBillName().contains(bill.getBillName())){
                iterator.remove();
            }
            else if(!StringUtils.isEmpty(bill.getPid())&&!billProvider.getBill().getPid().equals(bill.getPid())){
                iterator.remove();
            }
            else if(bill.getPay()!=null&&billProvider.getBill().getPay()!=bill.getPay()){
                iterator.remove();
            }
        }
        map.put("pay",bill.getPay());
        map.put("pid",bill.getPid());
        map.put("billName",bill.getBillName());
        map.put("billProviders",billProviders);
        map.put("providers",providers);
        return "bill/list";
    }
}
