package via.sdj3.grpcclientexample.service;

import com.google.protobuf.Int32Value;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import via.sdj3.protobuf.Product;
import via.sdj3.protobuf.ProductServiceGrpc;

@Service
public class ProductService {
	private final static Logger LOG = LoggerFactory.getLogger(ProductService.class);
	@GrpcClient("grpc-server-example")
	ProductServiceGrpc.ProductServiceBlockingStub clientServiceStub;

	public Product getProduct(int id){
		LOG.info("Processing request for product with id: {}", id);

		Product productResponse;

		try {
			productResponse = clientServiceStub.getProduct(Int32Value.newBuilder().setValue(id).build()
			);
		} catch (StatusRuntimeException statusRuntimeException){
			LOG.error("Error in communication");
			return null;
		}
		LOG.debug("Received response: {} ", productResponse.toString());

		return productResponse;
	}
}
