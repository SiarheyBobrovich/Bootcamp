package by.it_academy.bootcamp.users.service;

import by.it_academy.bootcamp.users.dao.api.UserDao;
import by.it_academy.bootcamp.users.dao.entity.User;
import by.it_academy.bootcamp.users.dto.request.UserRequestDto;
import by.it_academy.bootcamp.users.service.api.UserService;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

@Service
@Validated
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final ConversionService conversionService;

    public UserServiceImpl(UserDao userDao, ConversionService conversionService) {
        this.userDao = userDao;
        this.conversionService = conversionService;
    }

    @Override
    public Page<User> getPageOfUsers(Pageable pageable) {
        if (Objects.isNull(pageable)) {
            throw new IllegalArgumentException();
        }

        return userDao.findByOrderByEmailAsc(pageable);
    }

    @Override
    @Transactional
    public Long save(UserRequestDto user) {
        if (Objects.isNull(user) || userDao.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("User already exists");
        }

        User convert = conversionService.convert(user, User.class);

        assert convert != null;
        User save = userDao.save(convert);

        return save.getId();
    }
}