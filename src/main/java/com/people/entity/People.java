package com.people.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDateTime;

@Document(indexName="my-people")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class People {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String category;
    private String subject;
    private LocalDateTime createDate;
    private String createdBy;
}
