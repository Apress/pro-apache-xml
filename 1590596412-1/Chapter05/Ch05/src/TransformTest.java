
/* TransformTest - accepts XSLT file as first argument
 * and XML document as second argument.Then it transforms an
 * XML Source and sends the output to a Result object
 */

/*
 * @Author=Poornachandra Sarang
 */

package xslt;

public class TransformTest {

    public static void main(String[] args) {
		if(args.length != 2)
		{
			System.out.println("Usage:java xslt.Transformtest XSLTFile XMLFile");
			System.exit(1);
		}
        String xsltFile = args[0];
        String xmlFile = args[1];

        // Create a TransformerFactory instance
        javax.xml.transform.TransformerFactory tFactory =
                javax.xml.transform.TransformerFactory.newInstance();

        try {
            // Create a Transformer for the specified stylesheet
            javax.xml.transform.Transformer transformer = tFactory.newTransformer
                    (new javax.xml.transform.stream.StreamSource(xsltFile));

            //Transform an XML Source and send the
            // output to a Result object
            transformer.transform
                    (new javax.xml.transform.stream.StreamSource(xmlFile),
                    new javax.xml.transform.stream.StreamResult( new
                    java.io.FileOutputStream("SortedOrders.html")));
            System.out.println("File SortedOrders.html created in active folder");
        } catch (Exception e){}
    }
}
