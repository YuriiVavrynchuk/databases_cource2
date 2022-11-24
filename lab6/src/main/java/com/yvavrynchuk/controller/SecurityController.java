package com.yvavrynchuk.controller;

import com.yvavrynchuk.DTO.SecurityDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping(value = "/security")
@RestController
@AllArgsConstructor
@Slf4j
public class SecurityController {
    private final String PASSWORD = "vavryktop";
    private final String SUCCESS_LOGIN_MESSAGE = "Logged successfully";
    private final String FAILED_LOGIN_MESSAGE = "Logging failed";

    @PostMapping("/login")
    String login(final @Valid @RequestBody SecurityDTO securityDTO) {
        if (securityDTO.getPassword().equals(PASSWORD)) {
            log.info(SUCCESS_LOGIN_MESSAGE);
            return  SUCCESS_LOGIN_MESSAGE;
        }
        log.error(FAILED_LOGIN_MESSAGE);
        return FAILED_LOGIN_MESSAGE;
    }
}
