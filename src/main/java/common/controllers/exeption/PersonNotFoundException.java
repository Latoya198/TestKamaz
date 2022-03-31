package common.controllers.exeption;

public class PersonNotFoundException extends RuntimeException{
    public PersonNotFoundException(Long id) {
        super("ERROR: Пользователь с id " + id + "не найден");
    }
}
