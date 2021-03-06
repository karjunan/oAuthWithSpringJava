package com.appsdeveloper.ws.api.Resourceserver.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    Environment env;

    @GetMapping("/status/check")
    public String status() {

        return "Working on port => " + env.getProperty("local.server.port");
    }

    @PreAuthorize("hasRole('developer')")
//    @Secured("ROLE_developer")
    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable String id) {
        return "Delete the user with ID => " + id;
    }
}
