package apress.apacheXML.ch02;

import java.io.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;

/**
 *This class implements SAX Parser
 */
public class SAXExample2 extends DefaultHandler {
    private int count=0;
    private int scripCount=0;
    private String scripSymbol;
    private boolean countQuantity;
    private boolean countSymbol;
    private long Quantity=0;
    
    public static void main(String[] argv) {
        if (argv.length != 2) {
            System.err.println("Usage: SAXExample2 Filename ScripSymbol");
            System.exit(1);
        }
        
        // Create an Object of the SAXExample2 class for SAX event handler
        SAXExample2 saxObject = new SAXExample2();
        saxObject.scripSymbol = argv[1];
        
        // Create an object of SAXParserFactory for validationg purpose.
        SAXParserFactory spfactory = SAXParserFactory.newInstance();
        
        try {
            // Parse the specified ".xml" file
            SAXParser saxParse = spfactory.newSAXParser();
            saxParse.parse(new File(argv[0]), saxObject);
        } catch (SAXParseException spExcept) {
            // Error generated while parsing
            System.out.println("\n** Error occurred while parsing **" + ", line " +
                    spExcept.getLineNumber());
            System.out.println("   " + spExcept.getMessage());
        } catch (SAXException sExcept) {
            // Error generated while initializing the parser.
            Exception Except = sExcept;
            
            if (sExcept.getException() != null) {
                Except = sExcept.getException();
            }
            
            Except.printStackTrace();
        } catch (ParserConfigurationException pcExcept) {
            // Parser with specified options can't be built
            pcExcept.printStackTrace();
        } catch (IOException ioExcept) {
            // I/O error
            ioExcept.printStackTrace();
        } catch (Throwable t) {
            t.printStackTrace();
        }
        System.exit(0);
    }
    
    /**
     * The parser calls this method whenever it encounters END of document
     */
    public void endDocument() throws SAXException {
        // Print the desired information on the user console
        System.out.println("\nNumber of Customers: "+ count);
        System.out.println("Number of " + scripSymbol + " Orders: " + scripCount);
        System.out.println("Total Trade Quantity: " + Quantity);
    }
    
    /**
     * The parser calls this method whenever it encounters START of element
     */
    public void startElement(String namespaceURI, String simpleName, String qualifiedName, Attributes attributeList) throws SAXException {
        if (qualifiedName.equals("Customer"))
            count++;
        // if the qualified name of the current element is Quantity set counting true.
        if (qualifiedName.equals("Quantity"))
            countQuantity = true;
    }
    
    /**
     * The parser calls this method whenever it encounters the END of element
     */
    public void endElement(String namespaceURI, String simpleName, String qualifiedName) throws SAXException {
        // if the current element is Quantity, reset both counting flags
        if (qualifiedName.equals("Quantity")) {
            countQuantity = false;
            countSymbol = false;
        }
    }
    
    /**
     * The parser calls this method whenever it encounters a character data
     * in the document being processed
     */
    public void characters(char[] buff, int offset, int len) throws SAXException {
        // retrieve the string
        String str = new String(buff, offset, len);
        str = str.trim();
        // check if character string matches the desired symbol string
        if (str.equals(scripSymbol)) {
            // set counting true
            countSymbol = true;
            // increment scrip count
            scripCount++;
        }
        // if counting for quantity and symbol both are set true, add count
        // for quantity
        if (countQuantity && countSymbol) {
            Quantity += Integer.parseInt(str.trim());
            countQuantity = false;
        }
    }
    
    /**
     * This overrides the default Error Handler.
     */
    public void error(SAXParseException spExcept) throws SAXParseException {
        throw spExcept;
    }
}