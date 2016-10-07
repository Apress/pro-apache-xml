

/** XMLTransformation- accepts XMLFile as first argument
 *  and XSLTFile as second argument.
 * After transforming the result is stored in the active
 * folder as Result.pdf.
 */


/**
 * @author Dr Sarang
 */


package xmlfo;

//Java
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

//JAXP
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.Source;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.sax.SAXResult;

import org.apache.avalon.framework.ExceptionUtil;
import org.apache.avalon.framework.logger.Logger;
import org.apache.avalon.framework.logger.ConsoleLogger;

//FOP
import org.apache.fop.apps.Driver;
import org.apache.fop.apps.FOPException;
import org.apache.fop.messaging.MessageHandler;
public class XMLTransformation {

    public static void main(String[] args) {
		if(args.length !=2)
		{
			System.out.println("Usage:java XMLTransformation XMLFileName PDFFileName");
			System.exit(1);
		}
        try {
            //Setup input and output files
            File xmlfile = new File(args[0]);
            File xsltfile = new File(args[1]);


			//Setup the screen Logger as ConsolLogger
			Logger log = new ConsoleLogger(ConsoleLogger.LEVEL_INFO);
           //Construct driver
            Driver driver = new Driver();

			driver.setLogger(log);
			MessageHandler.setScreenLogger(log);

            //Setup Renderer (output format)
            driver.setRenderer(Driver.RENDER_PDF);

            //Setup output in the active folder.
            OutputStream out = new java.io.FileOutputStream("Result.pdf");
            try {
                driver.setOutputStream(out);
                //Setup XSLT
                TransformerFactory factory = TransformerFactory.newInstance();
                Transformer transformer = factory.newTransformer(new StreamSource(xsltfile));

                //Setup input for XSLT transformation
                Source src = new StreamSource(xmlfile);

                //Resulting SAX events (the generated FO) must be piped through to FOP
                Result res = new SAXResult(driver.getContentHandler());

                //Start XSLT transformation and FOP processing
                transformer.transform(src, res);
             }
             finally {
                out.close();
            }
            	System.out.println("Success!");
         }catch (Exception e) {

            e.printStackTrace();
            System.exit(-1);
        }
    }
}
