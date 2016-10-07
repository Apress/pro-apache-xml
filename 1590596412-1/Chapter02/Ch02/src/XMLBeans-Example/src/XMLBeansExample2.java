/**
 * This example uses Schema-Compiler generated classes to
 * update the specified customer's order from buy to sell
 * specified Orders.xml document.
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

public class XMLBeansExample2 {
    static OrdersDocument doc;
    static String customerID = null;
    
    /**
     * The main method parses and validates the document specified
     * in the parameter and on success updates the specified
     * customer's order.
     */
    public static void main(String[] args)
    throws org.apache.xmlbeans.XmlException, java.io.IOException {
        customerID = args[1];
        if (validate(args[0]))
            updateCustomerTrade();
    }
    
    /**
     * Build and validate the specified document
     */
    public static boolean validate(String filename)
    throws org.apache.xmlbeans.XmlException, java.io.IOException {
        System.out.println("parsing document: " + filename);
        // Use the generated classes' parse method to parse input document
        doc = OrdersDocument.Factory.parse(new File(filename));
        
        // Create an array list
        ArrayList errors = new ArrayList();
        
        // Set up an error listener
        XmlOptions opts = new XmlOptions();
        opts.setErrorListener(errors);
        
        // Validate the document
        if (doc.validate(opts)) {
            System.out.println("document is valid.");
        } else // Print the error list
        {
            System.out.println("document is invalid!");
            
            Iterator iter = errors.iterator();
            while (iter.hasNext()) {
                System.out.println(">> " + iter.next());
            }
            return false;
        }
        return true;
    }
    
    /**
     * This method updates the customer's order from buy to sell type
     */
    public static void updateCustomerTrade() {
        
        // get a reference to Orders instance
        Orders orders = doc.getOrders();
        
        // Get a list of customers from orders instance
        Customer[] customers = orders.getCustomerArray();
        
        // Iterate through the list of customers
        for (int i=0; i<customers.length; i++) {
            // Check for the desired customer ID
            if (customers[i].getID().equals(customerID)) {
                System.out.println("Customer " + customerID + " Found");
                // Retrieve the list of orders placed by the customer
                StockSymbol[] stocks = customers[i].getStockSymbolArray();
                // For each ordered scrip, change the trade type to sell
                for (int j=0; j<stocks.length; j++) {
                    System.out.println("Current Trade Type: " + stocks[j].getTradeType());
                    stocks[j].setTradeType("S");
                    System.out.println("New Trade Type: " + stocks[j].getTradeType());
                }
            }
            
        }
        
    }
}
