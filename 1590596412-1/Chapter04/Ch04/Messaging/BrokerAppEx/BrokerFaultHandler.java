/*
 * BrokerFaultHandler.java
 */

package StockBroker;

import org.apache.soap.*;
import org.apache.soap.rpc.SOAPContext;
import org.apache.soap.server.*;

/* The custom Fault Handler implements SOAPFaultListener interface 
 */

public class BrokerFaultHandler implements SOAPFaultListener {
    
    /** Creates a new instance of BrokerFaultHandler */
    public BrokerFaultHandler() {
    }
    
    /* fault method receives SOAPFaultEvent object that may
     * be manipulated by the method
     */
    public void fault(SOAPFaultEvent evt) {
        Fault ft = evt.getFault();
        ft.setFaultString("Application Exception: Exceeded Credit Limit");
    }
}
