package ru.latoya.TestKamaz.common.controllers;

import ru.latoya.TestKamaz.common.controllers.exeption.PersonNotFoundException;
import ru.latoya.TestKamaz.common.model.Group;
import ru.latoya.TestKamaz.common.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/work/")
public class GroupRestController {

    private final GroupService groupService;

    @Autowired
    public GroupRestController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/getAllGroup")
    public ResponseEntity<List<Group>> getAllGroup() {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(groupService.findAll());
    }

    @PutMapping("/addUser")
    public ResponseEntity<Group> addUser(@RequestBody Group group) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(groupService.addUserGroup(group));
    }

    @PostMapping("/addGroup")
    public ResponseEntity<Group> addGroup(@RequestBody Group group) {
        group.setGroupCreationDate(LocalDate.now());
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(groupService.createNewGroup(group));
    }

    @DeleteMapping("/deleteGroup/{id}")
    public ResponseEntity<String> deleteGroup(@PathVariable Long id) {
        Group group = groupService.findOne(id);
        if(group == null) {
            throw new PersonNotFoundException(id);
        }
        groupService.delete(group);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body("???????????? ?? id: " + id + "??????????????");
    }

}
