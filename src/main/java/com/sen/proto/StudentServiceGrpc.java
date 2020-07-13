package com.sen.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.30.2)",
    comments = "Source: Student.proto")
public final class StudentServiceGrpc {

  private StudentServiceGrpc() {}

  public static final String SERVICE_NAME = "com.sen.proto.StudentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.sen.proto.MyRequest,
      com.sen.proto.MyResponse> getGetRealNameByUsernameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRealNameByUsername",
      requestType = com.sen.proto.MyRequest.class,
      responseType = com.sen.proto.MyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.sen.proto.MyRequest,
      com.sen.proto.MyResponse> getGetRealNameByUsernameMethod() {
    io.grpc.MethodDescriptor<com.sen.proto.MyRequest, com.sen.proto.MyResponse> getGetRealNameByUsernameMethod;
    if ((getGetRealNameByUsernameMethod = StudentServiceGrpc.getGetRealNameByUsernameMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetRealNameByUsernameMethod = StudentServiceGrpc.getGetRealNameByUsernameMethod) == null) {
          StudentServiceGrpc.getGetRealNameByUsernameMethod = getGetRealNameByUsernameMethod =
              io.grpc.MethodDescriptor.<com.sen.proto.MyRequest, com.sen.proto.MyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRealNameByUsername"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sen.proto.MyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sen.proto.MyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("GetRealNameByUsername"))
              .build();
        }
      }
    }
    return getGetRealNameByUsernameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.sen.proto.StudentRequest,
      com.sen.proto.StudentResponse> getGetUsersByAgeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUsersByAge",
      requestType = com.sen.proto.StudentRequest.class,
      responseType = com.sen.proto.StudentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.sen.proto.StudentRequest,
      com.sen.proto.StudentResponse> getGetUsersByAgeMethod() {
    io.grpc.MethodDescriptor<com.sen.proto.StudentRequest, com.sen.proto.StudentResponse> getGetUsersByAgeMethod;
    if ((getGetUsersByAgeMethod = StudentServiceGrpc.getGetUsersByAgeMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetUsersByAgeMethod = StudentServiceGrpc.getGetUsersByAgeMethod) == null) {
          StudentServiceGrpc.getGetUsersByAgeMethod = getGetUsersByAgeMethod =
              io.grpc.MethodDescriptor.<com.sen.proto.StudentRequest, com.sen.proto.StudentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUsersByAge"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sen.proto.StudentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sen.proto.StudentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("GetUsersByAge"))
              .build();
        }
      }
    }
    return getGetUsersByAgeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.sen.proto.StudentRequest,
      com.sen.proto.StudentList> getGetUsersByAgesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUsersByAges",
      requestType = com.sen.proto.StudentRequest.class,
      responseType = com.sen.proto.StudentList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.sen.proto.StudentRequest,
      com.sen.proto.StudentList> getGetUsersByAgesMethod() {
    io.grpc.MethodDescriptor<com.sen.proto.StudentRequest, com.sen.proto.StudentList> getGetUsersByAgesMethod;
    if ((getGetUsersByAgesMethod = StudentServiceGrpc.getGetUsersByAgesMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetUsersByAgesMethod = StudentServiceGrpc.getGetUsersByAgesMethod) == null) {
          StudentServiceGrpc.getGetUsersByAgesMethod = getGetUsersByAgesMethod =
              io.grpc.MethodDescriptor.<com.sen.proto.StudentRequest, com.sen.proto.StudentList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUsersByAges"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sen.proto.StudentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sen.proto.StudentList.getDefaultInstance()))
              .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("GetUsersByAges"))
              .build();
        }
      }
    }
    return getGetUsersByAgesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.sen.proto.StreamRequest,
      com.sen.proto.StreamResponse> getBiTackMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "biTack",
      requestType = com.sen.proto.StreamRequest.class,
      responseType = com.sen.proto.StreamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.sen.proto.StreamRequest,
      com.sen.proto.StreamResponse> getBiTackMethod() {
    io.grpc.MethodDescriptor<com.sen.proto.StreamRequest, com.sen.proto.StreamResponse> getBiTackMethod;
    if ((getBiTackMethod = StudentServiceGrpc.getBiTackMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getBiTackMethod = StudentServiceGrpc.getBiTackMethod) == null) {
          StudentServiceGrpc.getBiTackMethod = getBiTackMethod =
              io.grpc.MethodDescriptor.<com.sen.proto.StreamRequest, com.sen.proto.StreamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "biTack"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sen.proto.StreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sen.proto.StreamResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("biTack"))
              .build();
        }
      }
    }
    return getBiTackMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StudentServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StudentServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StudentServiceStub>() {
        @java.lang.Override
        public StudentServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StudentServiceStub(channel, callOptions);
        }
      };
    return StudentServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StudentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StudentServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StudentServiceBlockingStub>() {
        @java.lang.Override
        public StudentServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StudentServiceBlockingStub(channel, callOptions);
        }
      };
    return StudentServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StudentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StudentServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StudentServiceFutureStub>() {
        @java.lang.Override
        public StudentServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StudentServiceFutureStub(channel, callOptions);
        }
      };
    return StudentServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class StudentServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getRealNameByUsername(com.sen.proto.MyRequest request,
        io.grpc.stub.StreamObserver<com.sen.proto.MyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRealNameByUsernameMethod(), responseObserver);
    }

    /**
     */
    public void getUsersByAge(com.sen.proto.StudentRequest request,
        io.grpc.stub.StreamObserver<com.sen.proto.StudentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetUsersByAgeMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.sen.proto.StudentRequest> getUsersByAges(
        io.grpc.stub.StreamObserver<com.sen.proto.StudentList> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetUsersByAgesMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.sen.proto.StreamRequest> biTack(
        io.grpc.stub.StreamObserver<com.sen.proto.StreamResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getBiTackMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetRealNameByUsernameMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.sen.proto.MyRequest,
                com.sen.proto.MyResponse>(
                  this, METHODID_GET_REAL_NAME_BY_USERNAME)))
          .addMethod(
            getGetUsersByAgeMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.sen.proto.StudentRequest,
                com.sen.proto.StudentResponse>(
                  this, METHODID_GET_USERS_BY_AGE)))
          .addMethod(
            getGetUsersByAgesMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.sen.proto.StudentRequest,
                com.sen.proto.StudentList>(
                  this, METHODID_GET_USERS_BY_AGES)))
          .addMethod(
            getBiTackMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.sen.proto.StreamRequest,
                com.sen.proto.StreamResponse>(
                  this, METHODID_BI_TACK)))
          .build();
    }
  }

  /**
   */
  public static final class StudentServiceStub extends io.grpc.stub.AbstractAsyncStub<StudentServiceStub> {
    private StudentServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StudentServiceStub(channel, callOptions);
    }

    /**
     */
    public void getRealNameByUsername(com.sen.proto.MyRequest request,
        io.grpc.stub.StreamObserver<com.sen.proto.MyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetRealNameByUsernameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUsersByAge(com.sen.proto.StudentRequest request,
        io.grpc.stub.StreamObserver<com.sen.proto.StudentResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetUsersByAgeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.sen.proto.StudentRequest> getUsersByAges(
        io.grpc.stub.StreamObserver<com.sen.proto.StudentList> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getGetUsersByAgesMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.sen.proto.StreamRequest> biTack(
        io.grpc.stub.StreamObserver<com.sen.proto.StreamResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getBiTackMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class StudentServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<StudentServiceBlockingStub> {
    private StudentServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StudentServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.sen.proto.MyResponse getRealNameByUsername(com.sen.proto.MyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetRealNameByUsernameMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.sen.proto.StudentResponse> getUsersByAge(
        com.sen.proto.StudentRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetUsersByAgeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class StudentServiceFutureStub extends io.grpc.stub.AbstractFutureStub<StudentServiceFutureStub> {
    private StudentServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StudentServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.sen.proto.MyResponse> getRealNameByUsername(
        com.sen.proto.MyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetRealNameByUsernameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_REAL_NAME_BY_USERNAME = 0;
  private static final int METHODID_GET_USERS_BY_AGE = 1;
  private static final int METHODID_GET_USERS_BY_AGES = 2;
  private static final int METHODID_BI_TACK = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StudentServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StudentServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_REAL_NAME_BY_USERNAME:
          serviceImpl.getRealNameByUsername((com.sen.proto.MyRequest) request,
              (io.grpc.stub.StreamObserver<com.sen.proto.MyResponse>) responseObserver);
          break;
        case METHODID_GET_USERS_BY_AGE:
          serviceImpl.getUsersByAge((com.sen.proto.StudentRequest) request,
              (io.grpc.stub.StreamObserver<com.sen.proto.StudentResponse>) responseObserver);
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
        case METHODID_GET_USERS_BY_AGES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getUsersByAges(
              (io.grpc.stub.StreamObserver<com.sen.proto.StudentList>) responseObserver);
        case METHODID_BI_TACK:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.biTack(
              (io.grpc.stub.StreamObserver<com.sen.proto.StreamResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class StudentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StudentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.sen.proto.StudentProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StudentService");
    }
  }

  private static final class StudentServiceFileDescriptorSupplier
      extends StudentServiceBaseDescriptorSupplier {
    StudentServiceFileDescriptorSupplier() {}
  }

  private static final class StudentServiceMethodDescriptorSupplier
      extends StudentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StudentServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (StudentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StudentServiceFileDescriptorSupplier())
              .addMethod(getGetRealNameByUsernameMethod())
              .addMethod(getGetUsersByAgeMethod())
              .addMethod(getGetUsersByAgesMethod())
              .addMethod(getBiTackMethod())
              .build();
        }
      }
    }
    return result;
  }
}
