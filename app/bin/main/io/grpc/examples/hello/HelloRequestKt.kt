// Generated by the protocol buffer compiler. DO NOT EDIT!
// source: hello.proto

// Generated files should ignore deprecation warnings
@file:Suppress("DEPRECATION")
package io.grpc.examples.hello;

@kotlin.jvm.JvmName("-initializehelloRequest")
public inline fun helloRequest(block: io.grpc.examples.hello.HelloRequestKt.Dsl.() -> kotlin.Unit): io.grpc.examples.hello.HelloRequest =
  io.grpc.examples.hello.HelloRequestKt.Dsl._create(io.grpc.examples.hello.HelloRequest.newBuilder()).apply { block() }._build()
/**
 * Protobuf type `hello.HelloRequest`
 */
public object HelloRequestKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: io.grpc.examples.hello.HelloRequest.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: io.grpc.examples.hello.HelloRequest.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): io.grpc.examples.hello.HelloRequest = _builder.build()

    /**
     * `string name = 1;`
     */
    public var name: kotlin.String
      @JvmName("getName")
      get() = _builder.getName()
      @JvmName("setName")
      set(value) {
        _builder.setName(value)
      }
    /**
     * `string name = 1;`
     */
    public fun clearName() {
      _builder.clearName()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun io.grpc.examples.hello.HelloRequest.copy(block: io.grpc.examples.hello.HelloRequestKt.Dsl.() -> kotlin.Unit): io.grpc.examples.hello.HelloRequest =
  io.grpc.examples.hello.HelloRequestKt.Dsl._create(this.toBuilder()).apply { block() }._build()

