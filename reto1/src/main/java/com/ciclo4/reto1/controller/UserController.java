package com.ciclo4.reto1.controller;

import com.ciclo4.reto1.model.User;
import com.ciclo4.reto1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Miguel
 */

@RestController                                                         //Servicio web para las peticiones HTTP
@RequestMapping("/api/user")                                                //Definir nombre o contexto, endpoint
@CrossOrigin("*")                                                       //Eliminar restricciones entre servicios
/**
 * Clase web controller userController
 */
public class UserController {                                           //Este controlador se relaciona con los servicios
    /**
     * Instancia de UserService con la anotacion @Autowired
     */
    @Autowired
    private UserService userService;
    /**
     * Metodo para obtener todos los usuarios
     * @return userService.getAll()
     */
    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }
    /**
     * Metodo para crear un nuevo usuario
     * @param user
     * @return userService.registrar(user)
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User registrar(@RequestBody User user){                       //Cuerpo para el nuevo usuario
        return userService.registrar(user);
    }
    /**
     * Metodo para confirmar si existe la cambinacion email / password en un usuario ya registrado
     * @param email
     * @param password
     * @return userService.autenticarUsuario(email, password)
     */
    @GetMapping("/{email}/{password}")                                   //El email y password vienen desde la url
    public User autenticarUsuario(@PathVariable("email")String email, @PathVariable("password")String password){
        return userService.autenticarUsuario(email, password);
    }

    /**
     * Metodo para confirmar si existe un email en un usuario
     * @param email
     * @return userService.exiseEmail(email)
     */
    @GetMapping("/{email}")
    public boolean existeEmail(@PathVariable("email") String email) {
        return userService.existeEmail(email);
    }
}//Fin de la clase
