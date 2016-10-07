
package stockinfoservice;
/**
 *
 * @author Dr Sarang
 */
public class StockInfo {
    private float TodayHigh;
    private float TodayLow;
    private float CurrBid;
    private float CurrOffer;

    /** Creates a new instance of StockInfo */
    public StockInfo(String Symbol) {
        if (Symbol.equals("IBM")) {
            setTodayHigh(25);
            setTodayLow(20);
            setCurrBid(22);
            setCurrOffer(23);
        } else if (Symbol.equals("MSFT")) {
            setTodayHigh(55);
            setTodayLow(50);
            setCurrBid(52);
            setCurrOffer(53);
        } else {
            setTodayHigh(15);
            setTodayLow(10);
            setCurrBid(12);
            setCurrOffer(13);
        }
    }

    public float getTodayHigh() {
        return TodayHigh;
    }

    public void setTodayHigh(float TodayHigh) {
        this.TodayHigh = TodayHigh;
    }

    public float getTodayLow() {
        return TodayLow;
    }

    public void setTodayLow(float TodayLow) {
        this.TodayLow = TodayLow;
    }

    public float getCurrBid() {
        return CurrBid;
    }

    public void setCurrBid(float CurrBid) {
        this.CurrBid = CurrBid;
    }

    public float getCurrOffer() {
        return CurrOffer;
    }

    public void setCurrOffer(float CurrOffer) {
        this.CurrOffer = CurrOffer;
    }
}

