package KajaNilsWebsite.controllers;

import KajaNilsWebsite.services.Service;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
public class Controller {

    private final Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }
}
