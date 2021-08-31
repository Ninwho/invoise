package com.mycompany.invoise.controller.web;

import com.mycompany.invoise.controller.InvoiceControllerInterface;
import com.mycompany.invoise.entity.Invoice;
import com.mycompany.invoise.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class InvoiceControllerWeb implements InvoiceControllerInterface {

    @Autowired
    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    public void createInvoice() {
        String customerName = "Audi";
        Invoice invoice = new Invoice();
        invoice.setCustomerName(customerName);
        invoiceService.createInvoice(invoice);
    }

    @RequestMapping("/invoise-home")
    public @ModelAttribute("invoices") List<Invoice> displayHome() {
        System.out.println("La méthode displayHome a été invoquée.");
        List<Invoice> invoices = invoiceService.getInvoiceList();
        return invoices;
    }

}
