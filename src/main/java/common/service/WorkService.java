package common.service;

import common.model.Work;

import java.util.List;

public interface WorkService {
    List<Work> findAll();
    Work createNewWork(Work work);
}
