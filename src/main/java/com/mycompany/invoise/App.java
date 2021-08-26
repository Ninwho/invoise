package com.mycompany.invoise;

import com.mycompany.invoise.controller.InvoiceControllerInterface;
import com.mycompany.invoise.controller.InvoiceControllerKeyboard;
import com.mycompany.invoise.controller.InvoiceControllerDouchette;
import com.mycompany.invoise.controller.InvoiceControllerWeb;
import com.mycompany.invoise.repository.InvoiceRepositoryInterface;
import com.mycompany.invoise.repository.InvoiceRepositoryMemory;
import com.mycompany.invoise.repository.InvoiceRepositoryDatabase;
import com.mycompany.invoise.service.InvoiceServiceInterface;
import com.mycompany.invoise.service.InvoiceServiceNumber;
import com.mycompany.invoise.service.InvoiceServicePrefix;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Scanner sc = new Scanner(System.in);

        System.out.println("Quel est la classe de controller ?");
        String controller = sc.nextLine();

        System.out.println("Quel est la classe de service ?");
        String service = sc.nextLine();

        System.out.println("Quel est la classe de repository ?");
        String repository = sc.nextLine();

        // On ne connaît pas le type du controller yet donc on déclara la variable comme interface
        InvoiceControllerInterface invoiceController=null;

        InvoiceServiceInterface invoiceService=null;

        InvoiceRepositoryInterface invoiceRepository=null;

        try {
            invoiceController = (InvoiceControllerInterface) Class.forName(controller).getDeclaredConstructor().newInstance();
            invoiceService = (InvoiceServiceInterface) Class.forName(service).getDeclaredConstructor().newInstance();
            invoiceRepository = (InvoiceRepositoryInterface) Class.forName(repository).getDeclaredConstructor().newInstance();
        } catch(Exception e) {
            e.printStackTrace();
        }

        invoiceController.setInvoiceService(invoiceService);
        invoiceService.setInvoiceRepository(invoiceRepository);

        invoiceController.createInvoice();
    }
}
