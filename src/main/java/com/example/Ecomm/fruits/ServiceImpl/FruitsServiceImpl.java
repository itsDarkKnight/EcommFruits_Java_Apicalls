package com.example.Ecomm.fruits.ServiceImpl;

import com.example.Ecomm.fruits.Entity.fruits;
import com.example.Ecomm.fruits.FruitsRepository.FruitsRepo;
import com.example.Ecomm.fruits.Service.FruitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FruitsServiceImpl implements FruitsService {

    @Autowired
    private FruitsRepo fr;


    @Override
    public fruits CreateFruits(fruits fts) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime currentDateTime = LocalDateTime.now();
        String formattedDateTime = currentDateTime.format(formatter);
        fts.setLastmodifieddate(formattedDateTime);
        return fr.save(fts);
    }

    @Override
    public List<fruits> getallfruits() {
       List<fruits>data= (List<fruits>) fr.findAll().stream().sorted(Comparator.comparing(fruits::getLastmodifieddate,Comparator.reverseOrder())).collect(Collectors.toList());
       return data;

    }


    @Override
    public fruits getfruitById(int id) {
        return fr.findById(id).orElse(null);
    }

    @Override
    public fruits getfruitByname(String name) {
        return fr.findByfruitname(name);
    }

    @Override
    public fruits deletefruitbyId(int id) {
         fr.deleteById(id);
         return null;
    }


}
