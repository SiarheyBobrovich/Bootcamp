package by.it_academy.bootcamp.users.dao.entity;

import by.it_academy.bootcamp.users.enums.Role;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(schema = "bootcamp", name = "users")
public class User {

    private long id;
    private String name;
    private String surname;
    private String patronymic;
    private String email;
    private Role role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", length = 40, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "surname", length = 20, nullable = false)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "patronymic", length = 40)
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Column(name = "email", unique = true, length = 50, nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "role", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(patronymic, user.patronymic) && Objects.equals(email, user.email) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, patronymic, email, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}
