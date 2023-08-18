FROM maven:3.8.3-openjdk-17-slim

EXPOSE 8080

WORKDIR /app

COPY . ./

RUN mvn install

CMD ["java", "-jar", "target/api-1.0-SNAPSHOT-jar-with-dependencies.jar"]


# # runtime image
# FROM jetty:9-jdk17-alpine

# WORKDIR /var/lib/jetty/webapps

# RUN rm -rf ./*

# EXPOSE 8080

# COPY --from=builder /app/target/api-1.0-SNAPSHOT.war ./ROOT.war
