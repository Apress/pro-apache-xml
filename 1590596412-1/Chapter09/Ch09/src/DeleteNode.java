/*
 * The DeleteNode application deletes the order for the specified customer
 * at a specified date from our DailyOrders collection.
 * The date is specified as a first command-line parameter in the format
 * MMDDYYYY. The second parameter specifies the customer ID in integer format.
 * To run the application, use
 * c:\>java database.DeleteNode 01022006 5
 */

package database;

import org.xmldb.api.base.*;
import org.xmldb.api.modules.*;
import org.xmldb.api.*;
import java.io.*;

/*
 * @Author=Poornachandra Sarang
*/

public class DeleteNode {
    public static void main(String[] args) throws Exception {
        Collection col = null;
        // Check arguments
        if (args.length != 2) {
            System.out.println("Usage: java DeleteNode CustomerID");
            System.exit(1);
        }
        try {
            // Load driver class
            String driver = "org.apache.xindice.client.xmldb.DatabaseImpl";
            Class c = Class.forName(driver);

            // Create and register database instance
            Database database = (Database) c.newInstance();
            DatabaseManager.registerDatabase(database);
            // Retrieve a referece to DailyOrders collection
            col = DatabaseManager.getCollection
                    ("xmldb:xindice:///db/StockBrokerage/DailyOrders");
            // Construct a Remove query
            String xupdate =
                    "<xu:modifications version=\"1.0\"" +
                    " xmlns:xu=\"http://www.xmldb.org/xupdate\">\n" +
                    " <xu:remove " +
                    "select=\"/customers[@date='" +
                    args[0] +
                    "']/customer[@ID=" +
                    args[1] +
                    "]\"/>"
                    + "\n</xu:modifications>";
            // Obtain a reference to the update query service
            XUpdateQueryService service =
                    (XUpdateQueryService)col.getService
                    ("XUpdateQueryService", "1.0");
            // Run the query using the service
            System.out.println("Running Remove Query: ");
            System.out.println(xupdate);
            service.update(xupdate);
        } catch (XMLDBException e) {
            System.err.println("XML:DB Exception occured " + e.errorCode + " " +
                    e.getMessage());
        } finally {
            // Close the collection
            if (col != null) {
                col.close();
            }
        }
    }
}



