-- Database upgrade script for Oracle
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
ALTER TABLE CSVIMPORT MODIFY PRICEBUY DEFAULT NULL;
ALTER TABLE CSVIMPORT MODIFY PRICESELL DEFAULT NULL;
ALTER TABLE CSVIMPORT MODIFY PREVIOUSBUY DEFAULT NULL;
ALTER TABLE CSVIMPORT MODIFY PREVIOUSSELL DEFAULT NULL;

ALTER TABLE PAYMENTS MODIFY TENDERED DEFAULT NULL;
ALTER TABLE PAYMENTS ADD COLUMN CARDNAME VARCHAR2(256);
UPDATE PAYMENTS SET TENDERED = TOTAL WHERE TENDERED = 0;

ALTER TABLE PRODUCTS MODIFY STOCKCOST DEFAULT NULL;
ALTER TABLE PRODUCTS MODIFY STOCKVOLUME DEFAULT NULL;

ALTER TABLE STOCKCURRENT MODIFY UNITS DEFAULT NULL;

ALTER TABLE STOCKDIARY MODIFY UNITS DEFAULT NULL;
ALTER TABLE STOCKDIARY MODIFY PRICE DEFAULT NULL;

ALTER TABLE STOCKLEVEL MODIFY STOCKSECURITY DEFAULT NULL;
ALTER TABLE STOCKLEVEL MODIFY STOCKMAXIMUM DEFAULT NULL;

ALTER TABLE TICKETLINES MODIFY UNITS DEFAULT NULL;
ALTER TABLE TICKETLINES MODIFY PRICE DEFAULT NULL;

-- UPDATE App' version
UPDATE APPLICATIONS SET NAME = $APP_NAME{}, VERSION = $APP_VERSION{} WHERE ID = $APP_ID{};

-- final script
DELETE FROM SHAREDTICKETS;
