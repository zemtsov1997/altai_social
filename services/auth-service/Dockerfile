FROM openjdk:8

EXPOSE 8001

MAINTAINER Zemtsov Alexey Vladimirovich <zemtsov1997@yandex.ru>

ENV DEBUG_LEVEL INFO

WORKDIR /opt/auth-service

ADD target/auth-service-*.jar auth-service.jar

ENTRYPOINT java -jar -DDEBUG_LEVEL=$DEBUG_LEVEL auth-service.jar