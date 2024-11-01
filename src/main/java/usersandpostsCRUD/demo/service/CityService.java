package usersandpostsCRUD.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usersandpostsCRUD.demo.dto.CityRequestBody;
import usersandpostsCRUD.demo.dto.CityResponseBody;
import usersandpostsCRUD.demo.entity.City;
import usersandpostsCRUD.demo.entity.Country;
import usersandpostsCRUD.demo.exception.CityNotFoundException;
import usersandpostsCRUD.demo.repository.CityRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityService {

    private final CityRepository cityRepository;
    private final CountryService countryService;

    @Autowired
    public CityService(CityRepository cityRepository, CountryService countryService) {
        this.cityRepository = cityRepository;
        this.countryService = countryService;
    }

    public List<CityResponseBody> getAllCities() {
        return cityRepository.findAll().stream()
                .map(this::convertToResponseBody)
                .collect(Collectors.toList());
    }
    private CityResponseBody convertToResponseBody(City city) {
        return new CityResponseBody(city.getId(), city.getName(), city.getPostCode(), city.getCountry().getId());
    }

    public CityResponseBody getCityById(Long id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException(id));
        return convertToResponseBody(city);
    }

    public CityResponseBody createCity(CityRequestBody cityRequestBody) {
        Country country = countryService.findCountryById(cityRequestBody.getCountryId());
        City city = new City();
        city.setName(cityRequestBody.getName());
        city.setPostCode(cityRequestBody.getPostCode());
        city.setCountry(country);

        return convertToResponseBody(cityRepository.save(city));
    }

    public CityResponseBody updateCity(Long id, CityRequestBody cityRequestBody) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException(id));
        Country country = countryService.findCountryById(cityRequestBody.getCountryId());

        city.setName(cityRequestBody.getName());
        city.setPostCode(cityRequestBody.getPostCode());
        city.setCountry(country);

        return convertToResponseBody(cityRepository.save(city));
    }

    public void deleteCity(Long id) {
        if (!cityRepository.existsById(id)) {
            throw new CityNotFoundException(id);
        }
        cityRepository.deleteById(id);
    }
}
