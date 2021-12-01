package com.example.demo.services.map;

import com.example.demo.model.Vet;
import com.example.demo.services.SpecialitiesService;
import com.example.demo.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialitiesService specialitiesService;

    public VetServiceMap(SpecialitiesService specialitiesService) {
        this.specialitiesService = specialitiesService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public void delete(Vet t) {
        super.delete(t);

    }

    @Override
    public Vet save(Vet vet) {
        if (vet != null) {
            if (vet.getSpeciality() != null && !vet.getSpeciality().isEmpty()) {
                vet.getSpeciality().stream().forEach(speciality -> {
                    if (speciality != null) {
                        if (speciality.getId() == 0) {
                            vet.getSpeciality().add(specialitiesService.save(speciality));
                        } else {
                            vet.getSpeciality().add(speciality);
                        }
                    }
                });
            }
            return super.save(vet);
        }
        return null;
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
