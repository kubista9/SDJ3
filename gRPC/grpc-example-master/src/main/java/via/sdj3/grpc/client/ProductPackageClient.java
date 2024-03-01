package via.sdj3.grpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import via.sdj3.grpc.generated.PackageRequest;
import via.sdj3.grpc.generated.PackageResponse;
import via.sdj3.grpc.generated.Product;
import via.sdj3.grpc.generated.ProductPackageServiceGrpc;

public class ProductPackageClient {
	public static void main(String[] args) {
		//Channel is used by the client to communicate with the server
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5006).usePlaintext().build();

		//Auto generated stub class with the constructor wrapping the channel
		ProductPackageServiceGrpc.ProductPackageServiceBlockingStub stub = ProductPackageServiceGrpc.newBlockingStub(channel);

		//start calling the methods - packageProduct

		PackageRequest packageRequest = PackageRequest.newBuilder()
			.setProduct(Product.newBuilder().
				setAnimalId("C-356")
				.setAnimalPart("Whole chicken")
				.build())
			.build();

		PackageResponse packageResponse = stub.packageProduct(packageRequest);
		System.out.println("Response " + packageResponse.getResult());
	}
}
