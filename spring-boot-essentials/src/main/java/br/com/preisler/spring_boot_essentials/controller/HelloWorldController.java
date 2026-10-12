package br.com.preisler.spring_boot_essentials.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/hello")
public class HelloWorldController {
    /*
    @GetMapping
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping
    public ResponseEntity<String> Helloworld() {
        return ResponseEntity.ok("Hello World!");
    }

    @PostMapping
    public ResponseEntity<String> helloworld() {
        return new ResponseEntity<>("Hello World!", HttpStatus.CREATED);
    }
    */
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String get1(@PathVariable("id") String id) {
        return "Hello World GET!" + id;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String get2(@RequestParam(value = "name", required = true) String name) {
        return "Hello World GET!" + name;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String post(@RequestBody String name) {
        return "Hello World POST!" + name;
    }

}
