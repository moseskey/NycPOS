package com.openbravo.pos.customers;

import com.openbravo.pos.util.StringUtils;
import java.io.Serializable;

/** @author adrianromero */

// JG 20 Sep 12 Extended for Postal
// JG 2 Sep 13 Extended for Phone + Email
public class CustomerInfo implements Serializable {

    private static final long serialVersionUID = 9083257536541L;

    /**
     * Customer unique ID
     */
    protected String id;

    /**
     * Customer searchkey
     */
    protected String searchkey;

    /**
     * Customer tax ID
     */
    protected String taxid;

    /**
     *Customer Account Name
     */
    protected String name;

    /**
     * Customer post/zip code
     */
    protected String postal;

    /**
     * Customer Primary telephone
     */
    protected String phone;

    /**
     * Customer Email
     */
    protected String email;

    /**
     * Creates a new instance of UserInfoBasic
     */
    public CustomerInfo(String id) {
        this.id = id;
        this.searchkey = null;
        this.taxid = null;
        this.name = null;
        this.postal = null;
        this.phone = null;
        this.email = null;
    }

    /**
     *
     * @return id string
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @return taxid string
     */
    public String getTaxid() {
        return taxid;
    }

    public void setTaxid(String taxid) {
        this.taxid = taxid;
    }

    /**
     *
     * @return searchkey string
     */
    public String getSearchkey() {
        return searchkey;
    }

    public void setSearchkey(String searchkey) {
        this.searchkey = searchkey;
    }

    /**
     *
     * @return name string
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return postal/zip code string
     */
    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    /**
     *
     * @return Primary Telephone string
     */
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @return email string
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String printTaxid() {
        return StringUtils.encodeXML(taxid);
    }

    public String printName() {
        return StringUtils.encodeXML(name);
    }

    @Override
    public String toString() {
        return getName();
    }
}
