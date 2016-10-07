
/**Translets - this program creates translet based on
 * OrderProcessing.xslt and performs transformation on
 * CustomerOrders.xml.The result of this transformation
 * is produced in SortedOrders.html.
 * The result of transformation on CustomerOrders1.xml is
 * produced in SortedOrders1.html
 */



/**
 *
 * @author Dr Sarang
 */


package xslt;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.Templates;
import java.lang.String;



public class Translets
{

    public static void main(String args[]) {

        // Set the TransformerFactory system property to generate and use translets.

        Properties props = System.getProperties();
        props.put("javax.xml.transform.TransformerFactory",
        	"org.apache.xalan.xsltc.trax.TransformerFactoryImpl");
        System.setProperties(props);

        try {
            // Instantiate the TransformerFactory
            TransformerFactory tFactory = TransformerFactory.newInstance();
            // Create a translet based on the specified XSLT file
            Templates translet = tFactory.newTemplates
            	(new StreamSource("OrderProcessing.xslt"));

            // Perform transformations
            Transformer transformer = translet.newTransformer();
            transformer.transform
            	( new StreamSource("CustomerOrders.xml"),
            	new StreamResult(new FileOutputStream
            	("SortedOrders.html")));

            System.out.println("Produced SortedOrders.html");

            transformer.transform(
				new StreamSource("CustomerOrders1.xml"),
				new StreamResult(new FileOutputStream("SortedOrders1.html")));

            System.out.println("Produced SortedOrders1.html");
        }
	catch (Exception e) {
            e.printStackTrace();
        }
    }
}
