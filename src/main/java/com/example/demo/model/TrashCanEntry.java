package com.example.demo.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
@Builder
public class TrashCanEntry {

    @Id
    private String id;

    private Date date;

    private double kg;

    private double price;
}
