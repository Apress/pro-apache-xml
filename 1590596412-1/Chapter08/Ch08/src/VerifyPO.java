/*
 * VerifyPO.java
 */

package apress.ApacheXML.ch08;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.PublicKey;
import org.apache.xml.security.keys.KeyInfo;
import org.apache.xml.security.samples.utils.resolver.OfflineResolver;
import org.apache.xml.security.signature.XMLSignature;
import org.apache.xml.security.utils.Constants;
import org.apache.xml.security.utils.XMLUtils;
import org.apache.xpath.XPathAPI;
import org.w3c.dom.Element;

/**
 * @author Dr Sarang
 */
public class VerifyPO {
    
    public static void main(String unused[]) {
        
        // Initialize XML security Library
        org.apache.xml.security.Init.init();
        
        // Obtain a builder factory instance
        javax.xml.parsers.DocumentBuilderFactory dbf =
                javax.xml.parsers.DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        dbf.setAttribute("http://xml.org/sax/features/namespaces", Boolean.TRUE);
        
        try {
            // Open the file to be verified
            File f = new File("PO.xml");
            System.out.println("Trying to verify " + f.toURL().toString());
            
            // Create a document builder
            javax.xml.parsers.DocumentBuilder db = dbf.newDocumentBuilder();
            db.setErrorHandler(new org.apache.xml.security.utils.IgnoreAllErrorHandler());
            
            // parse the input document
            org.w3c.dom.Document doc = db.parse(new java.io.FileInputStream(f));
            
            // Look for the Signature element in the required namespace
            Element nscontext = XMLUtils.createDSctx(doc, "ds",
                    Constants.SignatureSpecNS);
            Element sigElement = (Element) XPathAPI.selectSingleNode(doc,
                    "//ds:Signature[1]", nscontext);
            
            // Create signature element
            XMLSignature signature = new XMLSignature(sigElement,
                    f.toURL().toString());
            
            // Add a resource resolver to enable the retrieval of resources
            signature.addResourceResolver(new OfflineResolver());
            
            // Retrieve the key information
            KeyInfo ki = signature.getKeyInfo();
            
            if (ki != null) {
                // Retrieve the public key from key information
                PublicKey pk = signature.getKeyInfo().getPublicKey();
                if (pk != null) {
                    boolean result = signature.checkSignatureValue(pk);
                    String str = null;
                    if (result)
                        str = "The document " + f.toURL().toString() + " is valid!";
                    else
                        str = "The document " + f.toURL().toString() + " is invalid!";
                    System.out.println(str);
                } else {
                    System.out.println("No public key found for document verification");
                }
            } else {
                System.out.println("Missing KeyInfo");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

