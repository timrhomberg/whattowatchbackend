package ch.zhaw.pm3.whattowatch.api;

import ch.zhaw.pm3.whattowatch.model.ApplicationUser;
import ch.zhaw.pm3.whattowatch.model.JwtResponse;
import ch.zhaw.pm3.whattowatch.service.AuthenticationService;
import ch.zhaw.pm3.whattowatch.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/register")
@RestController
public class RegisterController {
    private final AuthenticationService authenticationService;
    private final JwtUserDetailsService userDetailsService;

    @Autowired
    public RegisterController(AuthenticationService authenticationService,
                              JwtUserDetailsService userDetailsService) {
        this.authenticationService = authenticationService;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody ApplicationUser applicationUser) throws Exception {
        userDetailsService.createUser(applicationUser);
        authenticationService.authenticate(applicationUser.getUsername(), applicationUser.getPassword());
        String token = authenticationService.getToken(applicationUser.getUsername());
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
