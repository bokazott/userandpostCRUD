package usersandpostsCRUD.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CityRequestBody {
    @NotBlank(message = "City name must not be blank")
    private String name;
    @NotBlank(message = "Post Code must not be blank")
    private String postCode;
    @NotNull(message = "Country ID must not be null")
    private Long countryId;

    // Constructors
    public CityRequestBody() {}

    public CityRequestBody(String name, String postCode, Long countryId) {
        this.name = name;
        this.postCode = postCode;
        this.countryId = countryId;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPostCode() { return postCode; }
    public void setPostCode(String postCode) { this.postCode = postCode; }
    public Long getCountryId() { return countryId; }
    public void setCountryId(Long countryId) { this.countryId = countryId; }
}
