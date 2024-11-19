package usersandpostsCRUD.demo.dto;

import jakarta.validation.constraints.NotBlank;

public class CountryRequestBody {
    @NotBlank(message = "Country name must not be blank")
    private String name;

    // Constructors
    public CountryRequestBody() {}

    public CountryRequestBody(String name) {
        this.name = name;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
