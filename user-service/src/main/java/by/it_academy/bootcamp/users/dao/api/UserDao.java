package by.it_academy.bootcamp.users.dao.api;

import by.it_academy.bootcamp.users.dao.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

    Page<User> findByOrderByEmailAsc(Pageable pageable);

    boolean existsByEmail(String email);

}
