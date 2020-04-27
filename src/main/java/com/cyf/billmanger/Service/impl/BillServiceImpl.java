package com.cyf.billmanger.Service.impl;

import com.cyf.billmanger.Service.BillService;
import com.cyf.billmanger.dto.BillProvider;
import com.cyf.billmanger.entities.Bill;
import com.cyf.billmanger.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillRepository billRepository;
    @Override
    public List<BillProvider> getBillProviders(Bill bill) {
        List<BillProvider> billProviders = billRepository.findBillProviders();
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
        return billRepository.findBillProviders();
    }

    @Override
    public BillProvider getBillProviderByBid(String bid) {
        return billRepository.findBillProvidersByBid(bid);
    }

    @Override
    public void save(Bill bill) {
        if(StringUtils.isEmpty(bill.getBid())){
            bill.setBid(UUID.randomUUID().toString());
        }
        bill.setCreateDate(new Date());
        billRepository.save(bill);
    }

    @Override
    public void delete(String bid) {
        billRepository.deleteById(bid);
    }

}
