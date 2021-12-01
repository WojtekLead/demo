package com.example.demo.services;

import com.example.demo.model.Owner;

import java.util.Set;


/**
 * Created by jt on 7/18/18.
 */
public interface OwnerService extends CrudService<Owner, Long> {

    Set<Owner> findByLastName(String lastName);

}
