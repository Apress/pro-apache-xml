/*
 * AddDocument - Adds a list of documents within the specified folder
 * and the specified extension to the predefined collection of XML database
 * To run use the command
 * c:\>java AddDocument path extension
 * where path specifies the folder in which documents are stored
 * and extension specifies the document file extension
 */
package database;

import org.xmldb.api.base.*;
import org.xmldb.api.modules.*;
import org.xmldb.api.*;
import java.io.*;
import java.io.File;
import org.apache.xindice.client.xmldb.services.*;
import org.apache.xindice.xml.dom.*;
import java.lang.*;

/*
 * @Author=Poornachandra Sarang
 */
public class AddDocument {
    static AddDocument doc;
    Collection col = null;
    public static void main(String[] args) throws Exception {
        if (args.length != 2)
        {
            System.out.println("Usage: java AddDocument DocsPath extension");
            System.exit(1);
        }
        // Copy the command line arguments
        String path = args[0];
        String ext = args[1];
        try {
            // Create the class instance
            doc = new AddDocument();
            // Obtain the database collection reference
            doc.col = doc.getDatabaseRoot();
            // Add documents to the database
            doc.addFiles(doc.col, path, ext);
        } catch (XMLDBException e) {
            System.err.println("XML:DB Exception occured " + e.errorCode);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the collection
            if (doc.col != null) {
                doc.col.close();
            }
        }
    }

    /*
     * GetDatabaseRoot makes a database connection and returns a reference
     * to the collection given by an XPath expression.
     */
    private Collection getDatabaseRoot() throws XMLDBException, Exception {
        Collection coll;
        // Load the database driver
        String driver = "org.apache.xindice.client.xmldb.DatabaseImpl";
        Class c = Class.forName(driver);
        // Create a database instance
        Database database = (Database) c.newInstance();
        // Register the database instance with the Manager
        DatabaseManager.registerDatabase(database);
        // Obtain a reference to the predefined collection
        coll = DatabaseManager.getCollection
                ("xmldb:xindice:///db/StockBrokerage/DailyOrders");
        // Return the collection reference to the caller
        return coll;
    }

    /*
     * addFiles adds the files to the specified collection from the
     * specified folder and having a specified extension
     */
    private void addFiles(Collection c, String path, String ext)
            throws IOException, Exception {
        // Create a directory object
        File f = new File(path);
        // Get the list of files having the specified extension
        File[] list = f.listFiles(new ExtensionFilter(ext));
        // Iterate through the file collection
        for (int i=0; i<list.length;i++) {
            // Read the file contents into a string buffer
            String data = readFileFromDisk(list[i]);
            // Create a new resource on the specified collection
            XMLResource document =
                    (XMLResource) col.createResource(null,"XMLResource");
            // Set the contents of the created resource
            document.setContent(data);
            // Add the resource to the collection
            col.storeResource(document);
            // Print a message to the user
            System.out.println
                    ("Document " + list[i].getCanonicalFile() + " inserted");
        }
    }

    /*
     * readFromDiskFile reads the contents of the specified File object
     * into a string buffer and returns it to the caller
     */
    public String readFileFromDisk(File fileName) throws IOException {
        // Open an input stream on the given File
        FileInputStream in = new FileInputStream(fileName);
        // Create a buffer for reading file contents
        byte[] fileBuffer = new byte[(int)fileName.length()];
        // Read the file contents into the created buffer
        in.read(fileBuffer);
        // Close the file object
        in.close();
        // Return the buffer to the caller
        return new String(fileBuffer);
    }

    /*
     * ExtensionFilter creates a filter class for selecting the files
     * with the specified extension from a folder. The class implements the
     * accept method of the FilenameFilter interface that filters the files
     * using the specified extension.
     */
    public class ExtensionFilter implements FilenameFilter {
        private String extension ;

        // Constructor that initializes the extension filter
        public ExtensionFilter(String ext) {
            extension="." + ext;
        }
        // The accept method returns files matching the specified extension
        public boolean accept(File dir, String name) {
            return name.endsWith(extension);
        }
    }
}

