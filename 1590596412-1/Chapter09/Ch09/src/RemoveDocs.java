/*
 * RemoveDocs - removes all documents within
 * given collection and subcollection starting from the specified collection.
 * To run use the command
 * c:\>java RemoveDocs XPathtoDesiredColletion
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

public class RemoveDocs {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: java RemoveDocs XPathtoDesiredColletion");
            System.exit(1);
        }
        try {
            // Load the database driver
            String driver = "org.apache.xindice.client.xmldb.DatabaseImpl";
            Class c = Class.forName(driver);
            // Create a database instance
            Database database = (Database) c.newInstance();
            // Register the database instance with the Manager
            DatabaseManager.registerDatabase(database);
            // Construct the XPath starting from the root
            String strPath = "xmldb:xindice:///db" + args[0];
            System.out.println("Printing the list of resources at " + strPath);
            // Get the reference to the desired collection
            Collection coll = DatabaseManager.getCollection(strPath);
            // Recursively get a list of sub-collections and documents therein
            RemoveAllDocuments(coll);
        } catch (XMLDBException e) {
            System.err.println("XML:DB Exception occured " + e.errorCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * RemoveAllDocuments accepts a Collection object as an argument and
     * traveses the tree recursively listing all the sub-collections and
     * documents therein.
     */
    private static void RemoveAllDocuments(Collection coll) throws XMLDBException {
        // Get string names of all child collections
        String [] str = coll.listChildCollections();
        // Iterate through the list of sub-collections
        for (int i=0; i<str.length; i++) {
            // Print the sub-collection name
            System.out.println("Collection: " + str[i]);
            // Get a list of resources within each sub-collection
            String [] docs = (coll.getChildCollection(str[i])).listResources();
            // Print the names of document resources within a sub-collection
            for (int j=0; j<docs.length; j++) {
                // Obtain the resource reference
                Resource resource =
                        coll.getChildCollection(str[i]).getResource(docs[j]);
                // Remove the resource
                coll.getChildCollection(str[i]).removeResource(resource);

                System.out.println("Resource " + resource.getId() + "removed");
            }
            // Revisit the function using the sub-collection
            RemoveAllDocuments(coll.getChildCollection(str[i]));
        }
    }
}



