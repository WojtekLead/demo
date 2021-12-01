package com.example.demo.services.map;

import com.example.demo.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetServiceMap(), new PetTypeServiceMap());
        ownerServiceMap.save(Owner.builder().id(1L).city("Dallas").lastName("Paprok").build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();
        assertEquals(ownerSet.size(), 1);

    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(1L);
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
    }

    @Test
    void findById() {
        Owner ownerSet = ownerServiceMap.findById(1L);
        assertEquals(ownerSet.getId(), 1);
    }

    @Test
    void save() {
        Owner owner = Owner.builder().id(3L).city("Lodz").build();
        ownerServiceMap.save(owner);
        Owner owner1 = ownerServiceMap.findById(3L);
        assertEquals(owner1.getId(), 3L);
    }

    @Test
    void saveNoId(){
        Owner savedOwner = ownerServiceMap.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findByLastName() {
        Set<Owner> owener = ownerServiceMap.findByLastName("Paprok");
        assertEquals(owener.size(), 1);
    }
    @Test
    void findByLastNameNotFound() {
        Set<Owner> owener = ownerServiceMap.findByLastName("foo");
        assertEquals(owener.size(), 0);
    }
}