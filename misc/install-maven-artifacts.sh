#!/bin/bash

# break on errors
set -ex

# create temporary directory
TMPDIR=$(mktemp -d -t nycpos-jars-XXXXXX)

echo "Saving files to: ${TMPDIR}"

# check if already cached locally
if [ ! -f $HOME/.m2/repository/io/knq/beanshell2/bsh/2.1.8/bsh-2.1.8.jar ]; then
  # retrieve jar
  wget -O $TMPDIR/bsh-2.1.8.jar http://www.knq.io/nycpos/bsh-2.1.8.jar

  # install maven artifact
  mvn \
    org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file \
    -Dfile=$TMPDIR/bsh-2.1.8.jar \
    -DgroupId=io.knq.beanshell2 \
    -DartifactId=bsh \
    -Dversion=2.1.8 \
    -Dpackaging=jar \
    -DgeneratePom=true
fi

# check if already cached locally
if [ ! -f $HOME/.m2/repository/io/knq/javapos/javapos/1.14.0/javapos-1.14.0.jar ]; then
  # retrieve jar
  wget -O $TMPDIR/javapos-1.14.0.jar http://www.knq.io/nycpos/javapos-1.14.0.jar

  # install maven artifact
  mvn \
    org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file \
    -Dfile=$TMPDIR/javapos-1.14.0.jar \
    -DgroupId=io.knq.javapos \
    -DartifactId=javapos \
    -Dversion=1.14.0 \
    -Dpackaging=jar \
    -DgeneratePom=true
fi

# check if already cached locally
if [ ! -f $HOME/.m2/repository/net/saliman/gradle-liquibase-plugin/1.0.1-SNAPSHOT/gradle-liquibase-plugin-1.0.1-SNAPSHOT.jar ]; then
  pushd $HOME > /dev/null
  rm -rf gradle-liquibase-plugin
  git clone https://github.com/tlberglund/gradle-liquibase-plugin.git

  pushd $HOME/gradle-liquibase-plugin
  git checkout ccd4c7b7
  ./gradlew build install

  popd > /dev/null
  popd > /dev/null
fi

exit 0
