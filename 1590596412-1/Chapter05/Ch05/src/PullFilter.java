
/**PullFilter-Filter the data using three filters.
  *Manager Filter sorts all the orders in ascending order
  *of customers.
  *Message Manager Approved is printed on screen.
  *Broker Filter pulls the data from Manager Filter and
  *adds Broker tag to the nodes which has Manager tag.
  *Message Broker Approved is printed on screen.
  *Brokerage filter Pulls the data from Broker filter and
  *adds Brokerage tag to the nodes which has Broker tag.
  *Message Brokerage Approved is printed on screen.
  */



/**
 * @author Dr Sarang
 */

package xslt;

import org.apache.xml.serializer.Serializer;
import org.apache.xml.serializer.SerializerFactory;
import org.apache.xml.serializer.OutputPropertiesFactory;
import java.io.IOException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamSource;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLFilter;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class PullFilter {
    public static void main(String[] args)
    throws TransformerException, TransformerConfigurationException,
            SAXException, IOException {
        // Instantiate a TransformerFactory.
        SAXTransformerFactory saxTFactory =
        	((SAXTransformerFactory) TransformerFactory.newInstance());

        // Create an XMLFilter for each stylesheet.
        XMLFilter ManagerFilter =
        	saxTFactory.newXMLFilter(new StreamSource("Manager.xslt"));
        XMLFilter BrokerFilter =
        	saxTFactory.newXMLFilter(new StreamSource("Broker.xslt"));
        XMLFilter HouseFilter =
        	saxTFactory.newXMLFilter(new StreamSource("Brokerage.xslt"));

        // Create an XMLReader.
        XMLReader reader = XMLReaderFactory.createXMLReader();

        // ManagerFilter uses the XMLReader as its reader.
        ManagerFilter.setParent(reader);

        // BrokerFilter uses ManagerFilter as its reader.
        BrokerFilter.setParent(ManagerFilter);

        // HouseFilter uses BrokerFilter as its reader.
        HouseFilter.setParent(BrokerFilter);

        // HouseFilter outputs SAX events to the serializer.
        java.util.Properties xmlProps =
        	OutputPropertiesFactory.getDefaultMethodProperties("xml");
        Serializer serializer = SerializerFactory.getSerializer(xmlProps);
        serializer.setOutputStream(System.out);
        HouseFilter.setContentHandler(serializer.asContentHandler());

        HouseFilter.parse(new InputSource("CustomerOrders.xml"));
    }
}
