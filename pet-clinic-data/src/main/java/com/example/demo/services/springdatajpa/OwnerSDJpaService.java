package com.example.demo.services.springdatajpa;

import com.example.demo.model.Owner;
import com.example.demo.repositories.OwnerRepository;
import com.example.demo.repositories.PetRepository;
import com.example.demo.repositories.PetTypeRepository;
import com.example.demo.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<Owner> findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        return ownerRepository.findAll();
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner owner) {
        if (owner != null) {

            ownerRepository.save(owner);
            if (owner.getPets() != null && !owner.getPets().isEmpty()) {
                owner.getPets().stream()
                        .forEach(pet -> {
                            if (pet.getPetType() != null) {
                                if (pet.getId() == null) {
                                    pet.setPetType(petTypeRepository.save(pet.getPetType()));
                                }
                            } else {
                                throw new RuntimeException("Pet Type is required");
                            }
                            petRepository.save(pet);
                        });
            }
        }
        return owner;
    }

    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);

    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }
}
