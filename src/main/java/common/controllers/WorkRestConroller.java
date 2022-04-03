package common.controllers;

import common.model.Work;
import common.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Work> addWork(Work work) {
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
