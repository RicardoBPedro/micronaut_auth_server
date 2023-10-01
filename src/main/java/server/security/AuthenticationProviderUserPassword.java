package server.security;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.*;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import server.account.repository.AccountRepository;

@Singleton
public class AuthenticationProviderUserPassword implements AuthenticationProvider<HttpRequest<?>> {

    @Inject
    AccountRepository accountRepository;

    @Override
    public Publisher<AuthenticationResponse> authenticate(@Nullable HttpRequest<?> httpRequest,
                                                          AuthenticationRequest<?, ?> authenticationRequest) {
        return Flux.create(emitter -> {
            String username = (String) authenticationRequest.getIdentity();
            String pw = (String) authenticationRequest.getSecret();

            boolean validCredentials = accountRepository.validCredentials(username, pw);

            if (validCredentials) {
                emitter.next(AuthenticationResponse.success(username, accountRepository.getRolesForUser(username)));
                emitter.complete();
            } else {
                emitter.error(new AuthenticationException(new AuthenticationFailed()));
            }
        }, FluxSink.OverflowStrategy.ERROR);
    }
}
