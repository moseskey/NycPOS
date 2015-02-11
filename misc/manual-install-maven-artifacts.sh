#!/bin/bash

for i in *; do
  if [ -d "$i" ]; then
    GRP=io.knq.$i

    for j in $i/*.jar; do
      FILE=$(basename $j .jar)
      ART=$(echo $FILE|sed -e 's/-[0-9\.]\+$//')
      VER=$(echo $FILE|awk -F- '{print $NF}')
      echo "$FILE // $VER // $ART"

      mvn \
        org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file \
        -Dfile=$j \
        -DgroupId=$GRP \
        -DartifactId=$ART \
        -Dversion=$VER \
        -Dpackaging=jar \
        -DgeneratePom=true

    done
  fi
done
