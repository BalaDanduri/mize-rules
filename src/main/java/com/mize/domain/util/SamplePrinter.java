package com.mize.domain.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.PrintServiceAttribute;
import javax.print.attribute.standard.PrinterName;

public class SamplePrinter {

	   @SuppressWarnings("resource")
	public static void main(String[] args) {
	       
	       try {
	           
	           PrintService psZebra = null;
	           String sPrinterName = null;
	           PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
	           
	           for (int i = 0; i < services.length; i++) {
	               
	               PrintServiceAttribute attr = services[i].getAttribute(PrinterName.class);
	               sPrinterName = ((PrinterName) attr).getValue();
	               
	               if (sPrinterName.toLowerCase().indexOf("zebra") >= 0) {
	                   psZebra = services[i];
	                   break;
	               }
	           }
	           
	           if (psZebra == null) {
	               System.out.println("Zebra printer is not found.");
	               return;
	           }
	           DocPrintJob job = psZebra.createPrintJob();

	           File file = new File("D:/794615956926_0.ZPL.txt");

	           byte[] b = new byte[(int) file.length()];
	           try {
	                 FileInputStream fileInputStream = new FileInputStream(file);
	                 fileInputStream.read(b);
	                 for (int i = 0; i < b.length; i++) {
	                             System.out.print((char)b[i]);
	                  }
	            } catch (FileNotFoundException e) {
	                        System.out.println("File Not Found.");
	                        e.printStackTrace();
	            }
	            catch (IOException e1) {
	                     System.out.println("Error Reading The File.");
	                      e1.printStackTrace();
	            }
	           
	           DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
	           Doc doc = new SimpleDoc(b, flavor, null);
	           job.print(doc, null);
	           
	       } catch (PrintException e) {
	           e.printStackTrace();
	       }      
	   }
	}