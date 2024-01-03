package portifolio.io.erosvital.portifolio_erosvital.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import portifolio.io.erosvital.portifolio_erosvital.Domain.User;
import portifolio.io.erosvital.portifolio_erosvital.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
public User save(User user) {
    if (repository.existsByUsername(user.getUsername())) {
        throw new RuntimeException("Username already exists: " + user.getUsername());
    }

    try {
        return repository.save(user);
    } catch (DataAccessException e) {
        throw new RuntimeException("Error saving user", e);
    }
}

}