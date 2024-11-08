package usersandpostsCRUD.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usersandpostsCRUD.demo.dto.CityRequestBody;
import usersandpostsCRUD.demo.dto.CityResponseBody;
import usersandpostsCRUD.demo.entity.City;
import usersandpostsCRUD.demo.entity.Country;
import usersandpostsCRUD.demo.exception.CityNotFoundException;
import usersandpostsCRUD.demo.exception.DuplicateCityException;
import usersandpostsCRUD.demo.exception.InvalidCityDataException;
import usersandpostsCRUD.demo.repository.CityRepository;

import java.util.List;

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
    public City findCityById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException(id));
    }

    public CityResponseBody createCity(CityRequestBody cityRequestBody) {
        if(cityRequestBody.getCountryId()==null){
            throw new InvalidCityDataException("Country Id");
        }
        if (cityRequestBody.getName() == null || cityRequestBody.getName().isEmpty()) {
            throw new InvalidCityDataException("City name");
        }
        if (cityRequestBody.getPostCode() == null || cityRequestBody.getPostCode().isEmpty()) {
            throw new InvalidCityDataException("Postal code");
        }
        Country country = countryService.findCountryById(cityRequestBody.getCountryId());
        if (cityRepository.existsByNameAndCountry(cityRequestBody.getName(), country)) {
            throw new DuplicateCityException(cityRequestBody.getName(),country.getName());
        }
        City city = new City();
        city.setName(cityRequestBody.getName());
        city.setPostCode(cityRequestBody.getPostCode());
        city.setCountry(country);

        return convertToResponseBody(cityRepository.save(city));
    }

    public CityResponseBody updateCity(Long id, CityRequestBody cityRequestBody) {
        City city = cityRepository.findById(id).orElseThrow(() -> new CityNotFoundException(id));

        if (cityRequestBody.getName() != null && !cityRequestBody.getName().isEmpty() && !city.getName().equals(cityRequestBody.getName())) {
            Country country = countryService.getCountryByIdInner(city.getCountry().getId());
            cityRepository.existsByNameAndCountry(cityRequestBody.getName(), country);
            city.setName(cityRequestBody.getName());
        }

        if (cityRequestBody.getPostCode() != null && !cityRequestBody.getPostCode().isEmpty()) {
            city.setPostCode(cityRequestBody.getPostCode());
        }

        if (cityRequestBody.getCountryId() != null) {
            Country country = countryService.getCountryByIdInner(cityRequestBody.getCountryId());
            city.setCountry(country);
        }
        return convertToResponseBody(cityRepository.save(city));
    }




    public void deleteCity(Long id) {
        if (!cityRepository.existsById(id)) {
            throw new CityNotFoundException(id);
        }
        cityRepository.deleteById(id);
    }
}
