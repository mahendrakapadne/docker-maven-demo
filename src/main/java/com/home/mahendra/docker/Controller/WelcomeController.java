package com.home.mahendra.docker.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Narendra on 3/4/2017.
 */
@RestController
@RequestMapping("/home")
public class WelcomeController {
    private final Logger log = LoggerFactory.getLogger(WelcomeController.class);

    @GetMapping("/welcome")
    public String createEmployee(@RequestParam("name") String name) throws URISyntaxException {
        log.debug("REST request welcomes : {}", name);
        return "Welcome " + name;
    }
}
