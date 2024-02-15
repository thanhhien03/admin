package QuanLy.com.example.demo.service;

import QuanLy.com.example.demo.entity.User;
import QuanLy.com.example.demo.repository.UserRepository;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) throws ChangeSetPersister.NotFoundException {
        return userRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }

    public User updateUser(Long id, User user) {
        return updateUser(id, user);
    }

    public boolean deleteUser(Long id) {
        return deleteUser(id);
    }

    public User createUser(User user) {
        return createUser(user);
    }
}
