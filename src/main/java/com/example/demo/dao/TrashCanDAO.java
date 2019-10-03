package com.example.demo.dao;

import com.example.demo.model.TrashCan;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrashCanDAO extends MongoRepository<TrashCan, String> {
}
