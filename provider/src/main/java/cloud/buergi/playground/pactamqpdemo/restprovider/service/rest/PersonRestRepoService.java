package cloud.buergi.playground.pactamqpdemo.restprovider.service.rest;

import cloud.buergi.playground.pactamqpdemo.restprovider.model.ProvidedPerson;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonRestRepoService extends PagingAndSortingRepository<ProvidedPerson,Long> {
}
