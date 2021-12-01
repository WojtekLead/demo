package com.example.demo.services.map;

import com.example.demo.model.PetType;
import com.example.demo.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public void delete(PetType t) {
        super.delete(t);

    }

    @Override
    public PetType save(PetType entity) {
        super.save(entity);

        return entity;
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}
