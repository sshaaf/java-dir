#!/bin/bash

LANG=en_CA.UTF-8
LC_CTYPE="en_CA.UTF-8"
LC_NUMERIC="en_CA.UTF-8"
LC_TIME="en_CA.UTF-8"
LC_COLLATE="en_CA.UTF-8"
LC_MONETARY="en_CA.UTF-8"
LC_MESSAGES="en_CA.UTF-8"
LC_PAPER="en_CA.UTF-8"
LC_NAME="en_CA.UTF-8"
LC_ADDRESS="en_CA.UTF-8"
LC_TELEPHONE="en_CA.UTF-8"
LC_MEASUREMENT="en_CA.UTF-8"
LC_IDENTIFICATION="en_CA.UTF-8"

psql -c 'select version();'
echo USER: $POSTGRESQL_USER
echo DB: $POSTGRESQL_DATABASE
echo $(pwd)
export SQL_DIR=$(pwd)/sql

envsubst < $SQL_DIR/tmdb5000-load.sql > /tmp/tmdb5000-load-subst.sql

psql -d $POSTGRESQL_DATABASE -w < /tmp/tmdb5000-load-subst.sql

echo "***************************************************************************************************************"
echo "*This dataset was generated from The Movie Database dataset @ https://www.kaggle.com/tmdb/tmdb-movie-metadata.*" 
echo "*This database is not an endorsement or certified by TMDB. This dataset is not complete, you should consider  *"
echo "*using the TMDB API. You can try it for yourself at https://themoviedb.org/                                   *"
echo "***************************************************************************************************************"
