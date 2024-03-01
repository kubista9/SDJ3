package via.sdj3.springrabbitmqdemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import via.sdj3.springrabbitmqdemo.dto.PackageProductDTO;
import via.sdj3.springrabbitmqdemo.dto.PackageProductPayload;

import java.util.Random;

@Service
public class ProductPackager {
    private RabbitTemplate rabbitTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductPackager.class);
    private String EXCHANGE = "x.products-exchange";
    private String QUEUE_NAME = "q.product-packaging";
    private String ROUTING_KEY = "products.routingKey";

    public ProductPackager(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public boolean packageProduct(PackageProductDTO product) {

        int confirmationCode = generateRandomCode();
        PackageProductPayload payload = new PackageProductPayload(
                product.id(), product.description(), product.numberOfParts(),
                product.weight(), product.packaged(),
                confirmationCode
        );
        try {
            LOGGER.info(String.format("Received >>> %s", payload.toString()));
            rabbitTemplate.convertAndSend(QUEUE_NAME, payload);
            return true;
        } catch (Exception e){
            LOGGER.error(String.format("Error ... %s", e.toString()));
            return false;
        }
    }

    private int generateRandomCode() {
        Random r = new Random();
        int n = r.nextInt(90000) + 10000;
        return n;
    }


}
