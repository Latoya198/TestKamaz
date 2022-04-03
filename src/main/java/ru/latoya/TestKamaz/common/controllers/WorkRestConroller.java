package ru.latoya.TestKamaz.common.controllers;

import org.springframework.web.bind.annotation.*;
import ru.latoya.TestKamaz.common.service.WorkService;
import ru.latoya.TestKamaz.common.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/work/")
public class WorkRestConroller {

    private final WorkService workService;

    @Autowired
    public WorkRestConroller(WorkService workService) {
        this.workService = workService;
    }

    @PostMapping("/addWork")
    public ResponseEntity<Work> addWork(@RequestBody Work work) {
        work.setCreationWorkDay(LocalDate.now());
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(workService.createNewWork(work));
    }

    @GetMapping("getAllWorks")
    public ResponseEntity<List<Work>> getAllWorks() {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(workService.findAll());
    }

}
