package apress.apacheXML.ch02;

import java.io.*;
import org.w3c.dom.*;
import org.xml.sax.*; // DOM parser uses SAX methods

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

public class DOMExample2 {
    static String CustomerID;
    
    // application main method
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: DOMExample2 Filename CustomerID");
            System.exit(1);
        }
        
        // Store the received customer ID in a local variable
        CustomerID = args[1];
        // Construct an in-memory document instance
        Document doc = BuildTree(args[0]);
        // Locate and modify the order for the specified customer
        updateOrder(doc);
    }
    
    /**
     * The BuildTree method parses the received document and creates an
     in-memory instance.
     */
    public static Document BuildTree(String fileName) {
        Document doc;
        try {
            // Obtain Factory instance
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            // Request parser to ignore white space in the document
            dbf.setIgnoringElementContentWhitespace(true);
            // Obtain DocumentBuilder instance from the factory object
            DocumentBuilder db = dbf.newDocumentBuilder();
            // Parse the input file
            doc = db.parse(new File(fileName));
            // return reference to the root node
            return doc;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
          /* The LocateAndUpdateTrade method receives the node containing the 
           desired customer. It searches this node recursively for TradeType 
           element. Once located it modifies its contents.
           */
    public static void LocateAndUpdateTrade(Node node) {
        Node nn = null;
        // Get list of child nodes
        NodeList nl = node.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            nn = nl.item(i);
            // Check if node name matches TradeType node
            if (nn.getNodeName().equals("TradeType")) {
                // The first child of this node contains the trade type
                Node nd = nn.getFirstChild();
                System.out.println("Current Trade Type: "
                        + nd.getNodeValue());
                // Set the trade type to sell
                nd.setNodeValue("S");
                System.out.println("New Trade Type: "
                        + nd.getNodeValue());
            }
            // recursively traverse the tree
            LocateAndUpdateTrade(nn);
        }
    }
    
  /* The searchCustomer receives a node as an argument. The method obtains the
     attributes of the current node and checks if it matches the desired
     customer.
   */
    public static void searchCustomer(Node node) {
        // check if element contains the attributes
        if (node.getAttributes() != null) {
            // Get the list of attributes
            NamedNodeMap nmdrp = node.getAttributes();
            if ((nmdrp.item(0) != null))
                // Check if the attribute is CustomerID
                if (nmdrp.item(0).getNodeValue().equals(CustomerID)) {
                // Print its value on user console
                System.out.println("Customer: "
                        + nmdrp.item(0).getNodeValue() + " found");
                // Pass the node to next method for updation
                LocateAndUpdateTrade(node);
                }
        }
    }
    
  /* The UpdateOrder method recursively traveses the tree and passes each
     located Node to searchCustomer method for further processing
   */
    public static void updateOrder(Node node) {
        // Return on presence of leaf node
        if (node == null) {
            return;
        }
        // Pass the current node to searchCustomer method for searching the
        // desired customer.
        searchCustomer(node);
        // Get children of current node
        NodeList children = node.getChildNodes();
        // Iterate through all children nodes recursively
        for (int i = 0; i < children.getLength(); i++)
            updateOrder(children.item(i));
    }
}