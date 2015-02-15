// parent changelog file
databaseChangeLog {
    changeSet(id: '1423960573951-1', author: 'ken (generated)') {
      createTable(tableName: 'CONTACT_BALL_OF_MUD') {
       column(name: 'ID', type: 'BIGINT(19)', autoIncrement: true) {
         constraints(primaryKey: true, primaryKeyName: 'CONSTRAINT_9')
       }
       column(name: 'NUMBER', type: 'BIGINT(19)')
       column(name: 'GENDER', type: 'VARCHAR(45)')
       column(name: 'GIVENNAME', type: 'VARCHAR(45)')
       column(name: 'MIDDLEINITIAL', type: 'VARCHAR(45)')
       column(name: 'SURNAME', type: 'VARCHAR(45)')
       column(name: 'STREETADDRESS', type: 'VARCHAR(45)')
       column(name: 'CITY', type: 'VARCHAR(45)')
       column(name: 'STATE', type: 'VARCHAR(45)')
       column(name: 'ZIPCODE', type: 'VARCHAR(45)')
       column(name: 'COUNTRY', type: 'VARCHAR(45)')
       column(name: 'EMAILADDRESS', type: 'VARCHAR(45)')
       column(name: 'PASSWORD', type: 'VARCHAR(45)')
       column(name: 'TELEPHONENUMBER', type: 'VARCHAR(45)')
       column(name: 'MOTHERSMAIDEN', type: 'VARCHAR(45)')
       column(name: 'BIRTHDAY', type: 'TIMESTAMP')
       column(name: 'CCTYPE', type: 'VARCHAR(45)')
       column(name: 'CCNUMBER', type: 'VARCHAR(45)')
       column(name: 'CVV2', type: 'VARCHAR(5)')
       column(name: 'CCEXPIRES', type: 'TIMESTAMP')
       column(name: 'NATIONALID', type: 'VARCHAR(45)')
       column(name: 'UPS', type: 'VARCHAR(45)')
       column(name: 'OCCUPATION', type: 'VARCHAR(45)')
      }
    }
  //includeAll(path: 'changelogs', relativeToChangelogFile: true)
}
