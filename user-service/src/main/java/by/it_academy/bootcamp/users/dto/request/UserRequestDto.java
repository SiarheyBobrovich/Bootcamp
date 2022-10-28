package by.it_academy.bootcamp.users.dto.request;

import by.it_academy.bootcamp.users.enums.Role;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

/**
 * User
 */
@ApiModel
@Validated
@JsonDeserialize(builder = UserRequestDto.Builder.class)
public class UserRequestDto {
    @ApiModelProperty(example = "Ivan", required = true)
    private final String name;
    @ApiModelProperty(example = "Ivanov", required = true)
    private final String surname;
    @ApiModelProperty(example = "Ivanovich", required = true)
    private final String patronymic;
    @ApiModelProperty(example =
            "username@domain.com, " +
            "user.name@domain.com, " +
            "user-name@domain.com, " +
            "username@domain.co.in, " +
            "user_name@domain.com",
            required = true)
    private final String email;

    @ApiModelProperty(required = true, reference = "by.it_academy.bootcamp.users.enums.Role")
    private final Role role;

    public UserRequestDto(String name,
                          String surname,
                          String patronymic,
                          String email,
                          Role role) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.email = email;
        this.role = role;
    }

    /**
    * user's name
    * @return name
    **/
    @NotEmpty(message = "must not be empty")
    @Size(min = 1, max = 20, message = "size must be 1 ~ 20")
    @Pattern(regexp = "[A-Za-z]+", message = "must be only Latin alphabet")
    public String getName() {
        return name;
    }

    /**
     * user's surname
     * @return surname
     **/
    @NotEmpty(message = "must not be empty")
    @Size(min = 1, max = 40, message = "size must be 1 ~ 40")
    @Pattern(regexp = "[A-Za-z]+", message = "must be only Latin alphabet")
    public String getSurname() {
        return surname;
    }

    /**
    * user's patronymic
    * @return patronymic
    **/

    @NotEmpty(message = "must not be empty")
    @Size(min = 1, max = 40, message = "size must be 1 ~ 40")
    @Pattern(regexp = "[A-Za-z]+", message = "must be only Latin alphabet")
    public String getPatronymic() {
        return patronymic;
    }

    /**
     * user's email
     * @return email
    **/

    @NotEmpty(message = "must not be empty")
    @Size(min = 1, max = 50, message = "size must be 1 ~ 50")
    @Pattern(
        regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$",
        message = "wrong format"
    )
    public String getEmail() {
      return email;
    }

    /**
     * User roles  - roles:   * `Administrator`   * `Sale User`    * `Customer User`   * `Secure API User`\"
     * @return role
     **/

    @NotNull(message = "wrong role")
    public Role getRole() {
        return role;
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder {
        private String name;
        private String surname;
        private String patronymic;
        private String email;
        private Role role;

        private Builder() {
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }


        public Builder setPatronymic(String patronymic) {
            this.patronymic = patronymic;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setRole(String role) {
            this.role = Role.getRole(role);
            return this;
        }

        public UserRequestDto build() {
            return new UserRequestDto(this.name, this.surname, this.patronymic, this.email, this.role);
        }
    }
}