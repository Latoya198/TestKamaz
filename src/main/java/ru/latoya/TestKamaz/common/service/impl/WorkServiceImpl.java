package ru.latoya.TestKamaz.common.service.impl;

import ru.latoya.TestKamaz.common.model.Work;
import ru.latoya.TestKamaz.common.reposytory.WorkReposytory;
import ru.latoya.TestKamaz.common.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {

    private final WorkReposytory reposytory;

    @Autowired
    public WorkServiceImpl(WorkReposytory reposytory) {
        this.reposytory = reposytory;
    }

    @Override
    public List<Work> findAll() {
        return reposytory.findAll();
    }

    @Override
    public Work createNewWork(Work work) {
        return reposytory.save(work);
    }
}
