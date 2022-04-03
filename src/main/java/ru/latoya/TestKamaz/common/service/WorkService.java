package ru.latoya.TestKamaz.common.service;

import ru.latoya.TestKamaz.common.model.Work;

import java.util.List;

public interface WorkService {
    List<Work> findAll();
    Work createNewWork(Work work);
}
