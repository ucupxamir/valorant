package valorant.api.services;

import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import valorant.api.dto.MapRequest;
import valorant.api.entities.Map;
import valorant.api.repositories.MapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MapService {

    @Autowired
    private MapRepository mapRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public void create(MapRequest request) {
        validationService.validate(request);

        if (mapRepository.existsByName(request.getName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Map already exists.");
        }

        Map map = new Map();
        map.setName(request.getName());

        mapRepository.save(map);
    }

    @Transactional(readOnly = true)
    public List<Map> findAll() {
        return mapRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Map findById(UUID id) {
        return mapRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Map not found."));
    }

    @Transactional
    public void update(MapRequest request, UUID id) {
        validationService.validate(request);

        Map map = mapRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Map not found."));

        Optional<Map> mapByName = mapRepository.findByName(request.getName());

        if (mapByName.isPresent() && mapByName.get().getId() != id) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Map already exists.");
        }

        map.setName(request.getName());

        mapRepository.save(map);
    }

}
