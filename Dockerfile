FROM openjdk:11-jre-slim

WORKDIR /app

# JARファイルをコンテナにコピー
COPY app/build/libs/hello-server-0.1.0.jar /app/hello-server.jar

# gRPCデフォルトの8080ポートでサーバーを起動
EXPOSE 8080

CMD ["java", "-jar", "/app/hello-server.jar"]
