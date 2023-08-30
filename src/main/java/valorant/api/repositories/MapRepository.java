package valorant.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import valorant.api.entities.Map;

import java.util.Optional;
import java.util.UUID;

public interface MapRepository extends JpaRepository<Map, UUID> {

    Boolean existsByName(String name);

    Optional<Map> findByName(String name);

}
