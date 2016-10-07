/**
 * This example uses Schema-Compiler generated classes to
 * delete all orders placed by a specified customer and
 * generate a new orders document.
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

public class XMLBeansExample3 {
    static OrdersDocument doc;
    static String customerID = null;
    
    /**
     * The main method parses and validates the document specified
     * in the parameter and on success deletes the specified
     * customer's orders. It then generates a new orders document.
     */
    public static void main(String[] args)
    throws org.apache.xmlbeans.XmlException, java.io.IOException {
        // store the command line argument
        customerID = args[1];
        // Validate the input XML document
        
        if (validate(args[0])) {
            // Delete customer order
            deleteCustomerOrder();
            // Save the contents to new XML document
            saveXML();
        }
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
     * This method locates and deletes the customer record from the
     * list of orders loaded in memory structure
     */
    public static void deleteCustomerOrder() {
        
        // get a reference to Orders instance
        Orders orders = doc.getOrders();
        
        // Get a list of customers from Orders instance
        Customer[] customers = orders.getCustomerArray();
        
        // iterate through customer list
        for (int i=0; i<customers.length; i++) {
            // Check for the desired customer ID
            if (customers[i].getID().equals(customerID)) {
                System.out.println("Customer " + customerID + " Found");
                // Remove the customer record from the orders list
                orders.removeCustomer(i);
            }
        }
    }
    
    /**
     * This method saves the modified in-memory document to a physical file
     */
    public static void saveXML() {
        // Set options for saving the document
        XmlOptions xmlOptions = new XmlOptions();
        xmlOptions.setSavePrettyPrint();
        
// Create a new file for outputting memory document
        File f = new File("test.xml");
        
        try{
            // Save the document
            doc.save(f,xmlOptions);
        } catch(java.io.IOException e){
            e.printStackTrace();
        }
        System.out.println("\nXML Instance Document saved at : " + f.getPath());
        
    }
}
