package com.example.Ecomm.fruits.FruitsRepository;

import com.example.Ecomm.fruits.Entity.fruits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitsRepo  extends JpaRepository<fruits, Integer> {
    fruits findByfruitname(String taste);
}
