FROM java:8-jre
WORKDIR /app

COPY ./build/libs/*.jar /app/giphy.jar
CMD ["java", "-Xmx200m", "-jar", "/app/giphy.jar"]

EXPOSE 8080