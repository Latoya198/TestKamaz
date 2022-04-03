package common.service;

import common.model.Group;
import common.model.User;

import java.util.List;

public interface GroupService{
    Group createNewGroup(Group group);
    void delete(Group group);
    Group addUserGroup(Group group);
    List<Group> findAll();
    Group findOne(Long id);

}
