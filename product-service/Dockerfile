FROM java:8-jre
MAINTAINER Marcelo Lopez <mwlopez@gmail.com>

ADD ./target/product-service.jar /app/
CMD ["java", "-Xmx200m","-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/product-service.jar"]

EXPOSE 9595