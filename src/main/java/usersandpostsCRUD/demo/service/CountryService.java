package usersandpostsCRUD.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usersandpostsCRUD.demo.dto.CountryRequestBody;
import usersandpostsCRUD.demo.dto.CountryResponseBody;
import usersandpostsCRUD.demo.entity.Country;
import usersandpostsCRUD.demo.exception.CountryNotFoundException;
import usersandpostsCRUD.demo.repository.CountryRepository;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository){
        this.countryRepository=countryRepository;
    }
   public List<CountryResponseBody> getAllCountries(){
        return countryRepository.findAll().stream().map(this::convertToResponseBody)
                .collect(Collectors.toList());
   }
   private CountryResponseBody convertToResponseBody(Country country){
        return new CountryResponseBody(country.getId(), country.getName());
   }
   public CountryResponseBody getCountryById(Long id){
        return countryRepository.findById(id)
                .map(this::convertToResponseBody)
                .orElseThrow(()-> new CountryNotFoundException(id));
   }
    public CountryResponseBody createCountry(CountryRequestBody countryRequestBody) {
        Country country = new Country();
        country.setName(countryRequestBody.getName());
        return convertToResponseBody(countryRepository.save(country));
    }
    public CountryResponseBody updateCountry(Long id, CountryRequestBody countryRequestBody) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new CountryNotFoundException(id));
        country.setName(countryRequestBody.getName());
        return convertToResponseBody(countryRepository.save(country));
    }
    public void deleteCountry(Long id) {
        if (!countryRepository.existsById(id)) {
            throw new CountryNotFoundException(id);
        }
        countryRepository.deleteById(id);
    }

    public Country findCountryById(Long id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new CountryNotFoundException(id));
    }
}