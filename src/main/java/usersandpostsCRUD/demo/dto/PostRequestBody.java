package usersandpostsCRUD.demo.dto;

import java.time.LocalDateTime;

public class PostRequestBody {
    private Long userId;
    private String title;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public PostRequestBody() {
    }

    public PostRequestBody(Long userId, String title, String description, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long UserId) {
        this.userId = UserId;
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
}
