package com.example.demo.services.map;

import com.example.demo.model.Owner;
import com.example.demo.services.OwnerService;
import com.example.demo.services.PetService;
import com.example.demo.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Profile({"default","map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {

        super.deleteById(id);

    }

    @Override
    public void delete(Owner t) {
        super.delete(t);

    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        if (owner != null) {

            super.save(owner);
            if (owner.getPets() != null && !owner.getPets().isEmpty()) {
                owner.getPets().stream()
                        .forEach(pet -> {
                            if (pet.getPetType() != null) {
                                if (pet.getId() == null) {
                                    pet.setPetType(petTypeService.save(pet.getPetType()));
                                }
                            } else {
                                throw new RuntimeException("Pet Type is required");
                            }
                            petService.save(pet);
                        });
            }
        }
        return owner;
    }

    @Override
    public Set<Owner> findByLastName(String lastName) {
        Set<Owner> owners = this.findAll().stream()
                .filter(a -> a.getLastName().equals(lastName))
                .collect(Collectors.toSet());
        return owners;
    }
}
