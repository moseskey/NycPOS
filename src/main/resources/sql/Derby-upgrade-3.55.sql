-- Database upgrade script for DERBY
-- v3.55 - v3.56

--
-- UPDATE existing tables
--

--
-- ALTER existing tables
--

-- UPDATE App' version
UPDATE APPLICATIONS SET NAME = $APP_NAME{}, VERSION = $APP_VERSION{} WHERE ID = $APP_ID{};

-- final script
DELETE FROM SHAREDTICKETS;
