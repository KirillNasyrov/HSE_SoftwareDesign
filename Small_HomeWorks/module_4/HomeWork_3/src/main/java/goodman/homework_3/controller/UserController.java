package goodman.homework_3.controller;

import goodman.homework_3.entity.UserEntity;
import goodman.homework_3.exception.UserAlreadyExistException;
import goodman.homework_3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> registration(@RequestBody UserEntity userEntity) {
        try {
            userService.registration(userEntity);
            return ResponseEntity.ok("User is saved");
        } catch (UserAlreadyExistException userAlreadyExistException) {
            return ResponseEntity.badRequest().body(userAlreadyExistException.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("Some Mistake");
        }
    }
    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userService.getOneUser(id));
        } catch (UserAlreadyExistException userAlreadyExistException) {
            return ResponseEntity.badRequest().body(userAlreadyExistException.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("Some Mistake");
        }

    }


}
