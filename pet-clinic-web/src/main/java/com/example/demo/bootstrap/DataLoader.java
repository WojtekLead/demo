package com.example.demo.bootstrap;

import com.example.demo.model.*;
import com.example.demo.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialitiesService specialitiesService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialitiesService specialitiesService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitiesService = specialitiesService;
        this.visitService = visitService;
    }


    @Override
    public void run(String... args) throws Exception {

        PetType petTypeDog = new PetType();
        petTypeDog.setName("Dog");

        petTypeService.save(petTypeDog);

        PetType petTypeCat = new PetType();
        petTypeDog.setName("Cat");

        petTypeService.save(petTypeCat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialitiesService.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("surgery");
        Speciality savedSurgery = specialitiesService.save(surgery);

        Speciality dentistry = new Speciality();
        radiology.setDescription("dentistry");
        Speciality savedDentistry = specialitiesService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("W");
        owner1.setLastName("M");
        owner1.setAddress("Address one");
        owner1.setCity("Ireland");
        owner1.setTelephone("0700880");

        Pet owner1Pet = new Pet();
        owner1Pet.setPetType(petTypeDog);
        owner1Pet.setName("doggy");
        owner1Pet.setBirthDate(LocalDate.of(2020, 11, 01));
        owner1.getPets().add(owner1Pet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("P");

        owner2.setLastName("R");
        owner2.setAddress("Address three");
        owner2.setCity("England");
        owner2.setTelephone("07020880");

        Pet owner2Pet = new Pet();
        owner2Pet.setPetType(petTypeDog);
        owner2Pet.setName("doggy");
        owner2Pet.setBirthDate(LocalDate.of(2020, 11, 01));
        owner2.getPets().add(owner2Pet);

        Visit visit = new Visit();
        visit.setDate(LocalDate.now());
        visit.setDescription("Visit for doggy");
        visit.setPet(owner1Pet);

        visitService.save(visit);

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName(" P");
        owner3.setLastName("R");
        owner3.setAddress("Address two");
        owner3.setCity("Poland");
        owner3.setTelephone("07001880");


        ownerService.save(owner3);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpeciality().add(savedDentistry);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpeciality().addAll(Set.of(savedRadiology, savedSurgery));

        vetService.save(vet2);


        System.out.println("Loaded Vets....");
    }
}
