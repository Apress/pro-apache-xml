
/*
 * Deletecollection - deletes a collection names Brokerage
 * You should have a collection Brokerage in your root database
 * To run use the command
 * c:\>java DeleteCollection
 */

package StockBrokerage;

import org.xmldb.api.base.*;
import org.xmldb.api.modules.*;
import org.xmldb.api.*;
import org.apache.xindice.client.xmldb.services.*;
import org.apache.xindice.xml.dom.*;

/*
 * @Author=Poornachandra Sarang
*/

public class DeleteCollection {
    public static void main(String[] args) throws Exception {
        Collection col = null;
        try {
            // Load the database driver
            String driver = "org.apache.xindice.client.xmldb.DatabaseImpl";
            Class c = Class.forName(driver);

            // Create a Database instance and register it to the DatabaseManager
            Database database = (Database) c.newInstance();
            DatabaseManager.registerDatabase(database);

            // Get the reference to the root collection
            col = DatabaseManager.getCollection("xmldb:xindice:///db");

            // Set up name for the new collection
            String collectionName = "Brokerage";

            // Obtain an instance
            CollectionManager service = (CollectionManager)
            col.getService("CollectionManager", "1.0");

            service.removeCollection(collectionName);

            System.out.println("Collection " + collectionName + " removed.");
        } catch (XMLDBException e) {
            System.err.println("XML:DB Exception occured " +
                    e.getLocalizedMessage());
        } finally {
            if (col != null) {
                col.close();
            }
        }
    }
}


