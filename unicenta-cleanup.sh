#!/bin/bash

VER=$1

# Initial commit of unicenta $VER (with minor cleanup and excluding bad/unnecessary files -- see unicenta-cleanup.sh)

if [ -z "$VER" ]; then
  echo "usage: $0 [3.70|3.81]"
  exit 1
fi

# this is the script used to clean up the original unicenta 3.70 & 3.81 source tree prior to commit
if [ "$VER" = "3.70" ]; then
  cp ~/Downloads/uniCenta_oPOS_3.70.zip .
  unzip uniCenta_oPOS_3.70.zip
elif [ "$VER" = "3.81" ]; then
  cp ~/Downloads/uniCentaoPOS_381_source.zip .
  unzip uniCentaoPOS_381_source.zip
  mv unicenta-unicentaopos-e49f4e1ad1d4/* .
  rm -rf unicenta-unicentaopos-e49f4e1ad1d4
else
  echo "invalid version passed"
  exit 1
fi

# keep the lib directory
touch lib/.gitkeep

# remove files that shouldn't be there
rm -rf lib/{Windows,Linux,Solaris,Mac_OS_X}

# remove things that shouldn't be in the source tree
find ./ -type f -iname \*.jar -or -iname \*.dll -or -iname \*.so -or -iname \*.o -or -iname \*.jnilib -or -iname \*.zip -or -iname Thumbs.db | xargs -i rm -rf {} \;

# remove things (binaries) that we are going to replace that are otherwise dead weight
find ./ -type f -iname \*.png -or -iname \*.jpg -or -iname \*.ttf -or -iname \*.gif -or -name coin.1 -or -iname \*.ico -or -type d -name licensing | xargs -i rm -rf {} \;

# remove any empty directories
find ./ -type d -empty | xargs -i rm -rf {}

# setup sed replace string -- remove spaces at end of lines and CRLF->LF
SEDSTR='s/\s*$//;s/\r//'

# fix windows meta characters
CBAD=(85 92 93 94 A9)
CGOOD=("..." \' \" \" "(c)")
for ((i = 0; i < ${#CBAD[@]}; i++)) {
  SEDSTR="${SEDSTR};$(printf "s/%c/%s/" $(echo -e \\x${CBAD[i]}) ${CGOOD[i]})"
}

# do actual sed replace
find ./ -type f | xargs -i sed -i $SEDSTR {}

# fix permissions
find ./ -type f -exec chmod -x {} \;
chmod +x *.sh
