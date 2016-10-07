/**FOTransformation-accepts FO file as its first argument
 * and PDF filename as second argument.
 * This program transforms the FO file and produces the result
 * in the PDF file
 */


/**
 *
 * @author Dr Sarang
 */

package xmlfo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.xml.sax.InputSource;
import org.xml.sax.InputSource;

//Logger
import org.apache.avalon.framework.ExceptionUtil;
import org.apache.avalon.framework.logger.Logger;
import org.apache.avalon.framework.logger.ConsoleLogger;

//FOP
import org.apache.fop.apps.Driver;
import org.apache.fop.apps.FOPException;
import org.apache.fop.messaging.MessageHandler;


public class FOTransformation {
    public static void main(String[] args) {
	if(args.length !=2)
	{
		System.out.println("Usage:java FOTransformation FOFileName PDFFileName");
		System.exit(1);
	}
        try {
			//Setup the screen Logger as ConsolLogger
			Logger log = new ConsoleLogger(ConsoleLogger.LEVEL_INFO);

            Driver driver = new Driver();

			driver.setLogger(log);
			MessageHandler.setScreenLogger(log);

            //Setup Renderer (output format)
            driver.setRenderer(Driver.RENDER_PDF);

            //Setup output PDF file
            OutputStream out = new java.io.FileOutputStream(args[1]);
            try {
                driver.setOutputStream(out);
                //Setup input FO file
                InputStream in = new java.io.FileInputStream(args[0]);
                try {
                    driver.setInputSource(new InputSource(in));
                    //Process FO
                    driver.run();
                }
                finally {
                    in.close();
                }
            } finally {
                out.close();
            }
            System.out.println("Output file created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
