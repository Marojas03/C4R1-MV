package com.ciclo4.reto1.repository.crud;

import com.ciclo4.reto1.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserCrudRepository extends CrudRepository<User, Integer> {

    Optional<User> findByEmail(String email);                                           //Optional es para evitar errores con consultas nulas.
    Optional<User> findByEmailAndPassword(String email, String password);               //Se utiliza Query, con camel case
    //Optional<User> findByName(String name);
}
