package KajaNilsWebsite.controllers;

import KajaNilsWebsite.entities.Movie;
import KajaNilsWebsite.entities.Place;
import KajaNilsWebsite.entities.Todo;
import KajaNilsWebsite.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import responses.ResponseMessage;

import java.util.List;
@RequestMapping(name = "/backend-kn")
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
            String message = "Successfully added todo: " + title;
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
            String message = "Successfully edited todo: " + title;
            return ResponseEntity.ok().body(new ResponseMessage(message));
        } catch (Exception e) {
            return getResponse(e);
        }
    }

    @DeleteMapping("/todos/delete_todo")
    public ResponseEntity<ResponseMessage> deleteTodo(@RequestParam("id") Integer id) {
        try {
            service.deleteTodo(id);
            String message = "Successfully deleted todo";
            return ResponseEntity.ok().body(new ResponseMessage(message));
        } catch (Exception e) {
            return getResponse(e);
        }
    }

    @GetMapping("/movies")
    @ResponseBody
    public List<Movie> getAllMovies() {
        return service.getAllMovies();
    }

    @PostMapping("/movies/create")
    public ResponseEntity<ResponseMessage> addMovie(@RequestParam("title") String title, @RequestParam("watched") Boolean watched) {
        try {
            service.addMovie(title, watched);
            String message = "Successfully added movie: " + title;
            return ResponseEntity.ok().body(new ResponseMessage(message));
        } catch (Exception e) {
            return getResponse(e);
        }
    }

    @PutMapping("/movies/edit_movie")
    public ResponseEntity<ResponseMessage> editMovie(@RequestParam("title") String title,
                                                    @RequestParam("watched") Boolean watched,
                                                    @RequestParam("id") Integer id) {
        try {
            service.editMovie(id, title, watched);
            String message = "Successfully edited movie: " + title;
            return ResponseEntity.ok().body(new ResponseMessage(message));
        } catch (Exception e) {
            return getResponse(e);
        }
    }

    @DeleteMapping("/movies/delete_movie")
    public ResponseEntity<ResponseMessage> deleteMovie(@RequestParam("id") Integer id) {
        try {
            service.deleteMovie(id);
            String message = "Successfully deleted movie";
            return ResponseEntity.ok().body(new ResponseMessage(message));
        } catch (Exception e) {
            return getResponse(e);
        }
    }

    @GetMapping("/places")
    @ResponseBody
    public List<Place> getAllPlaces() {
        return service.getAllPlaces();
    }

    @PostMapping("/places/create")
    public ResponseEntity<ResponseMessage> addPlace(@RequestParam("name") String name, @RequestParam("visited") Boolean visited) {
        try {
            service.addPlace(name, visited);
            String message = "Successfully added place: " + name;
            return ResponseEntity.ok().body(new ResponseMessage(message));
        } catch (Exception e) {
            return getResponse(e);
        }
    }

    @PutMapping("/places/edit_place")
    public ResponseEntity<ResponseMessage> editPlace(@RequestParam("name") String name,
                                                     @RequestParam("visited") Boolean visited,
                                                     @RequestParam("id") Integer id) {
        try {
            service.editPlace(id, name, visited);
            String message = "Successfully edited place: " + name;
            return ResponseEntity.ok().body(new ResponseMessage(message));
        } catch (Exception e) {
            return getResponse(e);
        }
    }

    @DeleteMapping("/places/delete_place")
    public ResponseEntity<ResponseMessage> deletePlace(@RequestParam("id") Integer id) {
        try {
            service.deletePlace(id);
            String message = "Successfully deleted place";
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
