package by.it_academy.bootcamp.users.converters;

import by.it_academy.bootcamp.users.dao.entity.User;
import by.it_academy.bootcamp.users.dto.request.UserRequestDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserRequestDtoToUserConverter implements Converter<UserRequestDto, User> {

    @Override
    public User convert(UserRequestDto source) {
        User user = new User();
        user.setSurname(source.getSurname());
        user.setName(source.getName());
        user.setPatronymic(source.getPatronymic());
        user.setEmail(source.getEmail());
        user.setRole(source.getRole());
        return user;
    }
}
