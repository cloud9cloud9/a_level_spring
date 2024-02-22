package org.hw28.controller;

import org.hw28.constant.ApiConstant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetController {

    @GetMapping(ApiConstant.START_PAGE)
    public ResponseEntity<String> getData() {
        return ResponseEntity.status(HttpStatus.OK).body("hello");
    }
}
