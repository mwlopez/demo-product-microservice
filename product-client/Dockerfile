FROM java:8-jre
MAINTAINER Marcelo Lopez <mwlopez@gmail.com>

ADD ./target/product-client.jar /app/
CMD ["java", "-Xmx200m","-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/product-client.jar"]

EXPOSE 9494