-- Database upgrade script for HSQLDB
-- v3.50 - v3.55

--
-- UPDATE existing tables
--
UPDATE ROLES SET PERMISSIONS = $FILE{/templates/default/Role.Administrator.xml} WHERE ID = '0';

UPDATE RESOURCES SET CONTENT = $FILE{/templates/default/Menu.Root.txt} WHERE ID = '0';
UPDATE RESOURCES SET CONTENT = $FILE{/templates/default/Printer.CloseCash.xml} WHERE ID = '25';
UPDATE RESOURCES SET CONTENT = $FILE{/templates/default/Printer.CustomerPaid.XML} WHERE ID = '26';
UPDATE RESOURCES SET CONTENT = $FILE{/templates/default/Printer.CustomerPaid2.xml} WHERE ID = '27';
UPDATE RESOURCES SET CONTENT = $FILE{/templates/default/Printer.PartialCash.xml} WHERE ID = '31';
UPDATE RESOURCES SET CONTENT = $FILE{/templates/default/Printer.Ticket.xml} WHERE ID = '33';
UPDATE RESOURCES SET CONTENT = $FILE{/templates/default/Printer.Ticket2.xml} WHERE ID = '34';
UPDATE RESOURCES SET CONTENT = $FILE{/templates/default/Printer.TicketPreview.xml} WHERE ID = '37';

--
-- ALTER existing tables
--
ALTER TABLE CSVIMPORT ALTER COLUMN PRICEBUY SET DEFAULT NULL;
ALTER TABLE CSVIMPORT ALTER COLUMN PRICESELL SET DEFAULT NULL;
ALTER TABLE CSVIMPORT ALTER COLUMN PREVIOUSBUY SET DEFAULT NULL;
ALTER TABLE CSVIMPORT ALTER COLUMN PREVIOUSSELL SET DEFAULT NULL;

ALTER TABLE PAYMENTS ALTER COLUMN TENDERED SET DEFAULT NULL;
ALTER TABLE PAYMENTS ADD COLUMN CARDNAME VARCHAR(255);
UPDATE PAYMENTS SET TENDERED = TOTAL WHERE TENDERED = 0;

ALTER TABLE PRODUCTS ALTER COLUMN STOCKCOST SET DEFAULT NULL;
ALTER TABLE PRODUCTS ALTER COLUMN STOCKVOLUME SET DEFAULT NULL;

ALTER TABLE STOCKCURRENT ALTER COLUMN UNITS SET DEFAULT NULL;

ALTER TABLE STOCKDIARY ALTER COLUMN UNITS SET DEFAULT NULL;
ALTER TABLE STOCKDIARY ALTER COLUMN PRICE SET DEFAULT NULL;

ALTER TABLE STOCKLEVEL ALTER COLUMN STOCKSECURITY SET DEFAULT NULL;
ALTER TABLE STOCKLEVEL ALTER COLUMN STOCKMAXIMUM SET DEFAULT NULL;

ALTER TABLE TICKETLINES ALTER COLUMN UNITS SET DEFAULT NULL;
ALTER TABLE TICKETLINES ALTER COLUMN PRICE SET DEFAULT NULL;

-- UPDATE App' version
UPDATE APPLICATIONS SET NAME = $APP_NAME{}, VERSION = $APP_VERSION{} WHERE ID = $APP_ID{};

-- final script
DELETE FROM SHAREDTICKETS;
