-- Database upgrade script for PostgreSQL
-- v3.80 - v3.81

-- UPDATE App' version
UPDATE APPLICATIONS SET NAME = $APP_NAME{}, VERSION = $APP_VERSION{} WHERE ID = $APP_ID{};
