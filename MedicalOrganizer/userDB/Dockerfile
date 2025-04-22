FROM mysql
ENV MYSQL_DATABASE USERS_DB
ENV MYSQL_ROOT_PASSWORD root
ENV MYSQL_USER user
ENV MYSQL_PASSWORD user
# tells my SQl database to listen on port 3306 rather than listening on it's default port of 3306
ENV MYSQL_TCP_PORT 3307
# ENV SQL_INTERNAL_PORT 3308
COPY userData.sql /docker-entrypoint-initdb.d
EXPOSE 3307