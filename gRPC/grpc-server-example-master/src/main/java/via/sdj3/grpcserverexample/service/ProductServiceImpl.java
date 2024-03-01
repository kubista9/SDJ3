package via.sdj3.grpcserverexample.service;

import com.google.protobuf.Int32Value;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import via.sdj3.protobuf.Product;
import via.sdj3.protobuf.ProductServiceGrpc;

import java.util.List;

@GrpcService
public class ProductServiceImpl extends ProductServiceGrpc.ProductServiceImplBase {
	private final static Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);
	private final static List<Product> PRODUCTS = List.of(
		Product.newBuilder().setId(1).setName("Full chicken").setNetWeight(2.0).setDescription("Full chicken originating from Poland").build(),
		Product.newBuilder().setId(2).setName("Big duck").setNetWeight(3.5).setDescription("Bog duck from Spain").build());

	@Override
	public void getProduct(Int32Value request, StreamObserver<Product> responseObserver) {
		// super.getProduct(request, responseObserver);
		LOG.info(">>>> executing getProduct() ....");
		Product isProductPresent = PRODUCTS.stream().filter(findProduct -> request.getValue() == findProduct.getId()).findFirst().orElseThrow();
		LOG.info(isProductPresent.toString());
		responseObserver.onNext(isProductPresent);
		responseObserver.onCompleted();
	}
}
