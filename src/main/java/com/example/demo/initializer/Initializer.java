package com.example.demo.initializer;

import com.example.demo.dao.TrashCanDAO;
import com.example.demo.dao.TrashCanEntryDAO;
import com.example.demo.model.TrashCan;
import com.example.demo.model.TrashCanEntry;
import com.example.demo.model.TrashCanType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;

@Component
public class Initializer {

    @Autowired
    private TrashCanDAO trashCanDAO;

    @Autowired
    private TrashCanEntryDAO trashCanEntryDAO;

    @PostConstruct
    private void construct() {


        trashCanDAO.deleteAll();
        TrashCan blueTrashCan = TrashCan.builder()
                .capacity(100)
                .type(TrashCanType.BLUE)
                .longitude(7.596618)
                .latitude(50.413543)
                .entries(new ArrayList<>() {{
                    add(TrashCanEntry.builder().date(new Date(new Date().getTime() - 1000 * 60 * 60 * 24)).kg(1.3).price(3).build());
                    add(TrashCanEntry.builder().date(new Date()).kg(2.4).price(6).build());
                }})
                .build();

        TrashCan greenTrashCan = TrashCan.builder()
                .capacity(100)
                .type(TrashCanType.GREEN)
                .longitude(7.596747)
                .latitude(50.413324)
                .entries(new ArrayList<>() {{
                    add(TrashCanEntry.builder().date(new Date(new Date().getTime() - 1000 * 60 * 60 * 24)).kg(1.3).price(3).build());
                    add(TrashCanEntry.builder().date(new Date()).kg(2.4).price(6).build());
                }})
                .build();

        TrashCan yellowTrashCan = TrashCan.builder()
                .capacity(100)
                .type(TrashCanType.YELLOW)
                .longitude(7.596897)
                .latitude(50.412982)
                .entries(new ArrayList<>() {{
                    add(TrashCanEntry.builder().date(new Date(new Date().getTime() - 1000 * 60 * 60 * 24)).kg(1.3).price(3).build());
                    add(TrashCanEntry.builder().date(new Date()).kg(2.4).price(6).build());
                }})
                .build();

        TrashCan blackTrashCan = TrashCan.builder()
                .capacity(100)
                .type(TrashCanType.BLACK)
                .longitude(7.596779)
                .latitude(50.412784)
                .entries(new ArrayList<>() {{
                    add(TrashCanEntry.builder().date(new Date(new Date().getTime() - 1000 * 60 * 60 * 24)).kg(1.3).price(3).build());
                    add(TrashCanEntry.builder().date(new Date()).kg(2.4).price(6).build());
                }})
                .build();

        blueTrashCan.getEntries().forEach((e) -> {
            TrashCanEntry saved = trashCanEntryDAO.save(e);
            e.setId(saved.getId());
        });

        greenTrashCan.getEntries().forEach((e) -> {
            TrashCanEntry saved = trashCanEntryDAO.save(e);
            e.setId(saved.getId());
        });

        yellowTrashCan.getEntries().forEach((e) -> {
            TrashCanEntry saved = trashCanEntryDAO.save(e);
            e.setId(saved.getId());
        });

        blackTrashCan.getEntries().forEach((e) -> {
            TrashCanEntry saved = trashCanEntryDAO.save(e);
            e.setId(saved.getId());
        });
        trashCanDAO.save(blueTrashCan);
        trashCanDAO.save(greenTrashCan);
        trashCanDAO.save(yellowTrashCan);
        trashCanDAO.save(blackTrashCan);
    }

}
