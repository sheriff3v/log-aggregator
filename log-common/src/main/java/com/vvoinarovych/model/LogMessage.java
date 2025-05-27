package com.vvoinarovych.model;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record LogMessage(String serviceName, String log, LocalDateTime timestamp) {
}
