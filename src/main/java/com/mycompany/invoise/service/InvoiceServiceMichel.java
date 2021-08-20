package com.mycompany.invoise.service;

import com.mycompany.invoise.entity.Invoice;
import com.mycompany.invoise.repository.InvoiceRepository;
import com.mycompany.invoise.repository.InvoiceRepositoryMichel;

public class InvoiceServiceMichel {

    private static Long lastNumber=112L;

    private InvoiceRepositoryMichel invoiceRepositoryMichel = new InvoiceRepositoryMichel();

    public void createInvoice(Invoice invoice) {
        invoice.setNumber(String.valueOf("INV_" + (++lastNumber)));
        invoiceRepositoryMichel.create(invoice);
    }

}
