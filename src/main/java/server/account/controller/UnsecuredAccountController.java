package server.account.controller;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.inject.Inject;
import server.account.dto.Account;
import server.account.dto.RegisterDto;
import server.account.service.AccountService;

@Controller
@Secured(SecurityRule.IS_ANONYMOUS)
public class UnsecuredAccountController {

    @Inject
    AccountService accountService;

    @Post("/register")
    public Account register(@Body RegisterDto registerDto) {
        return accountService.registerUser(registerDto);
    }
}
