package com.example.demo.dao;

import com.example.demo.model.TrashCanEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrashCanEntryDAO extends MongoRepository<TrashCanEntry, String> {
}
