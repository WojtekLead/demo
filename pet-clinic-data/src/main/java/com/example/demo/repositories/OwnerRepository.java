package com.example.demo.repositories;

import com.example.demo.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    public Set<Owner> findByLastName(String lastName);

    public Set<Owner> findAll();
}

