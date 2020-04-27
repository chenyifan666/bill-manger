package com.cyf.billmanger.Service;

import com.cyf.billmanger.dto.BillProvider;
import com.cyf.billmanger.entities.Bill;

import java.util.List;

public interface BillService {
    List<BillProvider> getBillProviders(Bill bill);

    BillProvider getBillProviderByBid(String bid);

    void save(Bill bill);

    void delete(String bid);
}
