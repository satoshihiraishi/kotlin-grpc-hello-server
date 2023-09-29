package io.grpc.examples.hello

import io.grpc.Server
import io.grpc.ServerBuilder
import io.grpc.stub.StreamObserver
import java.util.concurrent.TimeUnit


class HelloServer {
    private var server: Server? = null

    private fun start() {
        server = ServerBuilder.forPort(8080)
            .addService(HelloServiceImpl())
            .build()
            .start()
        println("Server started, listening on 8080")
    }

    private fun stop() {
        server?.shutdown()
    }

    private class HelloServiceImpl : HelloServiceGrpc.HelloServiceImplBase() {
        override fun sayHello(req: HelloRequest, responseObserver: StreamObserver<HelloResponse>) {
            val reply = HelloResponse.newBuilder().setMessage("Hello ${req.name}").build()
            responseObserver.onNext(reply)
            responseObserver.onCompleted()
        }
    }

    fun blockUntilShutdown() {
        server?.awaitTermination()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val server = HelloServer()
            server.start()
            server.blockUntilShutdown()
        }
    }
}
