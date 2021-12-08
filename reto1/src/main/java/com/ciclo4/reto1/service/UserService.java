package com.ciclo4.reto1.service;

import com.ciclo4.reto1.model.User;
import com.ciclo4.reto1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service                                                                            //Se relaciona con los metodos crud, en esta capa de servicios se hacen la mayoria de los servicios
public class UserService {

    @Autowired                                                                      //Autowired sirve para no hacer la instancia de UserRepository.
    private UserRepository userRepository;

    public List<User> getAll() {                                                    //Obtener todos los usuarios
        return userRepository.getAll();
    }

    public Optional<User> getUser(int id) {                                         //Obtener usuario por ID
        return userRepository.getUser(id);
    }

    public User registrar(User user) {                                              //Sirve para crear usuario, lo averigua mediante el ID, es decir si no tiene ID es un usuario nuevo
        if (user.getId() == null) {
            if (existeEmail(user.getEmail()) == false) {
                return userRepository.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean existeEmail(String email) {                                       //Verificar si el email esta repetido
        return userRepository.existeEmail(email);
    }

    public User autenticarUsuario(String email, String password) {
        Optional<User> usuario = userRepository.autenticarUsuario(email, password);  // Metodo para verificar si existe un usuario con email y password

        if (usuario.isEmpty()) {                                                     // Si el usuario no existe, devuelve el email, password ingresado con la palabra NO DEFINIDO, objeto nuevo
            return new User(email, password, "NO DEFINIDO");
        } else {                                                                     // Si no trae el usuario SI existe
            return usuario.get();
        }
    }
}


