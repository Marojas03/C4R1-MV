package com.ciclo4.reto1.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "user", indexes = @Index(name = "indx_email", columnList = "user_email", unique = true))      //Correo irrepetible
public class User implements Serializable {                                                                 //Serializable permite mandar datos a traves de la red

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)                                                     //JPA hace que se esta columna se marque autoincrementable
    private Integer id;

    @NonNull
    @Column(name = "user_email", nullable = false, length = 50)
    private String email;

    @NonNull
    @Column(name = "user_password", nullable = false, length = 50)
    private String password;

    @NonNull
    @Column(name = "user_name", nullable = false, length = 80)
    private String name;
}
