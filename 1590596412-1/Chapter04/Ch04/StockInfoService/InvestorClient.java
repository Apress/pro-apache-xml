
package stockinfoservice;

import java.io.*;
import java.util.*;
import java.net.*;
import org.w3c.dom.*;
import org.apache.soap.util.xml.*;
import org.apache.soap.*;
import org.apache.soap.encoding.*;
import org.apache.soap.encoding.soapenc.*;
import org.apache.soap.rpc.*;

/**
 * @author Dr Sarang
 */
public class InvestorClient {

    public static void main(String[] args) throws Exception {

        if (args.length != 2) {
            System.err.println("Usage:");
            System.err.println(" java stockinfoservice.InvestorClient SOAP-router-URL StockSymbol");
            System.exit(1);
        }

        String encodingStyleURI = Constants.NS_URI_SOAP_ENC;
        URL url = new URL(args[0]);
        String StockSymbol = args[1];
        SOAPMappingRegistry smr = new SOAPMappingRegistry();
        BeanSerializer beanSer = new BeanSerializer();

        // Map the types.
        smr.mapTypes(Constants.NS_URI_SOAP_ENC,
                new QName("urn:xml-stockinfoserver-demo","info"),
                StockInfo.class, beanSer, beanSer);

        // Build the call.
        Call call = new Call();

        call.setSOAPMappingRegistry(smr);
        call.setTargetObjectURI("urn:QuoteService");
        call.setMethodName("getStockInfo");
        call.setEncodingStyleURI(encodingStyleURI);

        Vector params = new Vector();

        params.addElement(new Parameter("Symbol",
                String.class,
                StockSymbol, null));
        call.setParams(params);

        // Invoke the call.
        Response resp;

        try {
            resp = call.invoke(url, "");
        } catch (SOAPException e) {
            System.err.println("Caught SOAPException (" +
                    e.getFaultCode() + "): " +
                    e.getMessage());
            return;
        }

        // Check the response.
        if (!resp.generatedFault()) {
            Parameter ret = resp.getReturnValue();
            stockinfoservice.StockInfo info = (stockinfoservice.StockInfo)ret.getValue();
            System.out.println("Today High: " + info.getTodayHigh());
            System.out.println("Today Low: " + info.getTodayLow());
            System.out.println("Current Bid: " + info.getCurrBid());
            System.out.println("Current Offer: " + info.getCurrOffer());
        } else {
            Fault fault = resp.getFault();
            System.err.println("Generated fault: " + fault);
        }
    }
}
