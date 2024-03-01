package via.sdj3.grpcspringboot.service;


import io.grpc.stub.StreamObserver;
import via.sdj3.grpcspringboot.generated.PackageRequest;
import via.sdj3.grpcspringboot.generated.PackageResponse;

import java.util.UUID;

public class ProductPackageServiceImpl extends ProductPackageServiceGrpc.ProductPackageServiceImplBase {
	public void PackageProduct(PackageRequest request, StreamObserver<PackageResponse> responseObserver){
		//super.packageProduct(request, responseObserver);
		int animalId = request.getProduct().getId();
		String getAnimalName = request.getProduct().getName();

		//generate product id
		UUID uuid = UUID.randomUUID();
		String productId = uuid.toString();

		//log
		System.out.println("The part " + getAnimalName + " from animal with id: " + animalId + " is under packaging");
		String respondMessage = "The part " + getAnimalName + " from animal with id: " + animalId + " is now packaged to a product. \n Priduct ID: " + productId + "\n Status: Ready for delivery.";
		PackageResponse packageResponse = PackageResponse .newBuilder() .setResult(respondMessage).build();

		//send response to the client
		responseObserver.onNext(packageResponse);

		//notifies that the call is completed
		responseObserver.onCompleted();
		System.out.println(respondMessage);
	}
}
