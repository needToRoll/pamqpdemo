package cloud.buergi.playground.pactamqpdemo.eventconsumer.configuration;

import cloud.buergi.playground.pactamqpdemo.eventconsumer.model.NewsletterParticipant;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {

    @Value("${cloud.buergi.pactamqpdemo.amqp.person.exchange}")
    private String exchangeName;

    @Value("${cloud.buergi.pactamqpdemo.amqp.person.routingkey}")
    private String routingKey;

    @Value("${cloud.buergi.pactamqpdemo.amqp.person.queue}")
    private String queueName;

    @Bean
    public TopicExchange createTopicExchange(){
        TopicExchange personTopicExchange = new TopicExchange(exchangeName);
        return personTopicExchange;
    }

    @Bean
    public Queue personCreatedQueue() {
        Queue personCreatedQueue = new Queue(queueName,true, false, false);
        return personCreatedQueue;
    }

    @Bean
    public Binding personCreationBinding(Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with(routingKey);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory, MessageConverter messageConverter){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

}
