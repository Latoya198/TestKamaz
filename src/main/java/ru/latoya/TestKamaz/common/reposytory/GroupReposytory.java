package ru.latoya.TestKamaz.common.reposytory;

import ru.latoya.TestKamaz.common.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupReposytory extends JpaRepository<Group, Long> {
}
