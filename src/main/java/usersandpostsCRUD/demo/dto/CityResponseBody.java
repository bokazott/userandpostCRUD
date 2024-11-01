package usersandpostsCRUD.demo.dto;

public class CityResponseBody {
    private Long id;
    private String name;
    private String postCode;
    private Long countryId;

    // Constructors
    public CityResponseBody() {}

    public CityResponseBody(Long id, String name, String postCode, Long countryId) {
        this.id = id;
        this.name = name;
        this.postCode = postCode;
        this.countryId = countryId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPostCode() {
        return postCode;
    }
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
    public Long getCountryId() {
        return countryId;
    }
    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }
}
