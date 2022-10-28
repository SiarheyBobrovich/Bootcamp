package by.it_academy.bootcamp.users.controller;

import by.it_academy.bootcamp.users.controller.api.UserController;
import by.it_academy.bootcamp.users.dao.entity.User;
import by.it_academy.bootcamp.users.dto.request.UserRequestDto;
import by.it_academy.bootcamp.users.dto.response.ResponsePage;
import by.it_academy.bootcamp.users.dto.response.UserResponseDto;
import by.it_academy.bootcamp.users.service.api.UserService;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerImpl implements UserController {

    private final UserService userService;
    private final ConversionService conversionService;

    public UserControllerImpl(UserService userService, ConversionService conversionService) {
        this.userService = userService;
        this.conversionService = conversionService;
    }

    @Override
    public ResponseEntity<ResponsePage<UserResponseDto>> apiV1UserGet(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);

        Page<User> pageOfUsers = userService.getPageOfUsers(pageRequest);
        Page<UserResponseDto> map = pageOfUsers.map(
                user -> conversionService.convert(user, UserResponseDto.class)
        );

        ResponsePage<UserResponseDto> dtoResponsePage = ResponsePage.of(map);

        return ResponseEntity.ok().body(dtoResponsePage);
    }

    @Override
    public ResponseEntity<Long> apiV1UserPost(UserRequestDto body) {
        Long save = userService.save(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }
}
