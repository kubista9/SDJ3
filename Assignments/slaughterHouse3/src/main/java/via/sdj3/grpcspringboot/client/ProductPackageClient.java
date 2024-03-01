package via.sdj3.grpcspringboot.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import via.sdj3.grpcspringboot.generated.PackageRequest;
import via.sdj3.grpcspringboot.generated.PackageResponse;
import via.sdj3.grpcspringboot.generated.Product;

public class ProductPackageClient {
	public static void main(String[] args) {
		//Channel is used by the client to communicate with the server
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5006).usePlaintext().build();

		//Auto via.sdj3.grpcspringboot.generated stub class with the constructor wrapping the channel
		ProductPackageServiceGrpc.ProductPackageServiceBlockingStub stub = ProductPackageServiceGrpc.newBlockingStub(channel);

		//start calling the methods - packageProduct

		PackageRequest packageRequest = PackageRequest.newBuilder()
			.setProduct(Product.newBuilder()
				.setAnimalId("C-356")
				.setAnimalPart("Whole chicken")
				.build())
			.build();

		PackageResponse packageResponse = stub.packageProduct(packageRequest);
		System.out.println("Response " + packageResponse.getResult());
	}
}
