package com.people.service.impl;

import com.people.entity.People;
import com.people.repository.PeopleRepository;
import com.people.service.PeopleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PeopleServiceImpl implements PeopleService {

    private final PeopleRepository peopleRepository;

    @Override
    public People save(People people) {
        People save = peopleRepository.save(people);
        return save;
    }

    @Override
    public People getById(String id) {
        var people = peopleRepository.findById(id);
        return people.get();
    }

    @Override
    public List<People> findByName(String firstName, String lastName) {
        return peopleRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public People update(People people) {
        var data = peopleRepository.findById(people.getId()).orElseThrow();
        BeanUtils.copyProperties(people, data);
        return peopleRepository.save(data);
    }

    @Override
    public String delete(String id) {
       var data = peopleRepository.findById(id).get();
         peopleRepository.delete(data);
        return String.format("Successfully %d deleted", id);
    }

    @Override
    public List<People> getAll() {
        List<People> peoples = new ArrayList<>();
        Iterable<People> all = peopleRepository.findAll();
        for (People people : all) {
            peoples.add(people);
        }
        return peoples;
    }
}
