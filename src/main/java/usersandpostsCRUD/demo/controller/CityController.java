package usersandpostsCRUD.demo.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import usersandpostsCRUD.demo.dto.CityRequestBody;
import usersandpostsCRUD.demo.dto.CityResponseBody;
import usersandpostsCRUD.demo.service.CityService;

import java.util.List;


@RestController
@RequestMapping("/api/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public List<CityResponseBody> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/{id}")
    public CityResponseBody getCityById(@PathVariable Long id) {
        return cityService.getCityById(id);
    }

    @PostMapping
    public CityResponseBody createCity(@Valid @RequestBody CityRequestBody cityRequestBody) {
        return cityService.createCity(cityRequestBody);
    }

    @PutMapping("/{id}")
    public CityResponseBody updateCity(@PathVariable Long id, @RequestBody CityRequestBody cityRequestBody) {
        return cityService.updateCity(id, cityRequestBody);
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
    }
}
