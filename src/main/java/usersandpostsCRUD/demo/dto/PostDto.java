package usersandpostsCRUD.demo.dto;

import java.time.LocalDateTime;

public class PostDto {
    private Long UserId;
    private String title;
    private String description;
    private UserDto userDto;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public PostDto() {
    }

    public PostDto(Long UserId, String title, String description, UserDto userDto, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.UserId = UserId;
        this.title = title;
        this.description = description;
        this.userDto = userDto;
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

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
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
