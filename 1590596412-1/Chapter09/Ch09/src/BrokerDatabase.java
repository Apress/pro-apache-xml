
/*
 * BrokerDatabase - Adds a collection named Broker to the root database /db
 * and then it adds subcollections DailyOrders and DailyQuotes to the Broker collection
 * To run use the command
 * c:\>java BrokerDatabase
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

public class BrokerDatabase {
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

            // Build up the Collection XML configuration.
            String collectionConfig =
                    "<collection compressed=\"true\" name=\"" +
                    collectionName + "\">" +
                    " <filer class=" +
                    "\"org.apache.xindice.core.filer.BTreeFiler\" " +
                    "gzip=\"true\"/>" +
                    "</collection>";

            service.createCollection(collectionName,
                    DOMParser.toDocument(collectionConfig));

            System.out.println("Collection " + collectionName + " created.");

            col = DatabaseManager.getCollection("xmldb:xindice:///db/Brokerage");
            collectionName = "DailyQuotes";
            service = (CollectionManager)
            col.getService("CollectionManager", "1.0");

            // Build up the Collection XML configuration.
            collectionConfig =
                    "<collection compressed=\"true\" name=\"" +
                    collectionName + "\">" +
                    " <filer class=" +
                    "\"org.apache.xindice.core.filer.BTreeFiler\" " +
                    "gzip=\"true\"/>" +
                    "</collection>";

            service.createCollection(collectionName,
                    DOMParser.toDocument(collectionConfig));

            System.out.println("Collection " + collectionName + " created.");

            collectionName = "DailyOrders";
            // Build up the Collection XML configuration.
            collectionConfig =
                    "<collection compressed=\"true\" name=\"" +
                    collectionName + "\">" +
                    " <filer class=" +
                    "\"org.apache.xindice.core.filer.BTreeFiler\" " +
                    "gzip=\"true\"/>" +
                    "</collection>";

            service.createCollection(collectionName,
                    DOMParser.toDocument(collectionConfig));

            System.out.println("Collection " + collectionName + " created.");
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

