import io.grpc.examples.hello.HelloProto.HelloRequest
import io.grpc.examples.hello.HelloProto.HelloResponse
import io.grpc.examples.hello.HelloServiceGrpc
import io.grpc.inprocess.InProcessChannelBuilder
import io.grpc.inprocess.InProcessServerBuilder
import io.grpc.testing.GrpcCleanupRule
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

class HelloServiceTest {

    @get:Rule
    val grpcCleanup: GrpcCleanupRule = GrpcCleanupRule()

    @Test
    fun sayHelloTest() {
        // InProcessサーバーをセットアップ
        val serverName = InProcessServerBuilder.generateName()
        grpcCleanup.register(
            InProcessServerBuilder.forName(serverName)
                .directExecutor()
                .addService(HelloServiceImpl())
                .build()
                .start()
        )

        // InProcessチャネルをセットアップ
        val channel = grpcCleanup.register(InProcessChannelBuilder.forName(serverName).directExecutor().build())

        // クライアントを作成
        val client = HelloServiceGrpc.newBlockingStub(channel)

        // SayHelloをコール
        val response = client.sayHello(HelloRequest.newBuilder().setName("Test").build())

        // レスポンスを確認
        assertEquals("Hello, Test!", response.message)
    }

    class HelloServiceImpl : HelloServiceGrpc.HelloServiceImplBase() {
        override fun sayHello(request: HelloRequest, responseObserver: io.grpc.stub.StreamObserver<HelloResponse>) {
            val message = "Hello, ${request.name}!"
            val response = HelloResponse.newBuilder().setMessage(message).build()
            responseObserver.onNext(response)
            responseObserver.onCompleted()
        }
    }
}
