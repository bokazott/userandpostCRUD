package usersandpostsCRUD.demo.dto;

public class CountryRequestBody {
    private String name;

    // Constructors
    public CountryRequestBody() {}

    public CountryRequestBody(String name) {
        this.name = name;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
