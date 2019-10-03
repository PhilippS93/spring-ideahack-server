package com.example.demo.controller;

import com.example.demo.dao.TrashCanDAO;
import com.example.demo.dao.TrashCanEntryDAO;
import com.example.demo.model.TrashCan;
import com.example.demo.model.TrashCanEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("trash-cans")
public class TrashCanController {

    @Autowired
    private TrashCanDAO trashCanDAO;

    @Autowired
    private TrashCanEntryDAO trashCanEntryDAO;

    @GetMapping()
    private List<TrashCan> getTrashCans() {
        List<TrashCan> trashCans = trashCanDAO.findAll();

        return trashCans;
    }

    @PostMapping()
    private TrashCanEntry saveTrashCans(@PathVariable String id, @RequestBody TrashCanEntry entry) {
        Optional<TrashCan> trashCanOptional = trashCanDAO.findById(id);

        if (trashCanOptional.isEmpty()) {
            throw new IllegalArgumentException();
        }

        TrashCan trashCan = trashCanOptional.get();

        entry = trashCanEntryDAO.save(entry);

        trashCan.getEntries().add(entry);
        trashCanDAO.save(trashCan);

        return entry;
    }
}
