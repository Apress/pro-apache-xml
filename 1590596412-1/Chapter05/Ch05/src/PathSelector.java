

/** PathSelector-PathSelector accepts XMLFile as first argument
 * and XPath query as second argument.
 * A node list is created using XPathAPI.
 * All the selected nodes are printed on screen.
 */


/**
 *
 * @author Dr Sarang
 */

package xslt;

import com.sun.org.apache.xpath.internal.XPathAPI;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.NodeIterator;
import org.xml.sax.InputSource;
import org.apache.xpath.CachedXPathAPI;


public class PathSelector{
    public static void main(String[] args)throws Exception {
		if(args.length != 2)
		{
			System.out.println("Usage:java xslt.PathSelector XMLFileName XPathQuery");
			System.exit(1);
		}
        String filename = null;
        String xpath = null;
        filename = args[0];
        System.out.println (filename);
        xpath = args[1];

        // Set up a DOM tree to query.
        InputSource in = new InputSource(new FileInputStream(filename));
        DocumentBuilderFactory dfactory = DocumentBuilderFactory.newInstance();
        dfactory.setNamespaceAware(true);
        Document doc = dfactory.newDocumentBuilder().parse(in);

        // Set up transformer.
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

        // Use the simple XPath API to select a nodeIterator.
        System.out.println("Querying DOM using "+ xpath);
        CachedXPathAPI path = new CachedXPathAPI();
        NodeIterator nl = path.selectNodeIterator(doc, xpath);

        // Serialize the found nodes to System.out
        System.out.println("<output>");

        Node n;
        while ((n = nl.nextNode())!= null){
            transformer.transform(new DOMSource(n),
            	new StreamResult(new OutputStreamWriter(System.out)));
        		System.out.print("\n\n");
        }
        System.out.println("</output>");
    }
}
