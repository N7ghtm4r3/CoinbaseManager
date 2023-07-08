package com.tecknobit.coinbasemanager.exchangepro.addressbook.records;

import com.tecknobit.coinbasemanager.exchangepro.records.CoinbaseItem;
import org.json.JSONObject;

/**
 * The {@code AddressBookAdded} class is useful to format a {@code Coinbase}'s address book added
 *
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://docs.cloud.coinbase.com/exchange/reference/exchangerestapi_postaddressbook">
 * Add address</a>
 * @see CoinbaseItem
 * @see AddressBookItem
 */
public class AddressBookAdded extends AddressBookItem {

    /**
     * {@code addressInfo} info of the address
     */
    private final AddressBookInfo addressInfo;

    /**
     * {@code displayAddress} the display address of the address
     */
    private final String displayAddress;

    /**
     * {@code trusted} whether the address is trusted
     */
    private final boolean trusted;

    /**
     * {@code addressBooked} whether the address has been booked
     */
    private final boolean addressBooked;

    /**
     * {@code addressBookEntryPendingUntil} address book entry pending until value
     */
    private final String addressBookEntryPendingUntil;

    /**
     * Constructor to init a {@link AddressBookAdded} object
     *
     * @param id:                           id of the address book added
     * @param address:                      address of the address book added
     * @param currency:                     currency of the address book added
     * @param label:                        label/nickname for address book entry
     * @param addressBookAddedAt:           when the address book has been added
     * @param lastUsed:                     when the address book has been used for the last time
     * @param addressInfo:                  info of the address
     * @param displayAddress:               the display address of the address
     * @param trusted:                      whether the address is trusted
     * @param addressBooked:                whether the address has been booked
     * @param addressBookEntryPendingUntil: address book entry pending until value
     */
    public AddressBookAdded(String id, String address, String currency, String label, String addressBookAddedAt,
                            String lastUsed, AddressBookInfo addressInfo, String displayAddress, boolean trusted,
                            boolean addressBooked, String addressBookEntryPendingUntil) {
        super(id, address, currency, label, addressBookAddedAt, lastUsed);
        this.addressInfo = addressInfo;
        this.displayAddress = displayAddress;
        this.trusted = trusted;
        this.addressBooked = addressBooked;
        this.addressBookEntryPendingUntil = addressBookEntryPendingUntil;
    }

    /**
     * Constructor to init a {@link AddressBookAdded} object
     *
     * @param id:                           id of the address book added
     * @param address:                      address of the address book added
     * @param destinationTag:               field for destination tag/memo for supported currencies. Ensure destination tag/memo is
     *                                      provided if sending to the address requires it
     * @param currency:                     currency of the address book added
     * @param label:                        label/nickname for address book entry
     * @param addressBookAddedAt:           when the address book has been added
     * @param lastUsed:                     when the address book has been used for the last time
     * @param addressInfo:                  info of the address
     * @param displayAddress:               the display address of the address
     * @param trusted:                      whether the address is trusted
     * @param addressBooked:                whether the address has been booked
     * @param addressBookEntryPendingUntil: address book entry pending until value
     */
    public AddressBookAdded(String id, String address, String destinationTag, String currency, String label,
                            String addressBookAddedAt, String lastUsed, AddressBookInfo addressInfo, String displayAddress,
                            boolean trusted, boolean addressBooked, String addressBookEntryPendingUntil) {
        super(id, address, destinationTag, currency, label, addressBookAddedAt, lastUsed);
        this.addressInfo = addressInfo;
        this.displayAddress = displayAddress;
        this.trusted = trusted;
        this.addressBooked = addressBooked;
        this.addressBookEntryPendingUntil = addressBookEntryPendingUntil;
    }

    /**
     * Constructor to init a {@link AddressBookAdded} object
     *
     * @param jAddressBookAdded: address book added details as {@link JSONObject}
     */
    public AddressBookAdded(JSONObject jAddressBookAdded) {
        super(jAddressBookAdded);
        addressInfo = new AddressBookInfo(hItem.getJSONObject("address_info"));
        displayAddress = hItem.getString("display_address");
        trusted = hItem.getBoolean("trusted");
        addressBooked = hItem.getBoolean("address_booked");
        addressBookEntryPendingUntil = hItem.getString("address_book_entry_pending_until");
    }

    /**
     * Method to get {@link #addressInfo} instance <br>
     * No-any params required
     *
     * @return {@link #addressInfo} instance as {@link AddressBookInfo}
     */
    public AddressBookInfo getAddressInfo() {
        return addressInfo;
    }

    /**
     * Method to get {@link #displayAddress} instance <br>
     * No-any params required
     *
     * @return {@link #displayAddress} instance as {@link String}
     */
    public String getDisplayAddress() {
        return displayAddress;
    }

    /**
     * Method to get {@link #trusted} instance <br>
     * No-any params required
     *
     * @return {@link #trusted} instance as boolean
     */
    public boolean isTrusted() {
        return trusted;
    }

    /**
     * Method to get {@link #addressBooked} instance <br>
     * No-any params required
     *
     * @return {@link #addressBooked} instance as boolean
     */
    public boolean isAddressBooked() {
        return addressBooked;
    }

    /**
     * Method to get {@link #addressBookEntryPendingUntil} instance <br>
     * No-any params required
     *
     * @return {@link #addressBookEntryPendingUntil} instance as {@link String}
     */
    public String getAddressBookEntryPendingUntil() {
        return addressBookEntryPendingUntil;
    }

    /**
     * The {@code AddressBookInfo} class is useful to format a {@code Coinbase}'s address book info
     *
     * @author N7ghtm4r3 - Tecknobit
     * @see CoinbaseItem
     */
    public static class AddressBookInfo extends CoinbaseItem {

        /**
         * {@code address} value
         */
        private final String address;

        /**
         * {@code displayAddress} the display address
         */
        private final String displayAddress;

        /**
         * {@code destinationTag} the destination tag
         */
        private final String destinationTag;

        /**
         * Constructor to init a {@link AddressBookInfo} object
         *
         * @param address:        address value
         * @param displayAddress: the display address
         * @param destinationTag: the destination tag
         */
        public AddressBookInfo(String address, String displayAddress, String destinationTag) {
            super(null);
            this.address = address;
            this.displayAddress = displayAddress;
            this.destinationTag = destinationTag;
        }

        /**
         * Constructor to init a {@link AddressBookInfo} object
         *
         * @param jAddressBookInfo: address book info details as {@link JSONObject}
         */
        public AddressBookInfo(JSONObject jAddressBookInfo) {
            super(jAddressBookInfo);
            address = hItem.getString("address");
            displayAddress = hItem.getString("display_address");
            destinationTag = hItem.getString("destination_tag");
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
         * Method to get {@link #displayAddress} instance <br>
         * No-any params required
         *
         * @return {@link #displayAddress} instance as {@link String}
         */
        public String getDisplayAddress() {
            return displayAddress;
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

    }

}
