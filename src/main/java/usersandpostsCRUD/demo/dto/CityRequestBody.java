package usersandpostsCRUD.demo.dto;

public class CityRequestBody {
    private String name;
    private String postCode;
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
