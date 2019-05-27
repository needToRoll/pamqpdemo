package cloud.buergi.playground.pactamqpdemo.restprovider.configuration;

import cloud.buergi.playground.pactamqpdemo.restprovider.service.aqmp.PersonRepositoryEventHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

    @Bean
    PersonRepositoryEventHandler personRepositoryEventHandler() {
        return new PersonRepositoryEventHandler();
    }
}
