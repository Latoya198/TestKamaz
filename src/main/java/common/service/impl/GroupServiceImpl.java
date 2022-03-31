package common.service.impl;

import common.model.Group;
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
    public void createNewGroup(Group group) {
        reposytory.save(group);
    }

    @Override
    public void delete(Group group) {
        reposytory.delete(group);
    }

    @Override
    public void addUserGroup(Group group) {
        reposytory.save(group);
    }

    @Override
    public List<Group> findAll() {
        return reposytory.findAll();
    }
}
