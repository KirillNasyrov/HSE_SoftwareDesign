package goodman.homework_3.repository;

import goodman.homework_3.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
