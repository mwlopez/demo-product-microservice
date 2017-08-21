FROM java:8-jre
MAINTAINER Marcelo Lopez <mwlopez@gmail.com>

ADD ./target/hystrix-circuite-breaker.jar /app/
CMD ["java", "-Xmx200m","-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/hystrix-circuite-breaker.jar"]

EXPOSE 9191