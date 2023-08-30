package valorant.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import valorant.api.dto.BaseResponse;
import valorant.api.dto.MapRequest;
import valorant.api.entities.Map;
import valorant.api.services.MapService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/maps")
public class MapController {

    @Autowired
    private MapService mapService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse<String> create(@RequestBody MapRequest request) {
        mapService.create(request);
        return BaseResponse
                .<String>builder()
                .status("success")
                .message("Map has been successfully created.")
                .build();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse<List<Map>> findAll() {
        List<Map> maps = mapService.findAll();
        return BaseResponse
                .<List<Map>>builder()
                .status("success")
                .data(maps)
                .build();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse<Map> findById(@PathVariable UUID id) {
        Map map = mapService.findById(id);
        return BaseResponse
                .<Map>builder()
                .status("success")
                .data(map)
                .build();
    }

    @PostMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse<String> update(@RequestBody MapRequest request, @PathVariable UUID id) {
        mapService.update(request, id);
        return BaseResponse
                .<String>builder()
                .status("success")
                .message("Map has been successfully updated.")
                .build();
    }

}
