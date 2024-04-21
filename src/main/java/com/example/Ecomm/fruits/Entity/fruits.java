package com.example.Ecomm.fruits.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="Fruits",schema = "ayushdb")
public class fruits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Fruitid;
    String fruitname;
    float caloriesper100g;
    float vitamincper100g;
    float fiberper100g;
    String taste;
    String description;
    String imageURL;
    String fruitFamily;
    String lastmodifieddate;
}
