// parent changelog file
databaseChangeLog {
  // global property settings
  property(name: 'type.timestamp', value: 'timestamp without time zone', dbms: 'postgresql')
  //property(name: 'type.timestamp.defaultValueComputed', value: '', dbms: 'postgresql')

  includeAll(path: 'changelogs', relativeToChangelogFile: true)
}
