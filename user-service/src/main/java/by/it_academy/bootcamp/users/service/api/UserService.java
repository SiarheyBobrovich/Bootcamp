package by.it_academy.bootcamp.users.service.api;

import by.it_academy.bootcamp.users.dao.entity.User;
import by.it_academy.bootcamp.users.dto.request.UserRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;

public interface UserService {
    Page<User> getPageOfUsers(Pageable pageable);
    Long save(@Valid UserRequestDto user);
}
