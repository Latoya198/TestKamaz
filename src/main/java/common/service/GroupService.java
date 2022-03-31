package common.service;

import common.model.Group;
import common.model.User;

import java.util.List;

public interface GroupService{
    void createNewGroup(Group group);
    void delete(Group group);
    void addUserGroup(Group group);
    List<Group> findAll();

}
