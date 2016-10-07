
/**PushFilter-Filter the data using three filters.
  *Manager Filter sorts all the orders in ascending order
  *of customers and pushes its contents to Broker filter.
  *Message Manager Approved is Printed.
  *Broker Filter adds Broker tag to the nodes which has Manager tag
  *and message Broker Approved is printed.
  *Brokerage filter gets the data pushed by Broker filter and
  *adds Brokerage tag to the nodes which has Broker tag.
  *Message Brokerage Approved is printed.
  */


  /**
   *
   * @author Dr Sarang
  */

package xslt;

import java.io.IOException;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamSource;

import org.apache.xml.serializer.Serializer;
import org.apache.xml.serializer.SerializerFactory;
import org.apache.xml.serializer.OutputPropertiesFactory;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


public class PushFilter{
    public static void main(String[] args)
    throws TransformerException, TransformerConfigurationException,
            SAXException, IOException {
        // Instantiate a TransformerFactory.
        SAXTransformerFactory saxTFactory =
        	((SAXTransformerFactory) TransformerFactory.newInstance());

        // Create a TransformerHandler for each stylesheet.
        TransformerHandler tHandler1 =
        	saxTFactory.newTransformerHandler(new StreamSource("Manager.xslt"));

        TransformerHandler tHandler2 =
        	saxTFactory.newTransformerHandler(new StreamSource("Broker.xslt"));

        TransformerHandler tHandler3 =
        	saxTFactory.newTransformerHandler(new StreamSource("Brokerage.xslt"));

        // Create an XMLReader.
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(tHandler1);
        reader.setProperty("http://xml.org/sax/properties/lexical-handler", tHandler1);

        tHandler1.setResult(new SAXResult(tHandler2));
        tHandler2.setResult(new SAXResult(tHandler3));

        // transformer3 outputs SAX events to the serializer.
        java.util.Properties xmlProps =
        	OutputPropertiesFactory.getDefaultMethodProperties("xml");

        Serializer serializer = SerializerFactory.getSerializer(xmlProps);
        serializer.setOutputStream(System.out);
        tHandler3.setResult(new SAXResult(serializer.asContentHandler()));

        // Parse the XML input document.
        reader.parse("CustomerOrders.xml");
    }
}
