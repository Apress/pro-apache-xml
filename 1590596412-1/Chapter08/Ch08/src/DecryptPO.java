/*
 * DecryptPO.java
 */
package apress.ApacheXML.ch08;

import java.io.File;
import java.io.FileOutputStream;
import java.security.Key;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import org.apache.xml.security.encryption.XMLCipher;
import org.apache.xml.security.utils.JavaUtils;
import org.apache.xml.security.utils.EncryptionConstants;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.OutputKeys;

public class DecryptPO {
    
    public static void main(String unused[]) throws Exception {        
        org.apache.xml.security.Init.init();
        
        // Open the encrypted document and build a DOM tree from it
        File f = new File("encryptedPO.xml");
        javax.xml.parsers.DocumentBuilderFactory dbf =
                javax.xml.parsers.DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        javax.xml.parsers.DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(f);
        System.out.println(
                "Encrypted PO loaded from " +
                f.toURL().toString());
        
        // Read encrypted data element 
        Element encryptedDataElement =
                (Element) document.getElementsByTagNameNS(
                EncryptionConstants.EncryptionSpecNS,
                EncryptionConstants._TAG_ENCRYPTEDDATA).item(0);
        
        // Load KEK
        String fileName = "SecretKEK";
        File kekFile = new File(fileName);
        
        // Construct the DES key specs from the file contents
        DESedeKeySpec keySpec = new DESedeKeySpec(
                JavaUtils.getBytesFromFile(fileName));
        
        // Create a key factory instance
        SecretKeyFactory skf = SecretKeyFactory.getInstance("DESede");
        
        // Generate the key from the specs
        Key kek = skf.generateSecret(keySpec);       
        System.out.println(
                "Key encryption key loaded from " + kekFile.toURL().toString());
 
        // Get cipher instance
        XMLCipher xmlCipher = XMLCipher.getInstance();

        // Initialize cipher for decryption 
        xmlCipher.init(XMLCipher.DECRYPT_MODE, null);
        
        // Set the KEK that contains the key for decryption
        xmlCipher.setKEK(kek);
 
        // Perform the acutal decryption
        xmlCipher.doFinal(document, encryptedDataElement);
        
        // Open file for writing in-memory decrypted document 
        File decryptedFile = new File("decryptedPO.xml");
        FileOutputStream fo = new FileOutputStream(decryptedFile);
        
        // Serialize DOM to file using transformations
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(fo);
        transformer.transform(source, result);
        
        fo.close();
        System.out.println(
                "Wrote decrypted PO to " +
                decryptedFile.toURL().toString());       
    }
}
