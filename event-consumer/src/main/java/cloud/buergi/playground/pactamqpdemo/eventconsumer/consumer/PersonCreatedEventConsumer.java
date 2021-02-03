package cloud.buergi.playground.pactamqpdemo.eventconsumer.consumer;

import cloud.buergi.playground.pactamqpdemo.eventconsumer.model.NewsletterParticipant;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PersonCreatedEventConsumer {

    @Autowired
    CrudRepository<NewsletterParticipant, Long> repository;

    @RabbitListener(queues = {})
    public void receive(NewsletterParticipant message){
        int virtualDelay = new Random().nextInt(12000);
        try {
            Thread.sleep(virtualDelay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repository.save(message);

    }

}
