FROM openjdk:11
VOLUME /tmp
ADD target/scholar-project.jar scholar-project
ENTRYPOINT ["java", "-jar","scholar-project"]
EXPOSE 8080