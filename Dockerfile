FROM amazoncorretto:21
LABEL maintainer="Lucas Barbosa <lucasbarbosadasilva30@gmail.com>"
WORKDIR /app
COPY target/CadastroDeCaesAR-0.0.1-SNAPSHOT.jar /app/cadastro-caes.jar
ENTRYPOINT ["java", "-jar", "cadastro-caes.jar"]
