FROM java:8-jre
MAINTAINER Marcelo Lopez <mwlopez@gmail.com>

ADD ./target/eureka-server.jar /app/
CMD ["java", "-Xmx200m","-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/eureka-server.jar"]

EXPOSE 8761