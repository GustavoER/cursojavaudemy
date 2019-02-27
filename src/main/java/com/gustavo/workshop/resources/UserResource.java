package com.gustavo.workshop.resources;

import com.gustavo.workshop.domain.User;
import com.gustavo.workshop.dto.UserDto;
import com.gustavo.workshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll(){
        var list = userService.findAll();
        var listDto = list.stream()
                .map(UserDto::new)
                .collect(Collectors.toList());
        return new ResponseEntity<>(listDto, HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        var obj = userService.findById(id);
        return ResponseEntity.ok().body(new UserDto(obj));
    }
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody UserDto objDto){
        var obj = userService.insert(userService.fromDTO(objDto));
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody User user){
        return ResponseEntity.ok(this.userService.update(id, user));
    }
}
