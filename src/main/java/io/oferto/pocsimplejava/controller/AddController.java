package io.oferto.pocsimplejava.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.oferto.pocsimplejava.domain.Result;

@RestController
public class AddController {
	@GetMapping("/add")
	public Result add(@RequestParam(value = "a") int a, @RequestParam(value = "b") int b) {
        int sum = a + b;
        
        return new Result(sum);
    }
}
