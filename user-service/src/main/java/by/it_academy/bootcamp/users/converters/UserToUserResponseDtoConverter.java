package by.it_academy.bootcamp.users.converters;

import by.it_academy.bootcamp.users.dao.entity.User;
import by.it_academy.bootcamp.users.dto.response.UserResponseDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserResponseDtoConverter implements Converter<User, UserResponseDto> {

    @Override
    public UserResponseDto convert(User source) {
        return new UserResponseDto(getFullName(source), source.getEmail(), source.getRole().getName());
    }

    private String getFullName(User user) {
        return user.getSurname() + " " + user.getName() + " " + user.getPatronymic();
    }
}
