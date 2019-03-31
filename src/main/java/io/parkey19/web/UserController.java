package io.parkey19.web;

import java.util.List;

import io.parkey19.model.Users;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by parkey19 on 2018. 11. 19..
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/{id}")
    public ResponseEntity<?> getUsers(@PathVariable int id) {
        List<Users> list = new ArrayList<Users>();
        list.add(new Users("park" , "01099998888"));
        list.add(new Users("kim" , "01011112222"));
        return new ResponseEntity<>(list.get(id), HttpStatus.OK);
    }
}
