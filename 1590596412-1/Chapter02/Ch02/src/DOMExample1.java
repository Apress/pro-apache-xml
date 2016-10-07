package apress.apacheXML.ch02;

import java.io.*;
import org.w3c.dom.*;
import org.xml.sax.*;   // DOM parser uses SAX methods

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

public class DOMExample1 {
    static private int count=0;
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: DOMExample1 Filename");
            System.exit(1);
        }
        
        Document doc = BuildTree(args[0]);
        if (doc != null)
            getElement(doc);
        System.out.println("Number of Customers: " + count);
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
    
    /**
     * The getElement method receives a node reference as an argument and traverses
     * the tree recursively taking this reference as the tree root.
     */
    public static void getElement(Node node) {
        // the null value indicates that you have reached a leaf node
        if (node == null) { return; }
        // Increment the count if the node is of type Customer.
        if(node.getNodeName().equals("Customer"))
            count++;
        // Look for children of the current node
        NodeList children = node.getChildNodes();
        // for each child call the function recursively to visit nodes of each child.
        for (int i = 0; i < children.getLength(); i++)
            getElement(children.item(i));
    }
}
