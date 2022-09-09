package com.fixdecode.sbcruddemo.pet;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
@RequestMapping("/pets")
public class PetController {
    private PetService petService;

    @GetMapping("/all")
    public ResponseEntity<List<Pet>> getPets(){
        return  new ResponseEntity<>(petService.getPets(), OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Pet> add(@RequestBody Pet pet){
        return new ResponseEntity<>(petService.add(pet), CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Pet> update(@RequestBody Pet pet){
        return new ResponseEntity<>(petService.update(pet), CREATED);
    }

    @DeleteMapping("/pet/{id}")
    public void delete(@PathVariable("id") Integer id){
        petService.delete(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPet(@PathVariable("id") Integer id) throws Exception {
        return petService.getById(id).map(ResponseEntity :: ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

}
