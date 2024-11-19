package usersandpostsCRUD.demo.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import usersandpostsCRUD.demo.dto.CountryRequestBody;
import usersandpostsCRUD.demo.dto.CountryResponseBody;
import usersandpostsCRUD.demo.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {


    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<CountryResponseBody> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/{id}")
    public CountryResponseBody getCountryById(@PathVariable Long id) {
        return countryService.getCountryById(id);
    }

    @PostMapping
    public CountryResponseBody createCountry(@Valid @RequestBody CountryRequestBody countryRequestBody) {
        return countryService.createCountry(countryRequestBody);
    }

    @PutMapping("/{id}")
    public CountryResponseBody updateCountry(@PathVariable Long id, @RequestBody CountryRequestBody countryRequestBody) {
        return countryService.updateCountry(id, countryRequestBody);
    }

    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
    }
}
