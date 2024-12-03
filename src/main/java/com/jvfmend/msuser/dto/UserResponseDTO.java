package com.jvfmend.msuser.dto;

import java.time.LocalDateTime;

public record UserResponseDTO(Long id, String name, String email, String login, String address,
        LocalDateTime lastModified) {
}
