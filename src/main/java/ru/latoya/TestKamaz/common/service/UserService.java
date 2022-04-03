package ru.latoya.TestKamaz.common.service;

import ru.latoya.TestKamaz.common.model.User;

import java.util.List;

public interface UserService {
    User createNewUser(User user);

    User findOne(Long id);

    List<User> findAll();

    User update(User user);

    void delete(User user);

    void deleteById(long userId);
}
