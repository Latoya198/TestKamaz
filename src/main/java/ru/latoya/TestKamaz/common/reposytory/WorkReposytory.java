package ru.latoya.TestKamaz.common.reposytory;

import ru.latoya.TestKamaz.common.model.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkReposytory extends JpaRepository<Work, Long> {
}
