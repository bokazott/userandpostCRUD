package usersandpostsCRUD.demo.dto;

public class CountryResponseBody {
    private Long id;
    private String name;

    // Constructors
    public CountryResponseBody() {}

    public CountryResponseBody(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
