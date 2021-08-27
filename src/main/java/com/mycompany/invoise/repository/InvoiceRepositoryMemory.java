package com.mycompany.invoise.repository;

import com.mycompany.invoise.entity.Invoice;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvoiceRepositoryMemory implements InvoiceRepositoryInterface {

    private static List<Invoice> invoices=new ArrayList<>();

    public void create(Invoice invoice) {
        invoices.add(invoice);
        System.out.println("Memory: Invoice added with number " + invoice.getNumber() + " for " + invoice.getCustomerName());
    }

}
