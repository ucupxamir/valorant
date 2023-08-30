package valorant.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import valorant.api.entities.Agent;

import java.util.Optional;
import java.util.UUID;

public interface AgentRepository extends JpaRepository<Agent, UUID> {

    Boolean existsByName(String name);

    Optional<Agent> findByName(String name);

}
