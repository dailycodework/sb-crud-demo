package com.fixdecode.sbcruddemo.pet;

import java.util.List;
import java.util.Optional;

public interface PetService {
    Pet add(Pet pet);
    List<Pet> getPets();
    Pet update(Pet pet);
    void delete(Integer id);
    Optional<Pet> getById(Integer id) throws Exception;
}
