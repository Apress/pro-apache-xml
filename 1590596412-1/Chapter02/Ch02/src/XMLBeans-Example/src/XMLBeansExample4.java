/**
 * This examples uses the schema-compiler generated classes to dynamically create
 * a new orders document.
 */
package apress.apacheXML.ch02;

import org.apache.xmlbeans.*;
import com.apress.apacheXML.*;
import com.apress.apacheXML.OrdersDocument.*;
import com.apress.apacheXML.OrdersDocument.Orders.*;
import com.apress.apacheXML.OrdersDocument.Orders.Customer.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class XMLBeansExample4 {
    static OrdersDocument doc;
    
    /**
     * The main method builds an in-memory document using
     * schema-compiler generated classes and saves it to
     * an XML file.
     */
    public static void main(String[] args)
    throws org.apache.xmlbeans.XmlException, java.io.IOException {
        // Create an in-memory instance of XML document
        createOrderDocument();
        // Save the memory instance to a physical file
        saveXML();
    }
    
    public static void createOrderDocument() {
        // Create a document instance
        doc = com.apress.apacheXML.OrdersDocument.Factory.newInstance();
        
        // Add Orders element to the created document
        com.apress.apacheXML.OrdersDocument.Orders orders = doc.addNewOrders();
        
        // Add a Customer element with ID equal to C005
        com.apress.apacheXML.OrdersDocument.Orders.Customer customer = orders.addNewCustomer();
        customer.setID("C005");
        
        // Add an order for GE
        com.apress.apacheXML.OrdersDocument.Orders.Customer.StockSymbol stockSymbol =
                customer.addNewStockSymbol();
        
        XmlString xmlStr = XmlString.Factory.newValue("GE");
        stockSymbol.set(xmlStr);
        stockSymbol.setQuantity((short)200);
        stockSymbol.setTradeType("B");
    }
    
    /**
     * This method saves the modified in-memory document to a physical file
     */
    public static void saveXML() {
        // Set options for saving the document
        XmlOptions xmlOptions = new XmlOptions();
        xmlOptions.setSavePrettyPrint();
        
        // Create a new file for outputting memory document
        File f = new File("NewOrder.xml");
        
        try{
            // Save the document
            doc.save(f,xmlOptions);
        } catch(java.io.IOException e){
            e.printStackTrace();
        }
        System.out.println("\nXML Instance Document saved at : " + f.getPath());
        
    }
    
    
    
    
}
