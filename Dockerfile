FROM java:8u20

EXPOSE 9092

ADD out/artifacts/OAES_Login_jar/OAES_Login.jar OAES_Login.jar

ENTRYPOINT ["java", "-jar", "OAES_Login.jar"]