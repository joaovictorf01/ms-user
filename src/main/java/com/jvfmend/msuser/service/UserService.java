package com.jvfmend.msuser.service;

import com.jvfmend.msuser.dto.UserLoginRequestDTO;
import com.jvfmend.msuser.dto.UserRequestDTO;
import com.jvfmend.msuser.dto.UserResponseDTO;
import com.jvfmend.msuser.entity.User;
import com.jvfmend.msuser.exception.UserNotFoundException;
import com.jvfmend.msuser.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public List<UserResponseDTO> findAll() {
        return userRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public UserResponseDTO findByIdOrThrow(Long id) {
        return userRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    public UserResponseDTO save(UserRequestDTO userRequestDTO) {
        User user = convertToEntity(userRequestDTO);
        return convertToDTO(userRepository.save(user));
    }

    public UserResponseDTO update(Long id, UserRequestDTO userRequestDTO) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        User updatedUser = convertToEntity(userRequestDTO);
        updatedUser.setId(existingUser.getId());
        return convertToDTO(userRepository.save(updatedUser));
    }

    public void delete(Long id) {
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
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

    public boolean validateLogin(UserLoginRequestDTO userLoginRequestDTO) {
        return userRepository.findByLogin(userLoginRequestDTO.login())
                .map(user -> user.getPassword().equals(userLoginRequestDTO.password()))
                .orElse(false);
    }

    public void updatePassword(Long id, String newPassword) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        user.setPassword(newPassword);
        userRepository.save(user);
    }

}
