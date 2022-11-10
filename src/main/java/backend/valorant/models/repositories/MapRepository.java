package backend.valorant.models.repositories;

import backend.valorant.models.entities.Map;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MapRepository extends CrudRepository<Map, UUID> {


}
