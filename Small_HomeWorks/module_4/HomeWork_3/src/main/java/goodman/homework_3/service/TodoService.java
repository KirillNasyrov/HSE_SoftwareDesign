package goodman.homework_3.service;

import goodman.homework_3.entity.TodoEntity;
import goodman.homework_3.entity.UserEntity;
import goodman.homework_3.model.Todo;
import goodman.homework_3.repository.TodoRepository;
import goodman.homework_3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepo;
    @Autowired
    private UserRepository userRepo;

    public Todo createTodo(TodoEntity todo, Long userId) {
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));
    }

    public Todo complete(Long id) {
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(todoRepo.save(todo));
    }
}