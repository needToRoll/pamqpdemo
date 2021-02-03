package cloud.buergi.playground.pactamqpdemo.eventconsumer.service.rest;

import cloud.buergi.playground.pactamqpdemo.eventconsumer.model.NewsletterParticipant;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonRestRepoService extends PagingAndSortingRepository<NewsletterParticipant, Long> {
}
