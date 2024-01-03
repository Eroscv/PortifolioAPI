package portifolio.io.erosvital.portifolio_erosvital.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import portifolio.io.erosvital.portifolio_erosvital.Domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
}
