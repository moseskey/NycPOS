-- Database upgrade script for PostgreSQL
-- v3.55 - v3.56

--
-- UPDATE existing tables
--

--
-- ALTER existing tables
--
ALTER TABLE CUSTOMERS ALTER COLUMN CURDEBT SET DEFAULT NULL;


-- UPDATE App' version
UPDATE APPLICATIONS SET NAME = $APP_NAME{}, VERSION = $APP_VERSION{} WHERE ID = $APP_ID{};

-- final script
DELETE FROM SHAREDTICKETS;
