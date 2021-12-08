package com.ciclo4.reto1.repository;

import com.ciclo4.reto1.model.User;
import com.ciclo4.reto1.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired                                                                              //Implementa la interface y hace la instancia.
    private UserCrudRepository userCrudRepository;                                          //Llamar los metodos de la interface

    public List<User> getAll() {                                                            //Devolver todos los elementos como una coleccion y se convierte a un listado de usuarios
        return (List<User>) userCrudRepository.findAll();
    }

    public Optional<User> getUser(int id){                                                  //Buscar usuarios por id
        return userCrudRepository.findById(id);
    }

    public User save(User user){                                                            // Actualizar o insertar usuario
        return userCrudRepository.save(user);
    }

    public boolean existeEmail(String email){
        Optional<User> usuario = userCrudRepository.findByEmail(email);                     // Optional para el manejo de datos nulos

        return !usuario.isEmpty();                                                          // True si no existe / false si existe
    }

    public Optional<User> autenticarUsuario(String email, String password){                 // Autenticar usuarios
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

}
