package StockBroker;

import java.util.Vector;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.apache.soap.*;
import org.apache.soap.rpc.SOAPContext;

/* The StockOrderProcessor defines a method called purchaseOrder that
 * is SOAP-aware
 */
public class StockOrderProcessor {
    // purchaseOrder method is a SOAP-method
    public void purchaseOrder(Envelope env, SOAPContext reqCtx,
            SOAPContext resCtx)
            throws Exception {

        // Create variable for storing node values
        String scripName = null;
        String quantity = null;
        String price = null;

        // Extract SOAP body
        Body b = env.getBody();
        // Get all the entries in the body and iterate through the list
        Vector entries = b.getBodyEntries();
        for (int i = 0; i < entries.size(); i++) {
            // get the element
            Element e = (Element) entries.elementAt(i);
            // Read the node name
            String nodeName = e.getNodeName();
            // Check if it is purchaseOrder
            if (nodeName.equals("purchaseOrder")) {
                // Iterate through the list of child nodes
                NodeList children = e.getChildNodes();
                for (int j = 0; j < children.getLength(); j++) {
                    Node n = children.item(j);
                    switch (n.getNodeType()) {
                        // for each type of element node, extract the
                        // text contents into appropriate variable
                        case Node.ELEMENT_NODE:
                            if (n.getNodeName().equals("NYSE:scrip"))
                                scripName = n.getTextContent();
                            else if (n.getNodeName().equals("NYSE:quantity"))
                                quantity = n.getTextContent();
                            else if (n.getNodeName().equals("NYSE:price"))
                                price = n.getTextContent();
                            else
                                throw new Exception("Unknown element: " + n.getNodeName());
                            break;
                        case Node.ATTRIBUTE_NODE:
                            break;
                    }
                }
            }
        }

        // Create a buffer for user response
        StringBuffer response = new StringBuffer(1024);
        // Create SOAP response for the client
        response.append(Constants.XML_DECL)
        .append("<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\">")
        .append("<SOAP-ENV:Body>")
        .append("<purchaseOrderResponse xmlns=\"urn:po-processor\">")
        .append("<return>")
        .append("Thanks, Received Order for ")
        .append(scripName)
        .append(" quantity= ")
        .append(quantity)
        .append(" price= " + price)
        .append("</return>")
        .append("</purchaseOrderResponse>")
        .append("</SOAP-ENV:Body>")
        .append("</SOAP-ENV:Envelope>");

        resCtx.setRootPart(response.toString(), "text/xml");
    }
}
