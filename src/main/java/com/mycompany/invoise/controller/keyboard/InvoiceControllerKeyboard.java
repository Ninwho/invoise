package com.mycompany.invoise.controller.keyboard;

import com.mycompany.invoise.controller.InvoiceControllerInterface;
import com.mycompany.invoise.entity.Invoice;
import com.mycompany.invoise.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

//@Controller
public class InvoiceControllerKeyboard implements InvoiceControllerInterface {

    @Autowired
    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    public void createInvoice() {
        System.out.println("What is the customer name?");
        Scanner sc = new Scanner(System.in);
        Invoice invoice = new Invoice();
        invoice.setCustomerName(sc.nextLine());
        invoiceService.createInvoice(invoice);
    }
}
