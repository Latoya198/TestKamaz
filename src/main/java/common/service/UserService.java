package common.service;

import common.model.User;

import java.util.List;

public interface UserService {
    User createNewUser(User user);

    User findOne(Long id);

    List<User> findAll();

    User update(User user);

    void delete(User user);

    void deleteById(long userId);
}
