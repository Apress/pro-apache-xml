/**
 * This example uses Schema-Compiler generated classes to count
 * the number of customers whose orders are present in the
 * specified Orders.xml document.
 */

package apress.apacheXML.ch02;

import org.apache.xmlbeans.*;
import com.apress.apacheXML.*;
import com.apress.apacheXML.OrdersDocument.*;
import com.apress.apacheXML.OrdersDocument.Orders.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class XMLBeansExample1 {
    static OrdersDocument doc;
    
    /**
     * The main method parses and validates the document specified
     * in the parameter and on success counts the number of occurences of
     * Customer element.
     */
    public static void main(String[] args)
    throws org.apache.xmlbeans.XmlException, java.io.IOException {
        if (validate(args[0]))
            countCustomers();
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
    
    // Counts the total number of customers
    public static void countCustomers() {
        // get a reference to Orders instance
        Orders orders = doc.getOrders();
        // Determine the customer count from the array size
        System.out.println("Customer count: " + orders.sizeOfCustomerArray());
    }
}
