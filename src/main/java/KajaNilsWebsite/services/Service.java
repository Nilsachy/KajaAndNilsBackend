package KajaNilsWebsite.services;

import KajaNilsWebsite.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {

    private final TodoRepository todoRepository;

    @Autowired
    public Service(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
}
