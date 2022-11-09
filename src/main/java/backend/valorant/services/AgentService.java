package backend.valorant.services;

import backend.valorant.dto.SearchData;
import backend.valorant.models.entities.Agent;
import backend.valorant.models.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class AgentService {

    @Autowired
    private AgentRepository repository;

    public Iterable<Agent> findAll() {
        return repository.findAll();
    }

    public Agent findById(UUID id) {
        Optional<Agent> agent = repository.findById(id);
        if (!agent.isPresent()) {
            return null;
        }
        return agent.get();
    }

    public Agent findOneByName(String name) {
        return repository.findOneByName(name);
    }

    public List<Agent> findByRole(SearchData searchData) {
        return repository.findByRole(searchData.getSearchKey());
    }

    public Agent create(Agent agent) {
        return repository.save(agent);
    }

}
