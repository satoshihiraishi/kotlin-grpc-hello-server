package io.grpc.examples.hello

import io.grpc.examples.hello.HelloRequest
import io.grpc.examples.hello.HelloResponse
import io.grpc.examples.hello.HelloServiceGrpc
import io.grpc.stub.StreamObserver

class HelloServiceImpl : HelloServiceGrpc.HelloServiceImplBase() {
    override fun sayHello(request: HelloRequest, responseObserver: StreamObserver<HelloResponse>) {
        val message = "Hello, ${request.name}!"
        val response = HelloResponse.newBuilder().setMessage(message).build()
        responseObserver.onNext(response)
        responseObserver.onCompleted()
    }
}
