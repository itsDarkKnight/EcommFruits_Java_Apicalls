package com.example.Ecomm.fruits.Service;

import com.example.Ecomm.fruits.Entity.fruits;

import java.util.List;

public interface FruitsService {

    public fruits CreateFruits(fruits fruits);
    public List<fruits> getallfruits();
    public fruits getfruitById(int id);
    public fruits getfruitByname(String name);
    public fruits deletefruitbyId(int id);
}
