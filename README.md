# kotlin-grpc-hello-server

kotlin grpc test server

## protoファイルから

```code
### proto
./gradlew generateProto

```

## サーバー起動方法

### gradlewでの起動

```code
./gradlew run
```

### dockerから起動

Jarファイルを作成する。

```code
### make jar file
./gradlew shadowJar
```

Dockerを起動する。

```code
docker build -t kotlin-grpc-hello-server .
docker run -p 8080:8080 kotlin-grpc-hello-server
```

## サーバー起動後

別のクライアント　or　PostmanでgRPC接続してテストする。
