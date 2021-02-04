package cloud.buergi.playground.pactamqpdemo.eventconsumer.consumer;

import cloud.buergi.playground.pactamqpdemo.eventconsumer.model.NewsletterParticipant;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PersonCreatedEventConsumer {

    final CrudRepository<NewsletterParticipant, Long> repository;

    public PersonCreatedEventConsumer(CrudRepository<NewsletterParticipant, Long> repository) {
        this.repository = repository;
    }

    @RabbitListener(queues = {"${cloud.buergi.pactamqpdemo.amqp.person.queue}"})
    public void receive(NewsletterParticipant message){
        int virtualDelay = new Random().nextInt(15000);
        try {
            Thread.sleep(virtualDelay);
            repository.save(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
