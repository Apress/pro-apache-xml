/*
 * The UpdateNode application udpates a specific record in the pre-specified
 * order file. It simply changes the stock code in the Order element to
 * a new value.
 * To run the application, use
 * c:\>java database.UpdateNode
 */

package database;

import org.xmldb.api.base.*;
import org.xmldb.api.modules.*;
import org.xmldb.api.*;
import java.io.*;

/*
 * @Author=Poornachandra Sarang
*/

public class UpdateNode {
    public static void main(String[] args) throws Exception {
        Collection col = null;
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
            // Construct a update query
            String xupdate = "<xu:modifications version=\"1.0\"" +
                    " xmlns:xu=\"http://www.xmldb.org/xupdate\">\n" +
                    "     <xu:update select=" +
                    "\"/customers[@date='01022006']/customer[@ID=1]/order\">\n"
                    + "         IKJ" +
                    "\n     </xu:update>\n" +
                    "</xu:modifications>";
            // Obtain a reference to the update query service
            XUpdateQueryService service =
                    (XUpdateQueryService)col.getService
                    ("XUpdateQueryService", "1.0");
            // Run the query using the service
            System.out.println("Running Update Query: ");
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





