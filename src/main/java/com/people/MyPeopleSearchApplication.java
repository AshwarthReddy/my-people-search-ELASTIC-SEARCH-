package com.people;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.people.repository")
public class MyPeopleSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyPeopleSearchApplication.class, args);
	}

}
