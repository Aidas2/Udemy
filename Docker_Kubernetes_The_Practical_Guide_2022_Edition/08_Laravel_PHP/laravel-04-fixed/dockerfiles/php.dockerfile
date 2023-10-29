# FROM php:8.0-fpm-alpine
FROM php:8.2.0RC6-zts-alpine3.16

WORKDIR /var/www/html
 
COPY src .
 
RUN docker-php-ext-install pdo pdo_mysql
 
RUN addgroup -g 1000 laravel && adduser -G laravel -g laravel -s /bin/sh -D laravel

USER laravel 
 
RUN chown -R laravel:laravel .