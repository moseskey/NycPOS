package com.openbravo.pos.sales;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.DataRead;
import com.openbravo.data.loader.DataWrite;
import com.openbravo.data.loader.SerializableRead;
import com.openbravo.data.loader.SerializableWrite;

/**
 *
 * JG - add AppUser
 * JG - Aug 2014 Add Customer
 * Format is CustomerName : Ticket : User
 */
public class SharedTicketInfo implements SerializableRead, SerializableWrite {

    private static final long serialVersionUID = 7640633837719L;
    private String id;
    private String name;
    private String UserName;
    private String CustomerName;

    public SharedTicketInfo() {
    }

    @Override
    public void readValues(DataRead dr) throws BasicException {
        id = dr.getString(1);
        name = dr.getString(2);
        UserName = dr.getString(3);
        CustomerName = dr.getString(4);

    }

    @Override
    public void writeValues(DataWrite dp) throws BasicException {
        dp.setString(1, id);
        dp.setString(2, name);
        dp.setString(3, UserName);
        dp.setString(4, CustomerName);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

// JG Aug 2014 - Add User info

    public String getAppUser() {
        return UserName;
    }
// JG Aug 2014 - Add Customer info

    public String getCustomerName() {
        return CustomerName;
    }
}
