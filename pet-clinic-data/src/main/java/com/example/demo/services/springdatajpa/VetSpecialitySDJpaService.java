package com.example.demo.services.springdatajpa;

import com.example.demo.model.Speciality;
import com.example.demo.services.SpecialitiesService;
import com.example.demo.repositories.SpecialityRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class VetSpecialitySDJpaService implements SpecialitiesService {

    private final SpecialityRepository specialityRepository;

    public VetSpecialitySDJpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Iterable<Speciality> findAll() {
        return specialityRepository.findAll();
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialityRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality entity) {
        return specialityRepository.save(entity);
    }

    @Override
    public void delete(Speciality speciality) {
        specialityRepository.delete(speciality);
    }

    @Override
    public void deleteById(Long aLong) {

    }
}
