package com.cyf.billmanger.Service.impl;

import com.cyf.billmanger.Service.BillService;
import com.cyf.billmanger.dto.BillProvider;
import com.cyf.billmanger.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillRepository billRepository;
    @Override
    public List<BillProvider> getBillProviders() {
        return billRepository.findBillProviders();
    }
}
