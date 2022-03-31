package common.reposytory;

import common.model.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkReposytory extends JpaRepository<Work, Long> {
}
