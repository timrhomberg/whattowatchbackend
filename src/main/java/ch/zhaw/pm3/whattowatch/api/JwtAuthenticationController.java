package ch.zhaw.pm3.whattowatch.api;

import ch.zhaw.pm3.whattowatch.model.ApplicationUser;
import ch.zhaw.pm3.whattowatch.model.JwtResponse;
import ch.zhaw.pm3.whattowatch.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/authenticate")
@RestController
@CrossOrigin
public class JwtAuthenticationController {
    private final AuthenticationService authenticationService;

    @Autowired
    public JwtAuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping
    public ResponseEntity<?> createAuthenticationToken(@RequestBody ApplicationUser applicationUser) throws Exception {
        authenticationService.authenticate(applicationUser.getUsername(), applicationUser.getPassword());
        String token = authenticationService.getToken(applicationUser.getUsername());
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
