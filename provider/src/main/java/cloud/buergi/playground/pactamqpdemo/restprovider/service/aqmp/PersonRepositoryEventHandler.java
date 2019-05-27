package cloud.buergi.playground.pactamqpdemo.restprovider.service.aqmp;

import cloud.buergi.playground.pactamqpdemo.restprovider.model.ProvidedPerson;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@RepositoryEventHandler(ProvidedPerson.class)
public class PersonRepositoryEventHandler {

    @Value("${cloud.buergi.pactamqpdemo.amqp.person.exchange}")
    private String exchangeName;

    @Value("${cloud.buergi.pactamqpdemo.amqp.person.routingkey}")
    private String routingKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @HandleAfterCreate
    public void sendRabbitEvent(ProvidedPerson providedPerson) {
        rabbitTemplate.convertAndSend(exchangeName, routingKey, providedPerson);
    }

}
