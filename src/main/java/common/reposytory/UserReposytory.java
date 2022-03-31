package common.reposytory;

import common.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReposytory extends JpaRepository<User, Long> {
}
