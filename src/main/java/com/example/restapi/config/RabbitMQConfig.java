package com.example.restapi.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Classe de configuração para o RabbitMQ.
 */
@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE = "recargaExchange";
    public static final String QUEUE = "recargaQueue";
    public static final String ROUTING_KEY = "recargaRoutingKey";

    /**
     * Cria um novo TopicExchange.
     * @return Um TopicExchange.
     */
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

    /**
     * Cria uma nova fila.
     * @return Uma fila.
     */
    @Bean
    public Queue queue() {
        return new Queue(QUEUE);
    }

    /**
     * Cria um novo Binding entre a fila e o TopicExchange.
     * @param queue A fila.
     * @param exchange O TopicExchange.
     * @return Um Binding.
     */
    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    /**
     * Cria um novo MessageConverter.
     * @return Um MessageConverter.
     */
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    /**
     * Cria um novo RabbitTemplate.
     * @param connectionFactory A ConnectionFactory.
     * @return Um RabbitTemplate.
     */
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

    /**
     * Cria um novo RabbitListenerContainerFactory.
     * @param connectionFactory A ConnectionFactory.
     * @return Um RabbitListenerContainerFactory.
     */
    @Bean
    public RabbitListenerContainerFactory<?> rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(jsonMessageConverter());
        return factory;
    }
}
