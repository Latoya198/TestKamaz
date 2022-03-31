package common.service.impl;

import common.model.User;
import common.reposytory.UserReposytory;
import common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserReposytory reposytory;

    @Autowired
    public UserServiceImpl(UserReposytory reposytory) {
        this.reposytory = reposytory;
    }

    @Override
    public User createNewUser(User user) {
        return reposytory.save(user);
    }


    @Override
    public User findOne(Long id) throws IllegalArgumentException {
        return reposytory.findById(id).orElseThrow();
    }

    @Override
    public List<User> findAll() {
        return reposytory.findAll();
    }

    @Override
    public User update(User user) {
        return reposytory.save(user);
    }

    @Override
    public void delete(User user) {
        reposytory.delete(user);
    }

    @Override
    public void deleteById(long userId) {
        reposytory.deleteById(userId);
    }
}
