package common.service.impl;

import common.model.Group;
import common.model.User;
import common.reposytory.GroupReposytory;
import common.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupReposytory reposytory;

    @Autowired
    public GroupServiceImpl(GroupReposytory reposytory) {
        this.reposytory = reposytory;
    }

    @Override
    public Group createNewGroup(Group group) {
        return reposytory.save(group);
    }

    @Override
    public void delete(Group group) {
        reposytory.delete(group);
    }

    @Override
    public Group addUserGroup(Group group) {
        return reposytory.save(group);
    }

    @Override
    public List<Group> findAll() {
        return reposytory.findAll();
    }

    @Override
    public Group findOne(Long id) throws IllegalArgumentException {
        return reposytory.findById(id).orElseThrow();
    }
}
