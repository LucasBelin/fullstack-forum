FROM maven:3.8.3-openjdk-17

WORKDIR /app

COPY pom.xml .
COPY ./src ./src
COPY lombok-mapstruct-binding-0.2.0.jar .

RUN mvn install:install-file -DgroupId=org.projectlombokk -DartifactId=lombok-mapstruct-binding -Dversion=0.2.0 -Dpackaging=jar -Dfile=/app/lombok-mapstruct-binding-0.2.0.jar
RUN mvn clean install -DskipTests

CMD ["java", "-jar", "/app/target/forum-api.jar"]