package backend.valorant.controllers;

import backend.valorant.dto.MapData;
import backend.valorant.dto.ResponseData;
import backend.valorant.models.entities.Agent;
import backend.valorant.models.entities.Map;
import backend.valorant.services.MapService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/maps")
public class MapController {

    @Autowired
    private MapService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public Iterable<Map> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Map findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<ResponseData<Map>> create(@Valid @RequestBody MapData mapData, Errors errors) {
        ResponseData<Map> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        Map map = modelMapper.map(mapData, Map.class);

        responseData.setStatus(true);
        responseData.setData(service.create(map));
        return ResponseEntity.ok(responseData);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Map>> create(@Valid @RequestBody Map map, Errors errors) {
        ResponseData<Map> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        Map newMap = modelMapper.map(map, Map.class);

        responseData.setStatus(true);
        responseData.setData(service.create(newMap));
        return ResponseEntity.ok(responseData);
    }

}
