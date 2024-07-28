FROM openjdk:22

VOLUME /tmp

COPY build/libs/heybackend-0.0.1-SNAPSHOT.jar heybackend.jar

ENTRYPOINT ["java", "-jar", "heybackend.jar"]