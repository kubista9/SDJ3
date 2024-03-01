package via.sdj3.grpc.server;

import io.grpc.stub.StreamObserver;
import via.sdj3.grpc.generated.PackageRequest;
import via.sdj3.grpc.generated.PackageResponse;
import via.sdj3.grpc.generated.ProductPackageServiceGrpc;

import java.util.UUID;

public class ProductPackageServiceImpl extends ProductPackageServiceGrpc.ProductPackageServiceImplBase {
	public void PackageProduct(PackageRequest request, StreamObserver<PackageResponse> responseObserver){
		//super.packageProduct(request, responseObserver);
		String animalId = request.getProduct().getAnimalId();
		String animalPart = request.getProduct().getAnimalPart();

		//generate product id
		UUID uuid = UUID.randomUUID();
		String productId = uuid.toString();

		//log
		System.out.println("The part " + animalPart + " from animal with id: " + animalId + " is under packaging");
		String respondMessage = "The part " + animalPart + " from animal with id: " + animalId + " is now packaged to a product. \n Priduct ID: " + productId + "\n Status: Ready for delivery.";
		PackageResponse packageResponse = PackageResponse .newBuilder() .setResult(respondMessage).build();

		//send response to the client
		responseObserver.onNext(packageResponse);

		//notifies that the call is completed
		responseObserver.onCompleted();
		System.out.println(respondMessage);
	}
}
