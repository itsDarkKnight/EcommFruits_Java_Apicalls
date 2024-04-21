package com.example.Ecomm.fruits.Controller;

import com.example.Ecomm.fruits.Entity.fruits;
import com.example.Ecomm.fruits.Service.FruitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fruits")
@CrossOrigin("*")
public class FruitsController {
    @Autowired
    private FruitsService fs;

    @PostMapping("/addfruits")
public ResponseEntity<String> CreateFruits(@RequestBody fruits fts)
{
    fs.CreateFruits(fts);
    return ResponseEntity.status(HttpStatus.OK).body(" : Data addded Successfully");
}
    @GetMapping("/allfruits")
    public List<fruits> getfruits(){return  fs.getallfruits();};

    @PutMapping("/editfruits/{id}")
    public ResponseEntity<String> Updatefruits(@RequestBody fruits fts, @PathVariable("id") int id)
    {
        try {
            fs.CreateFruits(fts);
            return  ResponseEntity.status(HttpStatus.OK).body("Data updated successfully.");
        }
        catch (Exception e)
        {return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error  in updating > "+e);}
    }

    @GetMapping("/fruitById/{id}")
    public fruits getById(@PathVariable("id") int id){
        return fs.getfruitById(id);
    };

    @GetMapping("/fruitByName/{name}")
    public fruits getByName(@PathVariable("name") String name){
        return fs.getfruitByname(name);
    };

    @DeleteMapping("/deletefruitById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id){
         try
         {
         fs.deletefruitbyId(id);
         return  ResponseEntity.status(HttpStatus.OK).body("Data deleted successfully.");
         }
         catch(Exception e)
         {
             return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error in deleting. "+e);
         }
    };

}
