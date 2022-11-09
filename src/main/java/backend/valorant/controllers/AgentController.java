package backend.valorant.controllers;

import backend.valorant.dto.AgentData;
import backend.valorant.dto.ResponseData;
import backend.valorant.dto.SearchData;
import backend.valorant.models.entities.Agent;
import backend.valorant.services.AgentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/agents")
public class AgentController {

    @Autowired
    AgentService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public Iterable<Agent> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Agent findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @GetMapping("/find-by-name/{name}")
    public Agent findOneByName(@PathVariable String name) {
        return service.findOneByName(name);
    }

    @PostMapping
    public ResponseEntity<ResponseData<Agent>> create(@Valid @RequestBody AgentData agentData, Errors errors) {
        ResponseData<Agent> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for(ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        Agent agent = modelMapper.map(agentData, Agent.class);

        responseData.setStatus(true);
        responseData.setData(service.create(agent));
        return ResponseEntity.ok(responseData);

    }

    @PostMapping("/search-by-role")
    public List<Agent> getByRole(@RequestBody SearchData searchData) {
        return service.findByRole(searchData);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Agent>> update(@Valid @RequestBody Agent agent, Errors errors) {
        ResponseData<Agent> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for(ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        Agent newAgent = modelMapper.map(agent, Agent.class);

        responseData.setStatus(true);
        responseData.setData(service.create(newAgent));
        return ResponseEntity.ok(responseData);

    }

}
