package com.jvfmend.msuser.service;

import com.jvfmend.msuser.dto.UserRequestDTO;
import com.jvfmend.msuser.dto.UserResponseDTO;
import com.jvfmend.msuser.entity.User;
import com.jvfmend.msuser.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserResponseDTO> findAll() {
        return userRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public UserResponseDTO findByIdOrThrow(Long id) {
        return userRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public UserResponseDTO save(UserRequestDTO userRequestDTO) {
        User user = convertToEntity(userRequestDTO);
        return convertToDTO(userRepository.save(user));
    }

    public UserResponseDTO update(Long id, UserRequestDTO userRequestDTO) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        User updatedUser = convertToEntity(userRequestDTO);
        updatedUser.setId(existingUser.getId());
        return convertToDTO(userRepository.save(updatedUser));
    }

    public void delete(Long id) {
        userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        userRepository.deleteById(id);
    }

    private User convertToEntity(UserRequestDTO userRequestDTO) {
        return new User(null, userRequestDTO.name(), userRequestDTO.email(), userRequestDTO.login(),
                userRequestDTO.password(), LocalDateTime.now(), userRequestDTO.address());
    }

    private UserResponseDTO convertToDTO(User user) {
        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail(), user.getLogin(),
                user.getAddress(), user.getLastModified());
    }
}
