package StockClient;

import java.net.*;
import java.util.*;
import org.apache.soap.*;
import org.apache.soap.rpc.*;
import java.util.Vector;
import java.lang.Object;
import java.lang.String;
//import org.apache.soap.rpc.Parameter;

public class StockQuoteRequest {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: java StockQuoteRequest symbol");
            System.exit(1);
        }
	
        String ServiceURL = "http://localhost:8080/soap/servlet/rpcrouter";
        URL url = new URL(ServiceURL);
        String symbol = args[0];
		
		// Build the call.
        Call call = new Call();
        call.setTargetObjectURI("urn:QuoteService");
        call.setMethodName("getStockQuote");
        call.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
        Vector params = new Vector();
		synchronized (call)
		{
			try
			{
				params.addElement(new Parameter("symbol", String.class, symbol, null));
			}
			catch (Exception e) { }
		}
        call.setParams(params);

        Response resp = call.invoke(/* router URL */ url, /* actionURI */ "" );

        // Check the response.
        if (resp.generatedFault())
        {
            Fault fault = resp.getFault();

            System.err.println("Generated fault: " + fault);
        } else {
            Parameter result = resp.getReturnValue();
            System.out.println(symbol + " last trade: $" + result.getValue());
        }
    }
}
