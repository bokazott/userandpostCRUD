package usersandpostsCRUD.demo.dto;

import java.time.LocalDateTime;

public class PostRequestBody {
    private Long UserId;
    private String title;
    private String description;
    private UserRequestBody userRequestBody;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public PostRequestBody() {
    }

    public PostRequestBody(Long UserId, String title, String description, UserRequestBody userRequestBody, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.UserId = UserId;
        this.title = title;
        this.description = description;
        this.userRequestBody = userRequestBody;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long UserId) {
        this.UserId = UserId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserRequestBody getUserDto() {
        return userRequestBody;
    }

    public void setUserDto(UserRequestBody userRequestBody) {
        this.userRequestBody = userRequestBody;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}
