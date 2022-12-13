package com.pettion.server.model.bidder.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
    @NotBlank
    private String accountId;
    @Setter
    @NotBlank
    private String password;
    @NotBlank
    private String nickname;
}
