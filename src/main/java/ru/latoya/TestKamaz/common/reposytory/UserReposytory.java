package ru.latoya.TestKamaz.common.reposytory;

import ru.latoya.TestKamaz.common.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReposytory extends JpaRepository<User, Long> {
}
