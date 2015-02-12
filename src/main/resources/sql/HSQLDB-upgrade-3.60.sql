-- Database upgrade script for HSQLDB
-- v3.60 - v3.70

--
-- UPDATE existing tables
--

--
-- ALTER existing tables
--

--
-- INSERT INTO tables
--
INSERT INTO PRODUCTS(ID, REFERENCE, CODE, NAME, PRICEBUY, PRICESELL, CATEGORY, TAXCAT, ISSERVICE)
VALUES ('xxx999_999xxx_x9x9x9', 'xxx999', 'xxx999', '***', 0.00, 0.00, '000', '001', 1);

INSERT INTO PRODUCTS_CAT(PRODUCT) VALUES ('xxx999_999xxx_x9x9x9');

-- UPDATE App' version
UPDATE APPLICATIONS SET NAME = $APP_NAME{}, VERSION = $APP_VERSION{} WHERE ID = $APP_ID{};

-- final script
DELETE FROM SHAREDTICKETS;
