package com.cyf.billmanger.dto;

import com.cyf.billmanger.entities.Bill;
import com.cyf.billmanger.entities.Provider;
import lombok.Data;

@Data
public class BillProvider {
    private Bill bill;
    private Provider provider;

    public BillProvider(Bill bill,Provider provider){
        this.bill = bill;
        this.provider = provider;
    }
}
