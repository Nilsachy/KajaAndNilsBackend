package KajaNilsWebsite.controllers;

import KajaNilsWebsite.entities.Todo;
import KajaNilsWebsite.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import responses.ResponseMessage;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    private final Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/todos")
    @ResponseBody
    public List<Todo> getAllTodos() {
        return service.getAllTodos();
    }

    @PostMapping("/todos/create")
    public ResponseEntity<ResponseMessage> addTodo(@RequestParam("title") String title, @RequestParam("done") Boolean done) {
        try {
            service.addTodo(title, done);
            String message = "Successfully added event type: " + title;
            return ResponseEntity.ok().body(new ResponseMessage(message));
        } catch (Exception e) {
            return getResponse(e);
        }
    }

    @PutMapping("/todos/edit_todo")
    public ResponseEntity<ResponseMessage> editTodo(@RequestParam("title") String title,
                                                         @RequestParam("done") Boolean done,
                                                         @RequestParam("id") Integer id) {
        try {
            service.editTodo(id, title, done);
            String message = "Successfully edited event type: " + title;
            return ResponseEntity.ok().body(new ResponseMessage(message));
        } catch (Exception e) {
            return getResponse(e);
        }
    }

    private ResponseEntity<ResponseMessage> getResponse(Exception e) {
        String message = "The following error was thrown: " + e.getMessage();
        return ResponseEntity.badRequest().body(new ResponseMessage(message));
    }

}
