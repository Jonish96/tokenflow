package com.paryogsaala.tokenflow.dto;

public record LoginResponse(
        String accessToken,
        String tokenType
) {
}
