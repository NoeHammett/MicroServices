package com.devhammett.restweb.Controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.devhammett.restweb.Exceptions.UserNotFoundException;
import com.devhammett.restweb.Models.UserModel;
import com.devhammett.restweb.Service.UserDAOService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/api/users", produces = "application/json")
public class UsersController {

    @Autowired
    private UserDAOService userDAOService;

    @GetMapping(path = "/getAll")
    public List<UserModel> getAllUsers() {
        return userDAOService.getAllUsers();
    }

    @GetMapping(path = "/get/{id}")
    public EntityModel<UserModel> getUser(@PathVariable Integer id) {

        UserModel user = userDAOService.getUser(id);
        if (user == null) {
            throw new UserNotFoundException("User " + id + " not found");
        }
        //Return link inside the response 
        EntityModel<UserModel> resource = EntityModel.of(user);
        WebMvcLinkBuilder linktoUsers = linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
        resource.add(linktoUsers.withRel("All-Users"));
        return resource;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Object> addUser(@Valid @RequestBody UserModel user) {
        userDAOService.addUser(user);
        // Return HTTP Status Code
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId_user())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        UserModel user = userDAOService.deleteUser(id);
        if (user == null) {
            throw new UserNotFoundException("User " + id + " not found");
        }
        return "User " + id + " deleted";
    }
}
