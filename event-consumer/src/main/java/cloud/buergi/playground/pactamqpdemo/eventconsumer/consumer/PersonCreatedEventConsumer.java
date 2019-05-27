package cloud.buergi.playground.pactamqpdemo.eventconsumer.consumer;

import cloud.buergi.playground.pactamqpdemo.eventconsumer.model.PersonDto;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PersonCreatedEventConsumer {

    @RabbitListener(queues = {})
    public void receive(PersonDto message){
        System.out.println(message.toString());
    }

}
