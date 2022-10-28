package by.it_academy.bootcamp.users.dto.response;

public class UserResponseDto {
     private final String fullName;
     private final String email;
     private final String role;

     public UserResponseDto(String fullName, String email, String role) {
          this.fullName = fullName;
          this.email = email;
          this.role = role;
     }

     public String getFullName() {
          return fullName;
     }

     public String getEmail() {
          return email;
     }

     public String getRole() {
          return role;
     }
}
