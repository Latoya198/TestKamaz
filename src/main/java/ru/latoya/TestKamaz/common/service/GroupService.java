package ru.latoya.TestKamaz.common.service;

import ru.latoya.TestKamaz.common.model.Group;

import java.util.List;

public interface GroupService{
    Group createNewGroup(Group group);
    void delete(Group group);
    Group addUserGroup(Group group);
    List<Group> findAll();
    Group findOne(Long id);

}
