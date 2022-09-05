package com.people.repository;

import com.people.entity.People;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface PeopleRepository extends ElasticsearchRepository<People, String> {
    List<People> findByFirstNameAndLastName(String firstName, String lastName);
}
