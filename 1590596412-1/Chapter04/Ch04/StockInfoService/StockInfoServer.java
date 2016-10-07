
package stockinfoservice;

/**
 *
 * @author Dr Sarang
 */
public class StockInfoServer {

   /** Creates a new instance of StockInfoServer */
    public StockInfoServer() {
    }

    public StockInfo getStockInfo(String Symbol) {
        StockInfo info = new StockInfo(Symbol);
        return info;
    }
}
