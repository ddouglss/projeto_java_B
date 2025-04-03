package com.initial.bookstoremanager.entity;

import jakarta.persistence.*;
import lombok.*;

//MAPEANDO CONFORME O MODELO DE DADOS E COM AS ANNOTATIONS
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Integer age;
}
