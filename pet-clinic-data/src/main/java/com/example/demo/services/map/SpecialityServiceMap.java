package com.example.demo.services.map;

import com.example.demo.services.SpecialitiesService;
import com.example.demo.model.Speciality;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class SpecialityServiceMap extends AbstractMapService implements SpecialitiesService {

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {

        super.deleteById(id);
    }

    @Override
    public Speciality save(Speciality entity) {
        return (Speciality) super.save(entity);
    }

    @Override
    public void delete(Speciality speciality) {
        super.delete(speciality);
    }

    @Override
    public Speciality findById(Long id) {
        return (Speciality) super.findById(id);
    }
}
