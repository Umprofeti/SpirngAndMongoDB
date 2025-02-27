package com.skiatel.spingmongodb.Controllers;

import com.skiatel.spingmongodb.DAO.User;
import com.skiatel.spingmongodb.Repository.UsersRepository;
import com.skiatel.spingmongodb.request.UserRequest;
import org.springframework.data.annotation.Id;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UsersRepository usersRepository;

    public UserController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping("/hola")
    public ResponseEntity<String> hola(){
        return ResponseEntity.ok("Hola");
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody @Validated UserRequest userRequest){
        User usuario = new User(userRequest.getName(), userRequest.getEmail(), userRequest.getPassword());
        try{
            usersRepository.insert(usuario);
            return ResponseEntity.ok("Usuario Creado");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error al crear el usuario " + e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getUsers(){
        if(usersRepository.findAll().isEmpty()){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(usersRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id){
        if(usersRepository.findById(id).isEmpty()){
            return ResponseEntity.badRequest().body(null);
        }

        return ResponseEntity.ok(usersRepository.findById(id).orElse(null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable String id, @RequestBody UserRequest userRequest){
        User user = usersRepository.findById(id).orElse(null);
        if(user == null){
            return ResponseEntity.badRequest().body("Usuario no encontrado");
        }
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        usersRepository.save(user);
        return ResponseEntity.ok("Usuario Actualizado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id){
        User user = usersRepository.findById(id).orElse(null);
        if(user == null){
            return ResponseEntity.badRequest().body("User not found");
        }
        usersRepository.delete(user);
        return ResponseEntity.ok("Usuario eliminado");
    }
}
