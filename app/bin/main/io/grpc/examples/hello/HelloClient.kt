package io.grpc.examples.hello

import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import java.util.concurrent.TimeUnit


class HelloClient(private val channel: ManagedChannel) {
    private val stub: HelloServiceGrpc.HelloServiceBlockingStub = HelloServiceGrpc.newBlockingStub(channel)

    fun sayHello(name: String): String {
        val request = HelloRequest.newBuilder().setName(name).build()
        val response = stub.sayHello(request)
        return response.message
    }

    fun shutdown() {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val channel = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext().build()
            val client = HelloClient(channel)

            val name = if (args.isNotEmpty()) args[0] else "world"
            println("Greeting: ${client.sayHello(name)}")

            client.shutdown()
        }
    }
}
