package backend.valorant.services;

import backend.valorant.models.entities.Map;
import backend.valorant.models.repositories.MapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class MapService {

    @Autowired
    private MapRepository repository;

    public Iterable<Map> findAll() {
        return repository.findAll();
    }

    public Map findById(UUID id) {
        Optional<Map> map = repository.findById(id);
        if (!map.isPresent()) {
            return null;
        }
        return map.get();
    }

    public Map create(Map map) {
        return repository.save(map);
    }

}
