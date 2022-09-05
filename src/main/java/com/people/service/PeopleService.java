package com.people.service;

import com.people.entity.People;

import java.util.List;

public interface PeopleService {


    People save(People people);

    People getById(String id);

    List<People> findByName(String name, String lastName);

    People update(People people);

    String delete(String id);

    List<People> getAll();
}
