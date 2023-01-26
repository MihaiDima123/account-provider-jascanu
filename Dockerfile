FROM openjdk:17-oracle

WORKDIR /app

ENTRYPOINT ["java", "-jar", "/app/account-provider.jar"]