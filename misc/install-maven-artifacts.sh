#!/bin/bash

# break on errors
set -ex

# create temporary directory
TMPDIR=$(mktemp -d -t nycpos-jars-XXXXXX)

echo "Saving files to: ${TMPDIR}"

# retrieve jar files
wget -O $TMPDIR/bsh-2.1.8.jar http://www.knq.io/nycpos/bsh-2.1.8.jar
wget -O $TMPDIR/javapos-1.14.0.jar http://www.knq.io/nycpos/javapos-1.14.0.jar

# manually install maven artifacts
mvn \
  org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file \
  -Dfile=$TMPDIR/bsh-2.1.8.jar \
  -DgroupId=io.knq.beanshell2 \
  -DartifactId=bsh \
  -Dversion=2.1.8 \
  -Dpackaging=jar \
  -DgeneratePom=true

mvn \
  org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file \
  -Dfile=$TMPDIR/javapos-1.14.0.jar \
  -DgroupId=io.knq.javapos \
  -DartifactId=javapos \
  -Dversion=1.14.0 \
  -Dpackaging=jar \
  -DgeneratePom=true
