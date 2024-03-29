package com.example.slaughterhousepart3.server;

import com.example.slaughterhousepart3.generated.product.RequestId;
import com.example.slaughterhousepart3.generated.product.ResponseText;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.stereotype.Service;

import java.util.UUID;


@GrpcService
public class ProductPackageServiceImpl  {
	public void PackageProduct(RequestId request, StreamObserver<ResponseText> responseObserver){
		int input = request.getId();
		String output = responseObserver.toString(); //for asynchronous communication

		//generate product id
		UUID uuid = UUID.randomUUID();
		String productId = uuid.toString();

		//log
		System.out.println("Input: " + input + " and Output: " + output);
		String respondMessage = "Input: " + input + " and Output: " + output + "was send.";
		ResponseText packageResponse = ResponseText .newBuilder().build();

		//send response to the client
		responseObserver.onNext(packageResponse);

		//notifies that the call is completed
		responseObserver.onCompleted();
		System.out.println(respondMessage);
	}
}
