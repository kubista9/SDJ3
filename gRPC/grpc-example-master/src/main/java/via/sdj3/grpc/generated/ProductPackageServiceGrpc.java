package via.sdj3.grpc.generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.58.0)",
    comments = "Source: ProductPackage.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ProductPackageServiceGrpc {

  private ProductPackageServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "ProductPackageService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<via.sdj3.grpc.generated.PackageRequest,
      via.sdj3.grpc.generated.PackageResponse> getPackageProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "packageProduct",
      requestType = via.sdj3.grpc.generated.PackageRequest.class,
      responseType = via.sdj3.grpc.generated.PackageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sdj3.grpc.generated.PackageRequest,
      via.sdj3.grpc.generated.PackageResponse> getPackageProductMethod() {
    io.grpc.MethodDescriptor<via.sdj3.grpc.generated.PackageRequest, via.sdj3.grpc.generated.PackageResponse> getPackageProductMethod;
    if ((getPackageProductMethod = ProductPackageServiceGrpc.getPackageProductMethod) == null) {
      synchronized (ProductPackageServiceGrpc.class) {
        if ((getPackageProductMethod = ProductPackageServiceGrpc.getPackageProductMethod) == null) {
          ProductPackageServiceGrpc.getPackageProductMethod = getPackageProductMethod =
              io.grpc.MethodDescriptor.<via.sdj3.grpc.generated.PackageRequest, via.sdj3.grpc.generated.PackageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "packageProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sdj3.grpc.generated.PackageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sdj3.grpc.generated.PackageResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProductPackageServiceMethodDescriptorSupplier("packageProduct"))
              .build();
        }
      }
    }
    return getPackageProductMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProductPackageServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductPackageServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductPackageServiceStub>() {
        @java.lang.Override
        public ProductPackageServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductPackageServiceStub(channel, callOptions);
        }
      };
    return ProductPackageServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProductPackageServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductPackageServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductPackageServiceBlockingStub>() {
        @java.lang.Override
        public ProductPackageServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductPackageServiceBlockingStub(channel, callOptions);
        }
      };
    return ProductPackageServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProductPackageServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductPackageServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductPackageServiceFutureStub>() {
        @java.lang.Override
        public ProductPackageServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductPackageServiceFutureStub(channel, callOptions);
        }
      };
    return ProductPackageServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     *unary
     * </pre>
     */
    default void packageProduct(via.sdj3.grpc.generated.PackageRequest request,
        io.grpc.stub.StreamObserver<via.sdj3.grpc.generated.PackageResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPackageProductMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ProductPackageService.
   */
  public static abstract class ProductPackageServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ProductPackageServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ProductPackageService.
   */
  public static final class ProductPackageServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ProductPackageServiceStub> {
    private ProductPackageServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductPackageServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductPackageServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *unary
     * </pre>
     */
    public void packageProduct(via.sdj3.grpc.generated.PackageRequest request,
        io.grpc.stub.StreamObserver<via.sdj3.grpc.generated.PackageResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPackageProductMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ProductPackageService.
   */
  public static final class ProductPackageServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ProductPackageServiceBlockingStub> {
    private ProductPackageServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductPackageServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductPackageServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *unary
     * </pre>
     */
    public via.sdj3.grpc.generated.PackageResponse packageProduct(via.sdj3.grpc.generated.PackageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPackageProductMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ProductPackageService.
   */
  public static final class ProductPackageServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ProductPackageServiceFutureStub> {
    private ProductPackageServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductPackageServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductPackageServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sdj3.grpc.generated.PackageResponse> packageProduct(
        via.sdj3.grpc.generated.PackageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPackageProductMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PACKAGE_PRODUCT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PACKAGE_PRODUCT:
          serviceImpl.packageProduct((via.sdj3.grpc.generated.PackageRequest) request,
              (io.grpc.stub.StreamObserver<via.sdj3.grpc.generated.PackageResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getPackageProductMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              via.sdj3.grpc.generated.PackageRequest,
              via.sdj3.grpc.generated.PackageResponse>(
                service, METHODID_PACKAGE_PRODUCT)))
        .build();
  }

  private static abstract class ProductPackageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProductPackageServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return via.sdj3.grpc.generated.ProductPackage.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProductPackageService");
    }
  }

  private static final class ProductPackageServiceFileDescriptorSupplier
      extends ProductPackageServiceBaseDescriptorSupplier {
    ProductPackageServiceFileDescriptorSupplier() {}
  }

  private static final class ProductPackageServiceMethodDescriptorSupplier
      extends ProductPackageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ProductPackageServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ProductPackageServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProductPackageServiceFileDescriptorSupplier())
              .addMethod(getPackageProductMethod())
              .build();
        }
      }
    }
    return result;
  }
}
