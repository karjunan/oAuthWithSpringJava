package com.appsdeveloper.ws.api.Resourceserver.contoller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/status/check")
    public String status() {

        return "Working";
    }

    @PreAuthorize("hasRole('developer')")
//    @Secured("ROLE_developer")
    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable String id) {
        return "Delete the user with ID => " + id;
    }
}
