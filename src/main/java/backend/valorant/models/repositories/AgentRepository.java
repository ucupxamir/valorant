package backend.valorant.models.repositories;

import backend.valorant.models.entities.Agent;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface AgentRepository extends CrudRepository<Agent, UUID> {
    List<Agent> findByRole(String role);

    Agent findOneByName(String name);

}
