package usersandpostsCRUD.demo.dto;

import java.time.LocalDateTime;

public class PostResponseBody {
    private String title;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private UserDto user;

    public PostResponseBody() {
    }

    public PostResponseBody(String title, String description, LocalDateTime createdDate, LocalDateTime updatedDate, UserDto user) {
        this.title = title;
        this.description = description;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.user = user;
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

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
