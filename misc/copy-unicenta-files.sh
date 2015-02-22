#!/bin/bash

SRC="$( cd -P "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
UC_ZIP=unicenta-3.81-src.zip
IMGDIR=$SRC/../src/main/resources/images

set -ex;

if [ ! -f $IMGDIR/unicenta.png ]; then
  # create a working directory
  TMPDIR=$(mktemp -d -t unicenta-src-XXXXXX)

  pushd $TMPDIR > /dev/null

  # grab unicenta source
  if [ -f ~/Downloads/$UC_ZIP ]; then
    cp ~/Downloads/$UC_ZIP .
  else
    wget -O $UC_ZIP http://www.knq.io/nycpos/$UC_ZIP
  fi

  # extract archive
  unzip $UC_ZIP

  # fix file permissions
  find ./unicenta* -type f -exec chmod 0644 {} \;

  # copy image files over
  rsync -avP ./unicenta*/src-beans/com/openbravo/images/*.png $IMGDIR/

  popd > /dev/null
fi
