FROM openjdk:17-jdk-slim
ARG JAR_FILE=proyecto_jar/veterinaria-0.0.1.jar
COPY ${JAR_FILE} app_piscis_veterinaria.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","app_piscis_veterinaria.jar" ]