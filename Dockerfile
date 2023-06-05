FROM maven:3.9.0-eclipse-temurin-17 as m2_cache
WORKDIR /app
COPY pom.xml pom.xml
RUN mvn -Dmaven.repo.local=.m2/repository dependency:resolve-plugins dependency:resolve -B

FROM maven:3.9.0-eclipse-temurin-17 as java-build
# mi serve copiare anche .git per poter estrarre le informazioni sulla build da includere nella info di Actuator
WORKDIR /app
# COPY .git .git 
COPY pom.xml pom.xml
COPY src src
COPY --from=m2_cache /app/.m2/repository .m2/repository
RUN mvn -Dmaven.repo.local=/app/.m2/repository package -Dmaven.test.skip=true

FROM eclipse-temurin:17-jre-focal
# ENV SPRING_PROFILES_ACTIVE=dev
VOLUME /tmp
COPY --from=java-build  /app/target/app.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["/bin/sh", "-c", "/opt/java/openjdk/bin/java -jar /app/app.jar $0 $@"]
#ENTRYPOINT ["/bin/sh", "-c", "/opt/java/openjdk/bin/java -jar /app/app.jar --spring.profiles.active=$SPRING_PROFILES_ACTIVE $0 $@"]