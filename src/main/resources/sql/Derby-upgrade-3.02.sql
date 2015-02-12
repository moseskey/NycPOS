-- Database upgrade script for DERBY
-- v3.02 - v3.55

CREATE TABLE CSVIMPORT (
  ID VARCHAR(256) NOT NULL,
  ROWNUMBER VARCHAR(256),
  CSVERROR VARCHAR(256),
  REFERENCE VARCHAR(256),
  CODE VARCHAR(256),
  NAME VARCHAR(256),
  PRICEBUY DOUBLE,
  PRICESELL DOUBLE,
  PREVIOUSBUY DOUBLE,
  PREVIOUSSELL DOUBLE,
  PRIMARY KEY (ID)
);

CREATE TABLE DRAWEROPENED (
    OPENDATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    NAME VARCHAR(255),
    TICKETID VARCHAR(255)
);

CREATE TABLE MOORERS (
  VESSELNAME VARCHAR(256),
  SIZE INTEGER,
  DAYS INTEGER,
  POWER SMALLINT DEFAULT 0 NOT NULL
  );

CREATE TABLE PICKUP_NUMBER (
ID INTEGER NOT NULL
);
INSERT INTO PICKUP_NUMBER VALUES(1);

--
-- UPDATE existing tables
--
UPDATE ROLES SET PERMISSIONS = $FILE{/com/openbravo/pos/templates/Role.Administrator.xml} WHERE ID = '0';
UPDATE RESOURCES SET CONTENT = $FILE{/com/openbravo/pos/templates/Menu.Root.txt} WHERE ID = '0';
UPDATE RESOURCES SET CONTENT = $FILE{/com/openbravo/pos/templates/Printer.CloseCash.xml} WHERE ID = '25';
UPDATE RESOURCES SET CONTENT = $FILE{/com/openbravo/pos/templates/Printer.CustomerPaid.XML} WHERE ID = '26';
UPDATE RESOURCES SET CONTENT = $FILE{/com/openbravo/pos/templates/Printer.CustomerPaid2.xml} WHERE ID = '27';
UPDATE RESOURCES SET CONTENT = $FILE{/com/openbravo/pos/templates/Printer.PartialCash.xml} WHERE ID = '31';
UPDATE RESOURCES SET CONTENT = $FILE{/com/openbravo/pos/templates/Printer.Ticket.xml} WHERE ID = '33';
UPDATE RESOURCES SET CONTENT = $FILE{/com/openbravo/pos/templates/Printer.Ticket2.xml} WHERE ID = '34';
UPDATE RESOURCES SET CONTENT = $FILE{/com/openbravo/pos/templates/Printer.TicketPreview.xml} WHERE ID = '37';

-- ADD NEW RESOURCES
INSERT INTO RESOURCES(ID, NAME, RESTYPE, CONTENT) VALUES('56', 'Printer.Product', 0, $FILE{/com/openbravo/pos/templates/Printer.Product.xml});
INSERT INTO RESOURCES(ID, NAME, RESTYPE, CONTENT) VALUES('57', 'Printer.TicketClose', 0, $FILE{/com/openbravo/pos/templates/Printer.TicketClose.xml});
INSERT INTO RESOURCES(ID, NAME, RESTYPE, CONTENT) VALUES('58', 'Printer.TicketNew', 0, $FILE{/com/openbravo/pos/templates/Printer.TicketLine.xml});
INSERT INTO RESOURCES(ID, NAME, RESTYPE, CONTENT) VALUES('59', 'script.AddLineNote', 0, $FILE{/com/openbravo/pos/templates/script.AddLineNote.txt});
INSERT INTO RESOURCES(ID, NAME, RESTYPE, CONTENT) VALUES('60', 'script.ServiceCharge', 0, $FILE{/com/openbravo/pos/templates/script.script.ServiceCharge.txt});

--
-- ALTER existing tables
--
ALTER TABLE CATEGORIES ADD COLUMN TEXTTIP VARCHAR(256) DEFAULT NULL;
ALTER TABLE CATEGORIES ADD COLUMN CATSHOWNAME SMALLINT DEFAULT 1 NOT NULL;

ALTER TABLE CLOSEDCASH ADD COLUMN NOSALES SMALLINT DEFAULT 0 NOT NULL;

ALTER TABLE CUSTOMERS ADD COLUMN IMAGE BLOB;

ALTER TABLE PAYMENTS ADD COLUMN TENDERED DOUBLE PRECISION DEFAULT 0 NOT NULL;
ALTER TABLE PAYMENTS ADD COLUMN CARDNAME VARCHAR(256);
ALTER TABLE PAYMENTS ADD COLUMN NOTES VARCHAR(256);
UPDATE PAYMENTS SET TENDERED = TOTAL WHERE TENDERED = 0;

ALTER TABLE PLACES ADD COLUMN CUSTOMER VARCHAR(256);
ALTER TABLE PLACES ADD COLUMN WAITER VARCHAR(256);
ALTER TABLE PLACES ADD COLUMN TICKETID VARCHAR(256);
ALTER TABLE PLACES ADD COLUMN TABLEMOVED SMALLINT DEFAULT 0 NOT NULL;

ALTER TABLE PRODUCTS ADD COLUMN ISVPRICE SMALLINT DEFAULT 0 NOT NULL;
ALTER TABLE PRODUCTS ADD COLUMN ISVERPATRIB SMALLINT DEFAULT 0 NOT NULL;
ALTER TABLE PRODUCTS ADD COLUMN TEXTTIP VARCHAR(256) DEFAULT NULL;
ALTER TABLE PRODUCTS ADD COLUMN WARRANTY SMALLINT DEFAULT 0 NOT NULL;

ALTER TABLE SHAREDTICKETS ADD COLUMN APPUSER VARCHAR(256) DEFAULT NULL;
ALTER TABLE SHAREDTICKETS ADD COLUMN PICKUPID SMALLINT DEFAULT 0 NOT NULL;

ALTER TABLE STOCKDIARY ADD COLUMN APPUSER VARCHAR(256);

-- UPDATE App' version
UPDATE APPLICATIONS SET NAME = $APP_NAME{}, VERSION = $APP_VERSION{} WHERE ID = $APP_ID{};

-- final script
DELETE FROM SHAREDTICKETS;
