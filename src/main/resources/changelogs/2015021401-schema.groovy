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

    // create ticketsnum, ticketsnum_refund, ticketsnum_payment sequences
    createSequence(sequenceName: 'ticketsnum', startValue: 1)
    createSequence(sequenceName: 'ticketsnum_refund', startValue: 1)
    createSequence(sequenceName: 'ticketsnum_payment', startValue: 1)

    // create ticketlines table
    createTable(tableName: 'ticketlines') {
      column(name: 'ticket', type: 'varchar') {
        constraints(nullable: false, references: 'tickets', foreignKeyName: 'fk_ticketlines_tickets')
      }
      column(name: 'line', type: 'integer') {
        constraints(nullable: false)
      }
      column(name: 'product', type: 'varchar') {
        constraints(references: 'products', foreignKeyName: 'fk_ticketlines_products')
      }
      column(name: 'attributesetinstance_id', type: 'varchar') {
        constraints(references: 'attributesetinstance', foreignKeyName: 'fk_ticketlines_attributesetinstance')
      }
      column(name: 'units', type: 'double') {
        constraints(nullable: false)
      }
      column(name: 'price', type: 'double') {
        constraints(nullable: false)
      }
      column(name: 'taxid', type: 'varchar') {
        constraints(nullable: false, references: 'taxes', foreignKeyName: 'fk_ticketlines_taxes')
      }
      column(name: 'attributes', type: 'blob')
    }
    addPrimaryKey(tableName: 'ticketlines', columnNames: 'ticket, line', constraintName: 'pk_ticketlines')

    // create lineremoved table
    createTable(tableName: 'lineremoved') {
      column(name: 'removeddate', type: 'timestamp', defaultValueComputed: 'CURRENT_TIMESTAMP') {
        constraints(nullable: false)
      }
      column(name: 'name', type: 'varchar') {
        constraints(nullable: false)
      }
      column(name: 'ticketid', type: 'varchar') {
        constraints(nullable: false)
      }
      column(name: 'productid', type: 'varchar') {
        constraints(nullable: false)
      }
      column(name: 'productname', type: 'varchar') {
        constraints(nullable: false)
      }
      column(name: 'units', type: 'double') {
        constraints(nullable: false)
      }
    }

    // create payments table
    createTable(tableName: 'payments') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'receipt', type: 'varchar') {
        constraints(nullable: false, references: 'receipts', foreignKeyName: 'fk_payments_receipts')
      }
      column(name: 'payment', type: 'varchar') {
        constraints(nullable: false)
      }
      column(name: 'total', type: 'double') {
        constraints(nullable: false)
      }
      column(name: 'transid', type: 'varchar')
      column(name: 'notes', type: 'varchar')
      column(name: 'returnmsg', type: 'blob')
      column(name: 'tendered', type: 'double', defaultValue: 0) {
        constraints(nullable: false)
      }
      column(name: 'cardname', type: 'varchar')
    }
    createIndex(tableName: 'payments', indexName: 'payments_payment_idx') {
      column(name: 'payment')
    }

    // create taxlines table
    createTable(tableName: 'taxlines') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'receipt', type: 'varchar') {
        constraints(nullable: false, references: 'receipts', foreignKeyName: 'fk_taxlines_receipts')
      }
      column(name: 'taxid', type: 'varchar') {
        constraints(nullable: false, references: 'taxes', foreignKeyName: 'fk_taxlines_taxes')
      }
      column(name: 'base', type: 'double', defaultValue: 0) {
        constraints(nullable: false)
      }
      column(name: 'amount', type: 'double', defaultValue: 0) {
        constraints(nullable: false)
      }
    }

    // create floors table
    createTable(tableName: 'floors') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'name', type: 'varchar') {
        constraints(nullable: false, unique: true)
      }
      column(name: 'image', type: 'blob')
    }

    // create places table
    createTable(tableName: 'places') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'name', type: 'varchar') {
        constraints(nullable: false, unique: true)
      }
      column(name: 'x', type: 'integer') {
        constraints(nullable: false)
      }
      column(name: 'y', type: 'integer') {
        constraints(nullable: false)
      }
      column(name: 'floor', type: 'varchar') {
        constraints(nullable: false, references: 'floors', foreignKeyName: 'fk_places_floors')
      }
      column(name: 'customer', type: 'varchar')
      column(name: 'waiter', type: 'varchar')
      column(name: 'ticketid', type: 'varchar')
      column(name: 'tablemoved', type: 'boolean', defaultValue: false) {
        constraints(nullable: false)
      }
    }

    // create reservations table
    createTable(tableName: 'reservations') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'created', type: 'timestamp') {
        constraints(nullable: false)
      }
      column(name: 'datenew', type: 'timestamp', defaultValueDate: '2013-01-01T00:00:00') {
        constraints(nullable: false)
      }
      column(name: 'title', type: 'varchar') {
        constraints(nullable: false)
      }
      column(name: 'chairs', type: 'integer') {
        constraints(nullable: false)
      }
      column(name: 'isdone', type: 'boolean') {
        constraints(nullable: false)
      }
      column(name: 'description', type: 'varchar')
    }
    createIndex(tableName: 'reservations', indexName: 'reservations_datenew_idx') {
      column(name: 'datenew')
    }

    // create reservation_customers table
    createTable(tableName: 'reservation_customers') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true, references: 'reservations', foreignKeyName: 'fk_reservation_customers_reservations')
      }
      column(name: 'customer', type: 'varchar') {
        constraints(nullable: false, references: 'customers', foreignKeyName: 'fk_reservation_customers_customers')
      }
    }

    // create thirdparties table
    createTable(tableName: 'thirdparties') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'cif', type: 'varchar') {
        constraints(nullable: false, unique: true)
      }
      column(name: 'name', type: 'varchar') {
        constraints(nullable: false, unique: true)
      }
      column(name: 'address', type: 'varchar')
      column(name: 'contactcomm', type: 'varchar')
      column(name: 'contactfact', type: 'varchar')
      column(name: 'payrule', type: 'varchar')
      column(name: 'faxnumber', type: 'varchar')
      column(name: 'phonenumber', type: 'varchar')
      column(name: 'mobilenumber', type: 'varchar')
      column(name: 'email', type: 'varchar')
      column(name: 'webpage', type: 'varchar')
      column(name: 'notes', type: 'varchar')
    }

    // create sharedtickets table
    createTable(tableName: 'sharedtickets') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'name', type: 'varchar') {
        constraints(nullable: false)
      }
      column(name: 'content', type: 'blob')
      column(name: 'pickupid', type: 'integer', defaultValue: 0) {
        constraints(nullable: false)
      }
      column(name: 'appuser', type: 'varchar')
    }

    // create shifts table
    createTable(tableName: 'shifts') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'startshift', type: 'timestamp') {
        constraints(nullable: false)
      }
      column(name: 'endshift', type: 'timestamp')
      column(name: 'pplid', type: 'varchar') {
        constraints(nullable: false)
      }
    }

    // create leaves table
    createTable(tableName: 'leaves') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'pplid', type: 'varchar') {
        constraints(nullable: false, references: 'people', foreignKeyName: 'fk_leaves_people')
      }
      column(name: 'name', type: 'varchar') {
        constraints(nullable: false)
      }
      column(name: 'startdate', type: 'timestamp') {
        constraints(nullable: false)
      }
      column(name: 'enddate', type: 'timestamp') {
        constraints(nullable: false)
      }
      column(name: 'notes', type: 'varchar')
    }

    // create breaks table
    createTable(tableName: 'breaks') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'name', type: 'varchar') {
        constraints(nullable: false)
      }
      column(name: 'notes', type: 'varchar')
      column(name: 'visible', type: 'boolean') {
        constraints(nullable: false)
      }
    }

    // create shift_breaks table
    createTable(tableName: 'shift_breaks') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'shiftid', type: 'varchar') {
        constraints(nullable: false, references: 'shifts', foreignKeyName: 'fk_shift_breaks_shifts')
      }
      column(name: 'breakid', type: 'varchar') {
        constraints(nullable: false, references: 'breaks', foreignKeyName: 'fk_shift_breaks_breaks')
      }
      column(name: 'starttime', type: 'timestamp') {
        constraints(nullable: false)
      }
      column(name: 'endtime', type: 'timestamp')
    }

    // create csvimport table
    createTable(tableName: 'csvimport') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'rownumber', type: 'varchar')
      column(name: 'csverror', type: 'varchar')
      column(name: 'reference', type: 'varchar')
      column(name: 'code', type: 'varchar')
      column(name: 'name', type: 'varchar')
      column(name: 'pricebuy', type: 'double')
      column(name: 'pricesell', type: 'double')
      column(name: 'previousbuy', type: 'double')
      column(name: 'previoussell', type: 'double')
      column(name: 'category', type: 'varchar')
    }

    // create pickup_number sequence
    createSequence(sequenceName: 'pickup_number', startValue: 1)

    // create draweropened table
    createTable(tableName: 'draweropened') {
      column(name: 'id', type: 'varchar') {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'name', type: 'varchar')
      column(name: 'ticketid', type: 'varchar')
    }

  }
}
