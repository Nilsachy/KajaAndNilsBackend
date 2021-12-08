package KajaNilsWebsite.services;

import KajaNilsWebsite.entities.Todo;
import KajaNilsWebsite.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    private final TodoRepository todoRepository;

    @Autowired
    public Service(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo getTodo(Integer id) {
        return todoRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format("invalid event type id: %s", id)));
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo addTodo(String title, Boolean done) {
        Todo todo = new Todo(title, done);
        return todoRepository.save(todo);
    }

    public Todo editTodo(Integer id, String title, Boolean done) {
        Todo todo = getTodo(id);
        todo.setTitle(title);
        todo.setDone(done);
        return todoRepository.save(todo);
    }
}
