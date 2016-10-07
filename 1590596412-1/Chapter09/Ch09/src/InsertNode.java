/*
 * The InsertNode application inserts a customer node
 * after a specified customer in our DailyOrders collection.
 * The parameter specifies the customer ID after which a new customer
 * node will be inserted.
 * To run the application, use
 * c:\>java database.InsertNode
 */

package database;

import org.xmldb.api.base.*;
import org.xmldb.api.modules.*;
import org.xmldb.api.*;
import java.io.*;

/*
 * @Author=Poornachandra Sarang
*/

public class InsertNode {
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
            // Construct a Remove query
            String xupdate = "<xu:modifications version=\"1.0\"" +
                    "      xmlns:xu=\"http://www.xmldb.org/xupdate\">\n" +
                    "   <xu:insert-after select=\"/customers/customer[@ID=17]\">\n" +
                    "        <xu:element name=\"customer\">\n"+
                    "            <xu:attribute name=\"id\">2</xu:attribute>\n"+
                    "            <name>pradeep</name>\n"+
                    "            <order>IBM</order>\n"+
                    "            <quantity>50</quantity>\n"+
                    "            <price>25.22</price>\n"+
                    "        </xu:element>\n" +
                    "    </xu:insert-after>\n"+
                    "</xu:modifications>";
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




