package com.tecknobit.coinbasemanager.Managers.ExchangePro.Products.Records;

/**
 * The {@code StatDetails} class is useful to format general StatDetails object
 * @apiNote see official documentation at:
 <ul>
     <li>
         <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats">
            https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproductstats</a>
     </li>
     <li>
         <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades">
            https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getproducttrades</a>
     </li>
 </ul>
 * @author N7ghtm4r3 - Tecknobit
 * **/

public class StatDetails {

    /**
     * {@code tradeId} is instance that memorizes trade identifier value
     * **/
    protected final long tradeId;

    /**
     * {@code price} is instance that memorizes price value
     * **/
    protected final double price;

    /**
     * {@code size} is instance that memorizes size value
     * **/
    protected final double size;

    /**
     * {@code time} is instance that memorizes time value
     * **/
    protected final String time;

    /** Constructor to init a {@link StatDetails} object
     * @param tradeId: trade identifier value
     * @param price: price value
     * @param size: size value
     * @param time: time value
     * **/
    public StatDetails(long tradeId, double price, double size, String time) {
        this.tradeId = tradeId;
        this.price = price;
        this.size = size;
        this.time = time;
    }

    public long getTradeId() {
        return tradeId;
    }

    public double getPrice() {
        return price;
    }

    public double getSize() {
        return size;
    }

    public String getTime() {
        return time;
    }

}
