package com.mycompany.invoise.controller;

import com.mycompany.invoise.entity.Invoice;
import com.mycompany.invoise.service.InvoiceService;

import java.util.Scanner;

public class InvoiceController {

    public void createInvoiceUsingConsole() {
        System.out.println("What is the customer name?");
        Scanner sc = new Scanner(System.in);
        Invoice invoice = new Invoice();
        invoice.setCustomerName(sc.nextLine());

        InvoiceService invoiceService = new InvoiceService();
        invoiceService.createInvoice(invoice);
    }
}
