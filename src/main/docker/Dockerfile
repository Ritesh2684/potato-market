FROM anapsix/alpine-java:8
VOLUME /tmp
ADD maven/target/potato-market-1.0.0-SNAPSHOT.jar potato-market.jar
RUN sh -c 'touch /potato-market.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/potato-market.jar"]