package server.account.service;

import com.org.mmorpg_auth.repository.model.tables.pojos.Users;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import server.account.dto.Account;
import server.account.dto.RegisterDto;
import server.account.repository.AccountRepository;
import server.security.BCryptPasswordEncoderService;

import java.time.LocalDateTime;
import java.util.Objects;

@Slf4j
@Singleton
public class AccountService {

    @Inject
    BCryptPasswordEncoderService bCryptPasswordEncoderService;

    @Inject
    AccountRepository accountRepository;

    public Account fetchAccount(String username) {
        Users user = accountRepository.fetchByUsername(username);

        if (Objects.isNull(user)) {
            return new Account();
        }
        return new Account(user.getUsername(), user.getEmail());
    }

    public Account registerUser(RegisterDto registerDto) {
        try {
            String encodedPassword = bCryptPasswordEncoderService.encode(registerDto.getPassword());

            LocalDateTime now = LocalDateTime.now();
            Users user = new Users();
            user.setEmail(registerDto.getEmail());
            user.setUsername(registerDto.getUsername());
            user.setPassword(encodedPassword);
            user.setEnabled(true);
            user.setCreatedAt(now);
            user.setUpdatedAt(now);
            user.setLastLoggedInAt(now);

            accountRepository.createUser(user);

            Account account = new Account();
            account.setEmail(user.getEmail());
            account.setUsername(user.getUsername());

            return account;
        } catch (Exception e) {
            return new Account();
        }
    }
}
