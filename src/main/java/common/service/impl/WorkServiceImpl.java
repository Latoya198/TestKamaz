package common.service.impl;

import common.model.Work;
import common.reposytory.WorkReposytory;
import common.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
