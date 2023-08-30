package valorant.api.controllers;

import org.springframework.http.MediaType;
import valorant.api.dto.AgentRequest;
import valorant.api.dto.BaseResponse;
import valorant.api.entities.Agent;
import valorant.api.services.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/agents")
public class AgentController {

    @Autowired
    private AgentService agentService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse<String> create(@RequestBody AgentRequest request) {
        agentService.create(request);
        return BaseResponse
                .<String>builder()
                .status("success")
                .message("Agent has been successfully created.")
                .build();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse<List<Agent>> findAll() {
        List<Agent> agents = agentService.findAll();
        return BaseResponse
                .<List<Agent>>builder()
                .status("success")
                .data(agents)
                .build();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse<Agent> findById(@PathVariable UUID id) {
        Agent agent = agentService.findById(id);
        return BaseResponse
                .<Agent>builder()
                .status("success")
                .data(agent)
                .build();
    }

    @PostMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse<String> update(@RequestBody AgentRequest request, @PathVariable UUID id) {
        agentService.update(request, id);
        return BaseResponse
                .<String>builder()
                .status("success")
                .message("Agent has been successfully updated.")
                .build();
    }

}
