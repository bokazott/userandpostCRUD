package usersandpostsCRUD.demo.dto;
import jakarta.validation.constraints.*;

public class UserRequestBody {
    @NotBlank(message = "First Name must not be blank")
    private String firstName;
    @NotBlank(message = "Last Name must not be blank")
    private String lastName;
    @Min(value = 0, message = "Age must be greater than or equal to 0")
    private Integer age;
    @NotNull(message = "Weight cannot be null")
    private Integer weight;
    @NotNull(message = "Height cannot be null")
    private Integer height;
    @Email(message = "Invalid email")
    private String email;
    @NotBlank(message = "Phone number must not be blank")

    private String phoneNumber;
    @NotNull(message = "City Id cannot be null")
    private Long cityId;


    public UserRequestBody(String firstName, String lastName, Integer age, Integer weight, Integer height, String email, String phoneNumber, Long cityId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.cityId=cityId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
}
