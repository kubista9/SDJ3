package via.sdj3.springrabbitmqdemo.configs;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    // exchange --- direct exchange spring bean
    @Bean
    public Exchange productExchange() {
        return new DirectExchange("x.products-exchange");
    }

    @Bean
    public Queue productQueue() {
        return new Queue("q.product-packaging");
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(productQueue())
                .to(productExchange())
                .with("products.routingKey").noargs();
    }

    // configure a converter for JSON serialization and deserialization
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
