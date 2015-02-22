#!/bin/bash

killall -9 java &> /dev/null

psql -U postgres -c 'drop database "nycpos-dev";'
psql -U postgres -c 'create database "nycpos-dev" owner nycpos;'
