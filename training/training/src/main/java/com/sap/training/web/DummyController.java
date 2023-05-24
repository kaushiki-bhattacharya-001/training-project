package com.sap.training.web;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/dummy")
public class DummyController {
    @GetMapping("/")
    public String getHelloWorld() {
        return "Hello World";
    }

    @GetMapping("/{name}")
    public String getHelloWorldWithParam(@PathVariable String name) {
        return "Hello World, " + name;
    }

    @GetMapping("/paramApi")
    public String getHelloWorldWithParams(@RequestParam String param) {
        return "Hello World, Parameter Value: " + param;
    }

    @GetMapping("/{num}")
    public int getDivisionByTen(@PathVariable int num) {
        return (10 / num);
    }

    @GetMapping("/nullPrint")
    public String printNull() {
        String str = null;
        return String.valueOf(str.length());
    }
}
