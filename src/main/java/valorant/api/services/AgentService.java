package valorant.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import valorant.api.dto.AgentRequest;
import valorant.api.entities.Agent;
import valorant.api.repositories.AgentRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AgentService {

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public void create(AgentRequest request) {
        validationService.validate(request);

        if (agentRepository.existsByName(request.getName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Agent already exists.");
        }

        Agent agent = new Agent();
        agent.setName(request.getName());
        agent.setRole(request.getRole());

        agentRepository.save(agent);
    }

    @Transactional(readOnly = true)
    public List<Agent> findAll() {
        return agentRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Agent findById(UUID id) {
        return agentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agent not found."));
    }

    @Transactional
    public void update(AgentRequest request, UUID id) {
        validationService.validate(request);

        Agent agent = agentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agent not found."));

        Optional<Agent> agentByName = agentRepository.findByName(request.getName());

        if (agentByName.isPresent() && agentByName.get().getId() != id) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Agent already exists.");
        }

        agent.setName(request.getName());
        agent.setRole(request.getRole());

        agentRepository.save(agent);
    }

}
