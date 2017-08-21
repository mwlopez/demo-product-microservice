FROM java:8-jre
MAINTAINER Marcelo Lopez <mwlopez@gmail.com>

ADD ./target/zuul-gateway.jar /app/
CMD ["java", "-Xmx200m","-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/zuul-gateway.jar"]

EXPOSE 9090