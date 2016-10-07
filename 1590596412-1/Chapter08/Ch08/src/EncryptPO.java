/*
 * EncryptPO.java
 */
package apress.ApacheXML.ch08;

import java.io.File;
import java.io.FileOutputStream;

import java.security.Key;

import javax.crypto.SecretKey;
import javax.crypto.KeyGenerator;

import org.apache.xml.security.keys.KeyInfo;
import org.apache.xml.security.encryption.XMLCipher;
import org.apache.xml.security.encryption.EncryptedData;
import org.apache.xml.security.encryption.EncryptedKey;
import org.apache.xml.security.utils.Constants;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.OutputKeys;


public class EncryptPO{
    
    static Document createDocument() throws Exception {
        // Obtain an instance of Docuement Builder Factory
        javax.xml.parsers.DocumentBuilderFactory dbf =
                javax.xml.parsers.DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        javax.xml.parsers.DocumentBuilder db = dbf.newDocumentBuilder();
        
        // Create a new document
        Document doc = db.newDocument();
        
        // Create elements
        Element root = doc.createElementNS(null, "PurchaseOrder");
        Element contents = doc.createElementNS(null, "signedContents");
        
        doc.appendChild(root);
        root.appendChild(contents);
        contents.appendChild(doc.createTextNode("\nWe request you to EXECUTE following trades\n"));
        
        // Add Trade details
        Element scrip1 = doc.createElementNS(null, "scrip");
        contents.appendChild(scrip1);
        scrip1.appendChild(doc.createTextNode("GFW"));
        Element quantity1 = doc.createElementNS(null, "quantity");
        contents.appendChild(quantity1);
        quantity1.appendChild(doc.createTextNode("50"));
        Element price1 = doc.createElementNS(null, "price");
        contents.appendChild(price1);
        price1.appendChild(doc.createTextNode("25.35"));
        Element type1 = doc.createElementNS(null, "type");
        contents.appendChild(type1);
        type1.appendChild(doc.createTextNode("B"));
        
        // Add one more Trade
        Element scrip2 = doc.createElementNS(null, "scrip");
        contents.appendChild(scrip2);
        scrip2.appendChild(doc.createTextNode("ABNPRF"));
        Element quantity2 = doc.createElementNS(null, "quantity");
        contents.appendChild(quantity2);
        quantity2.appendChild(doc.createTextNode("100"));
        Element price2 = doc.createElementNS(null, "price");
        contents.appendChild(price2);
        price2.appendChild(doc.createTextNode("24.83"));
        Element type2 = doc.createElementNS(null, "type");
        contents.appendChild(type2);
        type2.appendChild(doc.createTextNode("S"));
        
        return doc;
    }
    
    public static void main(String unused[]) throws Exception {
        org.apache.xml.security.Init.init();
        
        // Create a PO document that we intend to encrypt
        Document document = createDocument();
        
        // Generate a 128 bit AES symmetric key for encryption
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        Key symmetricKey = keyGenerator.generateKey();
        
        // Generate a key (KEK) for encrypting the above symmetric key
        keyGenerator = KeyGenerator.getInstance("DESede");
        Key kek = keyGenerator.generateKey();
        
        // Store the KEK to a file
        File kekFile = new File("SecretKEK");
        FileOutputStream f = new FileOutputStream(kekFile);
        f.write(kek.getEncoded());
        f.close();
        System.out.println(
                "Key encryption key (KEK) stored in " + kekFile.toURL().toString());
        
        // Get a Cipher instance
        XMLCipher keyCipher = XMLCipher.getInstance(XMLCipher.TRIPLEDES_KeyWrap);
        
        // Initialize Cipher for wrapping KEK
        keyCipher.init(XMLCipher.WRAP_MODE, kek);
        
        // Encrypt KEK
        EncryptedKey encryptedKey =
                keyCipher.encryptKey(document, symmetricKey);
        
        // Obtain document root element reference for encypting the document
        Element rootElement = document.getDocumentElement();
        
        // Create and initalize cipher for encyption using our symmetric key
        XMLCipher xmlCipher = XMLCipher.getInstance(XMLCipher.AES_128);
        xmlCipher.init(XMLCipher.ENCRYPT_MODE, symmetricKey);
        
        // Add the document to be signed and the encryption key into
        // a KeyInfo instance
        KeyInfo keyInfo = new KeyInfo(document);
        keyInfo.add(encryptedKey);
        
        // Add the key information to cipher
        EncryptedData encryptedData = xmlCipher.getEncryptedData();
        encryptedData.setKeyInfo(keyInfo);
        
        // This is where actual encryption takes place
        xmlCipher.doFinal(document, rootElement, true);
        
        // Open file for storing encrypted document
        File encryptionFile = new File("encryptedPO.xml");
        f = new FileOutputStream(encryptionFile);
        
        // Create transformer for outputting encrypted document to a stream
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        
        // Perfrom the transformation
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(f);
        transformer.transform(source, result);
        
        f.close();
        System.out.println(
                "Wrote encrypted document to " + encryptionFile.toURL().toString());
    }
}

