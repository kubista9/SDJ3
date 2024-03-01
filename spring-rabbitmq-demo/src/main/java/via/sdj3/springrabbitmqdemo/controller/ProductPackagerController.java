package via.sdj3.springrabbitmqdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import via.sdj3.springrabbitmqdemo.dto.PackageProductDTO;
import via.sdj3.springrabbitmqdemo.service.ProductPackager;

@RestController
@RequestMapping("/amqp/api/products/")
public class ProductPackagerController {
    private ProductPackager rabbitMQService;

    public ProductPackagerController(ProductPackager rabbitMQService) {
        this.rabbitMQService = rabbitMQService;
    }

    @PostMapping("/package")
    public ResponseEntity<String> packageProduct(@RequestBody PackageProductDTO product) {
        if(rabbitMQService.packageProduct(product)) {
            System.out.println(product.description() + " Sent "+ HttpStatus.OK.toString());
            return ResponseEntity.ok(product.description() + " sent to the RabbitMQ Server");
        }
        else {
            return ResponseEntity.status(500).body("Error...");
        }
    }

}
