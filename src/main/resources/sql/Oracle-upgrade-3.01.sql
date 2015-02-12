-- Database upgrade script for Oracle
-- v3.01 - v3.02

-- RESOURCES
-- ABSTRACTED TO SEPARATE DOWNLOAD SO AS NOT TO OVERWRITE EXISTING USER SETTINGS
-- UPDATE RESOURCES SET CONTENT = $FILE{/com/openbravo/pos/templates/Printer.TicketKitchen.xml} WHERE ID = '35';
-- UPDATE RESOURCES SET CONTENT = $FILE{/com/openbravo/pos/templates/Printer.TicketLine.xml} WHERE ID = '36';
-- UPDATE RESOURCES SET CONTENT = $FILE{/com/openbravo/pos/templates/Printer.TicketPreview.xml} WHERE ID = '37';
UPDATE RESOURCES SET CONTENT = $FILE{/com/openbravo/pos/templates/script.ReceiptConsolidate.xml} WHERE ID = '43';

-- PRODUCT
ALTER TABLE PRODUCTS ADD DISPLAY VARCHAR2(1024);

UPDATE APPLICATIONS SET NAME = $APP_NAME{}, VERSION = $APP_VERSION{} WHERE ID = $APP_ID{};
