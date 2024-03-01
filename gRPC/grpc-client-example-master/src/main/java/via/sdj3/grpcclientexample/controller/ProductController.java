package via.sdj3.grpcclientexample.controller;

import org.slf4j.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import via.sdj3.grpcclientexample.service.ProductService;
import via.sdj3.protobuf.Product;

@RestController
@RequestMapping(value="/grpc/api")
public class ProductController {
	private final static Logger LOG = LoggerFactory.getLogger(ProductController.class);
	private ProductService productService;

	public ProductController(ProductService productService){
		this.productService = productService;
	}

	@GetMapping(value="/products/{id}")
	public String getProduct (@PathVariable("id") int id){
		LOG.info("Received request for product with id : {}", id);
		Product result = productService.getProduct(id);
		if (result == null){
			return "Product does not exist";
		}
		LOG.info(result.toString());
		return result.toString();
	}

}
