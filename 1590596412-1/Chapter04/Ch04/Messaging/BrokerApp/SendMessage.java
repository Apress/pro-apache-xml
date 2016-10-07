package StockClient;

import java.io.*;
import java.net.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import org.apache.soap.*;
import org.apache.soap.messaging.*;
import org.apache.soap.transport.*;
import org.apache.soap.util.xml.*;

public class SendMessage {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println
                    ("Usage: java SendMessage SOAP-router-URL envelope-file");
            System.exit(1);
        }

        // Read input XML document file
        FileReader reader = new FileReader(args[1]);
        // Build document tree
        DocumentBuilder builder = XMLParserUtils.getXMLDocBuilder();
        Document doc = builder.parse(new InputSource(reader));
        if (doc == null) {
            throw new SOAPException(Constants.FAULT_CODE_CLIENT, "parsing error");
        }
        // get SOAP Envelope
        Envelope msgEnv = Envelope.unmarshall(doc.getDocumentElement());

        // send the message
        Message msg = new Message();
        msg.send(new URL(args[0]), "urn:action-uri", msgEnv);

        // receive response
        SOAPTransport st = msg.getSOAPTransport();
        BufferedReader br = st.receive();
        // Dump the response to user screen
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
}
