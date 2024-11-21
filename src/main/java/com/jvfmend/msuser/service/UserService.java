package com.jvfmend.msuser.service;

import com.jvfmend.msuser.entity.User;
import com.jvfmend.msuser.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findByIdOrThrow(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, User user) {
        User existingUser = findByIdOrThrow(id);
        user.setId(existingUser.getId());
        return userRepository.save(user);
    }

    public void delete(Long id) {
        findByIdOrThrow(id);
        userRepository.deleteById(id);
    }
}
