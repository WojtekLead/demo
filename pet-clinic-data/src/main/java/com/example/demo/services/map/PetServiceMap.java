package com.example.demo.services.map;

import com.example.demo.model.Pet;
import com.example.demo.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public void delete(Pet t) {
        super.delete(t);

    }

    @Override
    public Pet save(Pet entity) {
        super.save(entity);
        return entity;
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
