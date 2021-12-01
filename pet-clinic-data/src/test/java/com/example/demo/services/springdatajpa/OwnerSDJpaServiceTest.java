package com.example.demo.services.springdatajpa;

import com.example.demo.model.BaseEntity;
import com.example.demo.model.Owner;
import com.example.demo.model.Pet;
import com.example.demo.repositories.OwnerRepository;
import com.example.demo.repositories.PetRepository;
import com.example.demo.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByLastName() {

        Owner returnedOwener = Owner.builder().id(1L).lastName("Smith").build();
        when(ownerRepository.findByLastName("Smith")).thenReturn(Set.of(returnedOwener));
        Set<Owner> owners = service.findByLastName("Smith");
        assertEquals(owners.size(), 1);
    }

    @Test
    void findAll() {
        Owner returnedOwener = Owner.builder().id(1L).lastName("Smith").build();
        when(ownerRepository.findAll()).thenReturn(Set.of(returnedOwener));
        Set<Owner> owners = service.findAll();
        assertEquals(owners.size(), 1);
    }

    @Test
    void findById() {
        Owner returnedOwener = Owner.builder().id(1L).lastName("Smith").build();
        when(ownerRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(returnedOwener));
        Owner owners = service.findById(1L);
        assertEquals(owners.getId(), 1L);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(2L)).thenReturn(Optional.ofNullable(null));
        Owner owners = service.findById(2L);
        assertNull(owners);
    }

    @Test
    void save() {
        Owner returnedOwener = Owner.builder().id(1L).lastName("Smith").build();
        when(ownerRepository.save(returnedOwener)).thenReturn(returnedOwener);
        Owner owner = ownerRepository.save(returnedOwener);
        assertEquals(owner.getId(), 1L);
    }

    @Test
    void delete() {
        Owner returnedOwener = Owner.builder().id(1L).lastName("Smith").build();
        service.delete(returnedOwener);
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        Owner returnedOwener = Owner.builder().id(1L).lastName("Smith").build();
        service.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());

    }
}