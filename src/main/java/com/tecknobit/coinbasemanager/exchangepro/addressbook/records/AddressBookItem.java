package com.tecknobit.coinbasemanager.exchangepro.addressbook.records;

import com.tecknobit.apimanager.formatters.TimeFormatter;
import com.tecknobit.coinbasemanager.exchangepro.records.CoinbaseItem;
import org.json.JSONObject;

/**
 * The {@code AddressBookItem} class is useful to format a {@code Coinbase}'s address book item
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_getaddressbook">
 * Get address book</a>
 * @see CoinbaseItem
 */
public class AddressBookItem extends CoinbaseItem {

    /**
     * {@code id} of the address book item
     */
    protected final String id;

    /**
     * {@code address} value
     */
    protected final String address;

    /**
     * {@code destinationTag} field for destination tag/memo for supported currencies. Ensure destination tag/memo is
     * provided if sending to the address requires it
     */
    protected final String destinationTag;

    /**
     * {@code currency} of the address book item
     */
    protected final String currency;

    /**
     * {@code label} label/nickname for address book entry
     */
    protected final String label;

    /**
     * {@code addressBookAddedAt} when the address book has been added
     */
    protected final String addressBookAddedAt;

    /**
     * {@code lastUsed} when the address book has been used for the last time
     */
    protected final String lastUsed;

    /**
     * Constructor to init a {@link AddressBookItem} object
     *
     * @param address:        address of the address book item
     * @param destinationTag: field for destination tag/memo for supported currencies. Ensure destination tag/memo is
     *                        provided if sending to the address requires it
     * @apiNote this constructor is useful to create a new address
     */
    public AddressBookItem(String address, String destinationTag) {
        this(null, address, destinationTag, null, null, null, null);
    }

    /**
     * Constructor to init a {@link AddressBookItem} object
     *
     * @param id:                 id of the address book item
     * @param address:            address of the address book item
     * @param currency:           currency of the address book item
     * @param label:              label/nickname for address book entry
     * @param addressBookAddedAt: when the address book has been added
     * @param lastUsed:           when the address book has been used for the last time
     */
    public AddressBookItem(String id, String address, String currency, String label, String addressBookAddedAt,
                           String lastUsed) {
        this(id, address, null, currency, label, addressBookAddedAt, lastUsed);
    }

    /**
     * Constructor to init a {@link AddressBookItem} object
     *
     * @param id:                 id of the address book item
     * @param address:            address of the address book item
     * @param destinationTag:     field for destination tag/memo for supported currencies. Ensure destination tag/memo is
     *                            provided if sending to the address requires it
     * @param currency:           currency of the address book item
     * @param label:              label/nickname for address book entry
     * @param addressBookAddedAt: when the address book has been added
     * @param lastUsed:           when the address book has been used for the last time
     */
    public AddressBookItem(String id, String address, String destinationTag, String currency, String label,
                           String addressBookAddedAt, String lastUsed) {
        super(null);
        this.id = id;
        this.address = address;
        this.destinationTag = destinationTag;
        this.currency = currency;
        this.label = label;
        this.addressBookAddedAt = addressBookAddedAt;
        this.lastUsed = lastUsed;
    }

    /**
     * Constructor to init a {@link AddressBookItem} object
     *
     * @param jAddressBookItem: address book item details as {@link JSONObject}
     */
    public AddressBookItem(JSONObject jAddressBookItem) {
        super(jAddressBookItem);
        id = hItem.getString("id");
        address = hItem.getString("address");
        destinationTag = hItem.getString("destination_tag");
        currency = hItem.getString("currency");
        label = hItem.getString("label");
        addressBookAddedAt = hItem.getString("address_book_added_at");
        lastUsed = hItem.getString("last_used");
    }

    /**
     * Method to get {@link #id} instance <br>
     * No-any params required
     *
     * @return {@link #id} instance as {@link String}
     */
    public String getId() {
        return id;
    }

    /**
     * Method to get {@link #address} instance <br>
     * No-any params required
     *
     * @return {@link #address} instance as {@link String}
     */
    public String getAddress() {
        return address;
    }

    /**
     * Method to get {@link #destinationTag} instance <br>
     * No-any params required
     *
     * @return {@link #destinationTag} instance as {@link String}
     */
    public String getDestinationTag() {
        return destinationTag;
    }

    /**
     * Method to get {@link #currency} instance <br>
     * No-any params required
     *
     * @return {@link #currency} instance as {@link String}
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Method to get {@link #label} instance <br>
     * No-any params required
     *
     * @return {@link #label} instance as {@link String}
     */
    public String getLabel() {
        return label;
    }

    /**
     * Method to get {@link #addressBookAddedAt} instance <br>
     * No-any params required
     *
     * @return {@link #addressBookAddedAt} instance as {@link String}
     */
    public String getAddressBookAddedAt() {
        return addressBookAddedAt;
    }

    /**
     * Method to get {@link #addressBookAddedAt} instance <br>
     * No-any params required
     *
     * @return {@link #addressBookAddedAt} instance as long
     */
    public long getAddressBookAddedAtTimestamp() {
        return TimeFormatter.getDateTimestamp(addressBookAddedAt);
    }

    /**
     * Method to get {@link #lastUsed} instance <br>
     * No-any params required
     *
     * @return {@link #lastUsed} instance as {@link String}
     */
    public String getLastUsed() {
        return lastUsed;
    }

    /**
     * Method to get {@link #lastUsed} instance <br>
     * No-any params required
     *
     * @return {@link #lastUsed} instance as long
     */
    public long getLastUsedTimestamp() {
        return TimeFormatter.getDateTimestamp(lastUsed);
    }

}
