databaseChangeLog {
  // create initial database schema
  changeSet(author: 'kenneth.shaw@knq.io', id: 'create-schema') {
    // create roles table
    createTable(tableName: 'roles') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'name', type: 'varchar') {
        constraints(nullable: false, unique: true)
      }
      column(name: 'permissions', type: 'blob')
    }

    // create people table
    createTable(tableName: 'people') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'name', type: 'varchar') {
        constraints(nullable: false, unique: true)
      }
      column(name: 'apppassword', type: 'varchar')
      column(name: 'card', type: 'varchar')
      column(name: 'role', type: 'varchar') {
        constraints(nullable: false, references: 'roles', foreignKeyName: 'fk_people_roles')
      }
      column(name: 'visible', type: 'boolean') {
        constraints(nullable: false)
      }
      column(name: 'image', type: 'blob')
    }
    createIndex(tableName: 'people', indexName: 'people_card_idx') {
      column(name: 'card')
    }

    // create resources table
    createTable(tableName: 'resources') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'name', type: 'varchar') {
        constraints(nullable: false, unique: true)
      }
      column(name: 'restype', type: 'integer') {
        constraints(nullable: false)
      }
      column(name: 'content', type: 'blob')
    }

    // create taxcustcategories table
    createTable(tableName: 'taxcustcategories') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'name', type: 'varchar') {
        constraints(nullable: false, unique: true)
      }
    }

    // ceate customers table
    createTable(tableName: 'customers') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'searchkey', type: 'varchar') {
        constraints(nullable: false, unique: true)
      }
      column(name: 'taxid', type: 'varchar')
      column(name: 'name', type: 'varchar') {
        constraints(nullable: false)
      }
      column(name: 'taxcategory', type: 'varchar') {
        constraints(nullable: false, references: 'taxcustcategories', foreignKeyName: 'fk_customers_taxcustcategories')
      }
      column(name: 'card', type: 'varchar')
      column(name: 'maxdebt', type: 'double', defaultValue: 0) {
        constraints(nullable: false)
      }
      column(name: 'address', type: 'varchar')
      column(name: 'address2', type: 'varchar')
      column(name: 'postal', type: 'varchar')
      column(name: 'city', type: 'varchar')
      column(name: 'region', type: 'varchar')
      column(name: 'country', type: 'varchar')
      column(name: 'firstname', type: 'varchar')
      column(name: 'lastname', type: 'varchar')
      column(name: 'email', type: 'varchar')
      column(name: 'phone', type: 'varchar')
      column(name: 'phone2', type: 'varchar')
      column(name: 'fax', type: 'varchar')
      column(name: 'notes', type: 'varchar')
      column(name: 'visible', type: 'boolean', defaultValue: true) {
        constraints(nullable: false)
      }
      column(name: 'curdate', type: 'timestamp')
      column(name: 'curdebt', type: 'double', defaultValue: 0)
      column(name: 'image', type: 'blob')
    }
    createIndex(tableName: 'customers', indexName: 'customers_searchkey_idx') {
      column(name: 'searchkey')
    }
    createIndex(tableName: 'customers', indexName: 'customers_taxid_idx') {
      column(name: 'taxid')
    }
    createIndex(tableName: 'customers', indexName: 'customers_name_idx') {
      column(name: 'name')
    }
    createIndex(tableName: 'customers', indexName: 'customers_card_idx') {
      column(name: 'card')
    }

    // create categories table
    createTable(tableName: 'categories') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'name', type: 'varchar') {
        constraints(nullable: false, unique: true)
      }
      column(name: 'parentid', type: 'varchar') {
        constraints(nullable: false, references: 'categories', foreignKeyName: 'fk_categories_parent')
      }
      column(name: 'image', type: 'blob')
      column(name: 'texttip', type: 'varchar', defaultValue: null)
      column(name: 'catshowname', type: 'boolean', defaultValue: true) {
        constraints(nullable: false)
      }
    }

    // create taxcategories table
    createTable(tableName: 'taxcategories') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'name', type: 'varchar') {
        constraints(nullable: false, unique: true)
      }
    }

    // create taxes table
    createTable(tableName: 'taxes') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'name', type: 'varchar') {
        constraints(nullable: false, unique: true)
      }
      column(name: 'category', type: 'varchar') {
        constraints(nullable: false, references: 'taxcategories', foreignKeyName: 'fk_taxes_taxcategories')
      }
      column(name: 'custcategory', type: 'varchar') {
        constraints(nullable: false, references: 'taxcustcategories', foreignKeyName: 'fk_taxes_taxcustcategories')
      }
      column(name: 'parentid', type: 'varchar') {
        constraints(nullable: false, references: 'taxes', foreignKeyName: 'fk_taxes_parent')
      }
      column(name: 'rate', type: 'double', defaultValue: 0) {
        constraints(nullable: false)
      }
      column(name: 'ratecascade', type: 'boolean', defaultValue: false) {
        constraints(nullable: false)
      }
      column(name: 'rateorder', type: 'integer')
    }

    // create attribute table
    createTable(tableName: 'attribute') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'name', type: 'varchar') {
        constraints(nullable: false)
      }
    }

    // create attributevalue table
    createTable(tableName: 'attributevalue') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'attribute_id', type: 'varchar') {
        constraints(nullable: false, references: 'attribute', foreignKeyName: 'fk_attributevalue_attribute', deleteCascade: true)
      }
    }

    // create attributeset table
    createTable(tableName: 'attributeset') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'name', type: 'varchar') {
        constraints(nullable: false)
      }
    }

    // create attributeuse table
    createTable(tableName: 'attributeuse') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'attributeset_id', type: 'varchar') {
        constraints(nullable: false, references: 'attributeset', foreignKeyName: 'fk_attributeuse_attributeset', deleteCascade: true)
      }
      column(name: 'attribute_id', type: 'varchar') {
        constraints(nullable: false, references: 'attribute', foreignKeyName: 'fk_attributeuse_attribute', deleteCascade: true)
      }
      column(name: 'lineno', type: 'integer')
    }
    createIndex(tableName: 'attributeuse', indexName: 'attributeuse_attributesetid_lineno_idx') {
      column(name: 'attributeset_id')
      column(name: 'lineno')
    }

    // create attributesetinstance table
    createTable(tableName: 'attributesetinstance') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'attributeset_id', type: 'varchar') {
        constraints(nullable: false, references: 'attributeset', foreignKeyName: 'fk_attributesetinstance_attributeset', deleteCascade: true)
      }
      column(name: 'description', type: 'varchar')
    }

    // create attributeinstance table
    createTable(tableName: 'attributeinstance') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'attributesetinstance_id', type: 'varchar') {
        constraints(nullable: false, references: 'attributesetinstance', foreignKeyName: 'fk_attributeinstance_attributesetinstance', deleteCascade: true)
      }
      column(name: 'attribute_id', type: 'varchar') {
        constraints(nullable: false, references: 'attribute', foreignKeyName: 'fk_attributeinstance_attribute', deleteCascade: true)
      }
      column(name: 'value', type: 'varchar')
    }

    // create products table
    createTable(tableName: 'products') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'reference', type: 'varchar') {
        constraints(nullable: false, unique: true)
      }
      column(name: 'code', type: 'varchar') {
        constraints(nullable: false, unique: true)
      }
      column(name: 'codetype', type: 'varchar')
      column(name: 'name', type: 'varchar') {
        constraints(nullable: false, unique: true)
      }
      column(name: 'pricebuy', type: 'double', defaultValue: 0) {
        constraints(nullable: false)
      }
      column(name: 'pricesell', type: 'double', defaultValue: 0) {
        constraints(nullable: false)
      }
      column(name: 'category', type: 'varchar') {
        constraints(nullable: false, references: 'categories', foreignKeyName: 'fk_products_categories')
      }
      column(name: 'taxcat', type: 'varchar') {
        constraints(nullable: false, references: 'taxcategories', foreignKeyName: 'fk_products_taxcategories')
      }
      column(name: 'attributeset_id', type: 'varchar') {
        constraints(references: 'attributeset', foreignKeyName: 'fk_products_attributeset')
      }
      column(name: 'stockcost', type: 'double')
      column(name: 'stockvolume', type: 'double')
      column(name: 'image', type: 'blob')
      ['iscom', 'isscale', 'iskitchen', 'printkb', 'sendstatus', 'isservice'].each { f ->
        column(name: f, type: 'boolean', defaultValue: false) {
          constraints(nullable: false)
        }
      }
      column(name: 'display', type: 'varchar')
      column(name: 'attributes', type: 'blob')
      ['isvprice', 'isverpatrib'].each { f ->
        column(name: f, type: 'boolean', defaultValue: false) {
          constraints(nullable: false)
        }
      }
      column(name: 'texttip', type: 'varchar', defaultValue: '')
      column(name: 'warranty', type: 'boolean', defaultValue: false) {
        constraints(nullable: false)
      }
      column(name: 'stockunits', type: 'double', defaultValue: 0) {
        constraints(nullable: false)
      }
    }

    // create products_cat table
    createTable(tableName: 'products_cat') {
      column(name: 'product', type: 'varchar') {
        constraints(nullable: false, primaryKey: true, references: 'products', foreignKeyName: 'fk_products_cat_products')
      }
      column(name: 'catorder', type: 'integer')
    }
    createIndex(tableName: 'products_cat', indexName: 'products_cat_catorder_idx') {
      column(name: 'catorder')
    }

    // create products_com table
    createTable(tableName: 'products_com') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'product', type: 'varchar') {
        constraints(nullable: false, primaryKey: true, references: 'products', foreignKeyName: 'fk_products_com_products')
      }
      column(name: 'product2', type: 'varchar') {
        constraints(nullable: false, primaryKey: true, references: 'products', foreignKeyName: 'fk_products_com_products2')
      }
    }
    createIndex(tableName: 'products_com', indexName: 'products_com_product_product2_idx', unique: true) {
      column(name: 'product')
      column(name: 'product2')
    }

    // create locations table
    createTable(tableName: 'locations') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'name', type: 'varchar') {
        constraints(nullable: false, unique: true)
      }
      column(name: 'address', type: 'varchar')
    }

    // create stockdiary table
    createTable(tableName: 'stockdiary') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'datenew', type: 'timestamp') {
        constraints(nullable: false)
      }
      column(name: 'reason', type: 'integer') {
        constraints(nullable: false)
      }
      column(name: 'location', type: 'varchar') {
        constraints(nullable: false, references: 'locations', foreignKeyName: 'fk_stockdiary_locations')
      }
      column(name: 'product', type: 'varchar') {
        constraints(nullable: false, references: 'products', foreignKeyName: 'fk_stockdiary_products')
      }
      column(name: 'attributesetinstance_id', type: 'varchar') {
        constraints(nullable: false, references: 'attributesetinstance', foreignKeyName: 'fk_stockdiary_attributesetinstance')
      }
      column(name: 'units', type: 'double') {
        constraints(nullable: false)
      }
      column(name: 'price', type: 'double') {
        constraints(nullable: false)
      }
      column(name: 'appuser', type: 'varchar')
    }
    createIndex(tableName: 'stockdiary', indexName: 'stockdairy_datenew_idx') {
      column(name: 'datenew')
    }

    // create stocklevel table
    createTable(tableName: 'stocklevel') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'location', type: 'varchar') {
        constraints(nullable: false, references: 'locations', foreignKeyName: 'fk_stocklevel_locations')
      }
      column(name: 'product', type: 'varchar') {
        constraints(nullable: false, references: 'products', foreignKeyName: 'fk_stocklevel_products')
      }
      column(name: 'stocksecurity', type: 'double', defaultValue: 0) {
        constraints(nullable: false)
      }
      column(name: 'stockmaximum', type: 'double', defaultValue: 0) {
        constraints(nullable: false)
      }
    }

    // create stockcurrent table
    createTable(tableName: 'stockcurrent') {
      column(name: 'location', type: 'varchar') {
        constraints(nullable: false, references: 'locations', foreignKeyName: 'fk_stockcurrent_locations')
      }
      column(name: 'product', type: 'varchar') {
        constraints(nullable: false, references: 'products', foreignKeyName: 'fk_stockcurrent_products')
      }
      column(name: 'attributesetinstance_id', type: 'varchar') {
        constraints(nullable: false, references: 'attributesetinstance', foreignKeyName: 'fk_stockcurrent_attributesetinstance')
      }
      column(name: 'units', type: 'double', defaultValue: 0) {
        constraints(nullable: false)
      }
    }
    createIndex(tableName: 'stockcurrent', indexName: 'stockcurrent_location_product_attributesetinstance_id_idx', unique: true) {
      column(name: 'location')
      column(name: 'product')
      column(name: 'attributesetinstance_id')
    }

    // create closedcash table
    createTable(tableName: 'closedcash') {
      column(name: 'money', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'host', type: 'varchar') {
        constraints(nullable: false)
      }
      column(name: 'hostsequence', type: 'integer') {
        constraints(nullable: false)
      }
      column(name: 'datestart', type: 'timestamp') {
        constraints(nullable: false)
      }
      column(name: 'dateend', type: 'timestamp')
      column(name: 'nosales', type: 'integer', defaultValue: 0) {
        constraints(nullable: false)
      }
    }
    createIndex(tableName: 'closedcash', indexName: 'closedcash_datestart_idx') {
      column(name: 'datestart')
    }
    createIndex(tableName: 'closedcash', indexName: 'closedcash_host_hostsequence_idx', unique: true) {
      column(name: 'host')
      column(name: 'hostsequence')
    }

    // create receipts table
    createTable(tableName: 'receipts') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'money', type: 'varchar') {
        constraints(nullable: false, references: 'closedcash', foreignKeyName: 'fk_receipts_closedcash')
      }
      column(name: 'datenew', type: 'timestamp') {
        constraints(nullable: false)
      }
      column(name: 'attributes', type: 'blob')
      column(name: 'person', type: 'varchar')
    }
    createIndex(tableName: 'receipts', indexName: 'receipts_datenew_idx') {
      column(name: 'datenew')
    }

    // create tickets table
    createTable(tableName: 'tickets') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true, references: 'receipts', foreignKeyName: 'fk_tickets_receipts')
      }
      column(name: 'tickettype', type: 'integer', defaultValue: 0) {
        constraints(nullable: false)
      }
      column(name: 'ticketid', type: 'integer') {
        constraints(nullable: false)
      }
      column(name: 'person', type: 'varchar') {
        constraints(nullable: false, references: 'people', foreignKeyName: 'fk_tickets_people')
      }
      column(name: 'customer', type: 'varchar') {
        constraints(references: 'customers', foreignKeyName: 'fk_tickets_customers')
      }
      column(name: 'status', type: 'integer', defaultValue: 0) {
        constraints(nullable: false)
      }
    }
    createIndex(tableName: 'tickets', indexName: 'tickets_tickettype_ticketid_idx') {
      column(name: 'tickettype')
      column(name: 'ticketid')
    }
    createSequence(sequenceName: 'ticketsnum', startValue: 1)
    createSequence(sequenceName: 'ticketsnum_refund', startValue: 1)
    createSequence(sequenceName: 'ticketsnum_payment', startValue: 1)

//    // create table
//    createTable(tableName: '') {
//    }
//
//    // create table
//    createTable(tableName: '') {
//    }
//
//    // create table
//    createTable(tableName: '') {
//    }
//    // create table
//    createTable(tableName: '') {
//    }
//
//    // create table
//    createTable(tableName: '') {
//    }
//
//    // create table
//    createTable(tableName: '') {
//    }
//
//    // create table
//    createTable(tableName: '') {
//    }
//
//    // create table
//    createTable(tableName: '') {
//    }

  }
}

//CREATE TABLE TICKETLINES (
//    TICKET VARCHAR NOT NULL,
//    LINE INTEGER NOT NULL,
//    PRODUCT VARCHAR,
//    ATTRIBUTESETINSTANCE_ID VARCHAR,
//    UNITS DOUBLE PRECISION NOT NULL,
//    PRICE DOUBLE PRECISION NOT NULL,
//    TAXID VARCHAR NOT NULL,
//    ATTRIBUTES BYTEA,
//    PRIMARY KEY (TICKET, LINE),
//    CONSTRAINT TICKETLINES_FK_TICKET FOREIGN KEY (TICKET) REFERENCES TICKETS(ID),
//    CONSTRAINT TICKETLINES_FK_2 FOREIGN KEY (PRODUCT) REFERENCES PRODUCTS(ID),
//    CONSTRAINT TICKETLINES_ATTSETINST FOREIGN KEY (ATTRIBUTESETINSTANCE_ID) REFERENCES ATTRIBUTESETINSTANCE(ID),
//    CONSTRAINT TICKETLINES_FK_3 FOREIGN KEY (TAXID) REFERENCES TAXES(ID)
//);





// CREATE TABLE LINEREMOVED (
//  REMOVEDDATE TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
//  NAME VARCHAR DEFAULT NULL,
//  TICKETID VARCHAR DEFAULT NULL,
//  PRODUCTID VARCHAR DEFAULT NULL,
//  PRODUCTNAME VARCHAR DEFAULT NULL,
//  UNITS DOUBLE PRECISION NOT NULL
//);





//CREATE TABLE PAYMENTS (
//    ID VARCHAR NOT NULL,
//    RECEIPT VARCHAR NOT NULL,
//    PAYMENT VARCHAR NOT NULL,
//    TOTAL DOUBLE PRECISION NOT NULL,
//    TRANSID VARCHAR,
//    NOTES VARCHAR,
//    RETURNMSG BYTEA,
//    TENDERED DOUBLE PRECISION DEFAULT 0 NOT NULL,
//    CARDNAME VARCHAR,
//    PRIMARY KEY (ID),
//    CONSTRAINT PAYMENTS_FK_RECEIPT FOREIGN KEY (RECEIPT) REFERENCES RECEIPTS(ID)
//);
//CREATE INDEX PAYMENTS_IDX_1 ON PAYMENTS(PAYMENT);





//CREATE TABLE TAXLINES (
//    ID VARCHAR NOT NULL,
//    RECEIPT VARCHAR NOT NULL,
//    TAXID VARCHAR NOT NULL,
//    BASE DOUBLE PRECISION DEFAULT 0 NOT NULL,
//    AMOUNT DOUBLE PRECISION DEFAULT 0 NOT NULL,
//    PRIMARY KEY (ID),
//    CONSTRAINT TAXLINES_TAX FOREIGN KEY (TAXID) REFERENCES TAXES(ID),
//    CONSTRAINT TAXLINES_RECEIPT FOREIGN KEY (RECEIPT) REFERENCES RECEIPTS(ID)
//);





//CREATE TABLE FLOORS (
//    ID VARCHAR NOT NULL,
//    NAME VARCHAR NOT NULL,
//    IMAGE BYTEA,
//    PRIMARY KEY (ID)
//);
//CREATE UNIQUE INDEX FLOORS_NAME_IDX ON FLOORS(NAME);





//CREATE TABLE PLACES (
//    ID VARCHAR NOT NULL,
//    NAME VARCHAR NOT NULL,
//    X INTEGER NOT NULL,
//    Y INTEGER NOT NULL,
//    FLOOR VARCHAR NOT NULL,
//    CUSTOMER VARCHAR,
//    WAITER VARCHAR,
//    TICKETID VARCHAR,
//    TABLEMOVED BOOLEAN NOT NULL DEFAULT FALSE,
//    PRIMARY KEY (ID),
//    CONSTRAINT PLACES_FK_1 FOREIGN KEY (FLOOR) REFERENCES FLOORS(ID)
//);
//CREATE UNIQUE INDEX PLACES_NAME_IDX ON PLACES(NAME);





//CREATE TABLE RESERVATIONS (
//    ID VARCHAR NOT NULL,
//    CREATED TIMESTAMP NOT NULL,
//    DATENEW TIMESTAMP DEFAULT '2013-01-01 00:00:00' NOT NULL,
//    TITLE VARCHAR NOT NULL,
//    CHAIRS INTEGER NOT NULL,
//    ISDONE BOOLEAN NOT NULL,
//    DESCRIPTION VARCHAR,
//    PRIMARY KEY (ID)
//);
//CREATE INDEX RESERVATIONS_IDX_1 ON RESERVATIONS(DATENEW);





//CREATE TABLE RESERVATION_CUSTOMERS (
//    ID VARCHAR NOT NULL,
//    CUSTOMER VARCHAR NOT NULL,
//    PRIMARY KEY (ID),
//    CONSTRAINT RES_CUST_FK_1 FOREIGN KEY (ID) REFERENCES RESERVATIONS(ID),
//    CONSTRAINT RES_CUST_FK_2 FOREIGN KEY (CUSTOMER) REFERENCES CUSTOMERS(ID)
//);





//CREATE TABLE THIRDPARTIES (
//    ID VARCHAR NOT NULL,
//    CIF VARCHAR NOT NULL,
//    NAME VARCHAR NOT NULL,
//    ADDRESS VARCHAR,
//    CONTACTCOMM VARCHAR,
//    CONTACTFACT VARCHAR,
//    PAYRULE VARCHAR,
//    FAXNUMBER VARCHAR,
//    PHONENUMBER VARCHAR,
//    MOBILENUMBER VARCHAR,
//    EMAIL VARCHAR,
//    WEBPAGE VARCHAR,
//    NOTES VARCHAR,
//    PRIMARY KEY (ID)
//);
//CREATE UNIQUE INDEX THIRDPARTIES_CIF_IDX ON THIRDPARTIES(CIF);
//CREATE UNIQUE INDEX THIRDPARTIES_NAME_IDX ON THIRDPARTIES(NAME);





//CREATE TABLE SHAREDTICKETS (
//    ID VARCHAR NOT NULL,
//    NAME VARCHAR NOT NULL,
//    CONTENT BYTEA,
//    PICKUPID INTEGER NOT NULL DEFAULT 0,
//    APPUSER VARCHAR,
//    PRIMARY KEY (ID)
//);





//-- Added for Employee Presence Management
//CREATE TABLE SHIFTS (
//  ID VARCHAR NOT NULL,
//  STARTSHIFT TIMESTAMP NOT NULL,
//  ENDSHIFT TIMESTAMP,
//  PPLID VARCHAR NOT NULL,
//  PRIMARY KEY (ID)
//);





//CREATE TABLE LEAVES (
//  ID VARCHAR NOT NULL,
//  PPLID VARCHAR NOT NULL,
//  NAME VARCHAR NOT NULL,
//  STARTDATE TIMESTAMP NOT NULL,
//  ENDDATE TIMESTAMP NOT NULL,
//  NOTES VARCHAR,
//  PRIMARY KEY (ID),
//  CONSTRAINT lEAVES_PPLID FOREIGN KEY (PPLID) REFERENCES PEOPLE(ID)
//);





//CREATE TABLE BREAKS (
//  ID VARCHAR NOT NULL,
//  NAME VARCHAR NOT NULL,
//  NOTES VARCHAR,
//  VISIBLE BOOLEAN NOT NULL,
//  PRIMARY KEY (ID)
//);





//CREATE TABLE SHIFT_BREAKS (
//  ID VARCHAR NOT NULL,
//  SHIFTID VARCHAR NOT NULL,
//  BREAKID VARCHAR NOT NULL,
//  STARTTIME TIMESTAMP NOT NULL,
//  ENDTIME TIMESTAMP,
//  PRIMARY KEY (ID),
//  CONSTRAINT SHIFT_BREAKS_BREAKID FOREIGN KEY (BREAKID) REFERENCES BREAKS(ID),
//  CONSTRAINT SHIFT_BREAKS_SHIFTID FOREIGN KEY (SHIFTID) REFERENCES SHIFTS(ID)
//);





//CREATE TABLE CSVIMPORT (
//  ID VARCHAR NOT NULL,
//  ROWNUMBER VARCHAR,
//  CSVERROR VARCHAR,
//  REFERENCE VARCHAR,
//  CODE VARCHAR,
//  NAME VARCHAR,
//  PRICEBUY DOUBLE PRECISION,
//  PRICESELL DOUBLE PRECISION,
//  PREVIOUSBUY DOUBLE PRECISION,
//  PREVIOUSSELL DOUBLE PRECISION,
//  CATEGORY VARCHAR,
//  PRIMARY KEY (ID)
//);





//CREATE SEQUENCE PICKUP_NUMBER START WITH 1;





//CREATE TABLE DRAWEROPENED (
//  OPENDATE TIMESTAMP DEFAULT NOW(),
//  NAME VARCHAR,
//  TICKETID VARCHAR
//);
