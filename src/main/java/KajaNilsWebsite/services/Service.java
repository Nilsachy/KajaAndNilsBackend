package KajaNilsWebsite.services;

import KajaNilsWebsite.entities.Movie;
import KajaNilsWebsite.entities.Place;
import KajaNilsWebsite.entities.Restaurant;
import KajaNilsWebsite.entities.Todo;
import KajaNilsWebsite.repositories.MovieRepository;
import KajaNilsWebsite.repositories.PlaceRepository;
import KajaNilsWebsite.repositories.RestaurantRepository;
import KajaNilsWebsite.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    private final TodoRepository todoRepository;
    private final MovieRepository movieRepository;
    private final PlaceRepository placeRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public Service(TodoRepository todoRepository, MovieRepository movieRepository, PlaceRepository placeRepository, RestaurantRepository restaurantRepository) {
        this.todoRepository = todoRepository;
        this.movieRepository = movieRepository;
        this.placeRepository = placeRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public Todo getTodo(Integer id) {
        return todoRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format("invalid todo id: %s", id)));
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

    public Todo deleteTodo(Integer id) {
        Todo todo = getTodo(id);
        todoRepository.delete(todo);
        return todo;
    }

    public Movie getMovie(Integer id) {
        return movieRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format("invalid movie id: %s", id)));
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie addMovie(String title, Boolean watched) {
        Movie movie = new Movie(title, watched);
        return movieRepository.save(movie);
    }

    public Movie editMovie(Integer id, String title, Boolean watched) {
        Movie movie = getMovie(id);
        movie.setTitle(title);
        movie.setWatched(watched);
        return movieRepository.save(movie);
    }

    public Movie deleteMovie(Integer id) {
        Movie movie = getMovie(id);
        movieRepository.delete(movie);
        return movie;
    }

    public Place getPlace(Integer id) {
        return placeRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format("invalid movie id: %s", id)));
    }

    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }

    public Place addPlace(String name, Boolean visited) {
        Place place = new Place(name, visited);
        return placeRepository.save(place);
    }

    public Place editPlace(Integer id, String name, Boolean visited) {
        Place place = getPlace(id);
        place.setName(name);
        place.setVisited(visited);
        return placeRepository.save(place);
    }

    public Place deletePlace(Integer id) {
        Place place = getPlace(id);
        placeRepository.delete(place);
        return place;
    }

    public Restaurant getRestaurant(Integer id) {
        return restaurantRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format("invalid restaurant id: %s", id)));
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant addRestaurant(String name, Boolean visited) {
        Restaurant restaurant = new Restaurant(name, visited);
        return restaurantRepository.save(restaurant);
    }

    public Restaurant editRestaurant(Integer id, String name, Boolean visited) {
        Restaurant restaurant = getRestaurant(id);
        restaurant.setName(name);
        restaurant.setVisited(visited);
        return restaurantRepository.save(restaurant);
    }

    public Restaurant deleteRestaurant(Integer id) {
        Restaurant restaurant = getRestaurant(id);
        restaurantRepository.delete(restaurant);
        return restaurant;
    }
}
