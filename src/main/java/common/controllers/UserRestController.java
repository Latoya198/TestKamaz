package common.controllers;

import common.controllers.exeption.PersonNotFoundException;
import common.model.User;
import common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON).body(userService.findAll());
    }

    @GetMapping(value = "/getByID/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        User user = userService.findOne(id);
        if(user == null) {
            throw  new PersonNotFoundException(id);
        }
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(user);
    }

    @PostMapping
    public ResponseEntity<User> createUser(User user) {
        return (ResponseEntity<User>) ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(userService.createNewUser(user));
    }

    @PutMapping
    public ResponseEntity<User> updateUser(User user) {
        Long id = user.getId();
        User oldUser = userService.findOne(id);
        if(oldUser == null) {
            throw new PersonNotFoundException(id);
        }
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(userService.update(user));
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        User user = userService.findOne(id);
        if(user == null) {
            throw new PersonNotFoundException(id);
        }
        userService.delete(user);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body("Юзер с id " + id + " Удален");
    }


}
