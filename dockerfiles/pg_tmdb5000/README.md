The databases holds the following Schema


![image](../images/movies-erd.drawio.svg)


The CSV file was scraped from the following URL.
https://www.kaggle.com/tmdb/tmdb-movie-metadata?select=tmdb_5000_movies.csv


    This dataset was generated from The Movie Database dataset @ https://www.kaggle.com/tmdb/tmdb-movie-metadata. 
    This database is not an endorsement or certified by TMDB. This dataset is not complete, you should consider  
    using the TMDB API. You can try it for yourself at https://themoviedb.org/                                   


Add the parameters below and run the command. 
```
docker run --env POSTGRESQL_USER= --env POSTGRESQL_PASSWORD= --env POSTGRESQL_DATABASE= -p 5431:5432 quay.io/sshaaf/pg-tmdb5000:latest

e.g docker run --env POSTGRESQL_USER=quarkus --env POSTGRESQL_PASSWORD=quarkus --env POSTGRESQL_DATABASE=tmdb5000 -p 5431:5432 quay.io/sshaaf/pg-tmdb5000:latest
```
