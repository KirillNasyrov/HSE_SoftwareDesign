package goodman.homework_3.service;

import goodman.homework_3.entity.UserEntity;
import goodman.homework_3.exception.UserAlreadyExistException;
import goodman.homework_3.exception.UserNotFoundException;
import goodman.homework_3.model.User;
import goodman.homework_3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public UserEntity registration(UserEntity user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("User with such name already exist");
        }
        return userRepository.save(user);
    }

    public User getOneUser(Long id) {
        var userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }
        return User.toModel(userOptional.get());
    }

    public Long delete(Long id) {
        userRepository.deleteById(id);
        return id;
    }
}
