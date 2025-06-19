package com.microservice.clients.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clients")
public class ClientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 11, unique = true)
    private String cpf;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false)
    private int age;


}
