package ch.zhaw.pm3.whattowatch.api;

import ch.zhaw.pm3.whattowatch.model.Movie;
import ch.zhaw.pm3.whattowatch.service.PreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/preference")
@RestController
public class PreferenceController {
    private final PreferenceService preferenceService;

    @Autowired
    public PreferenceController(PreferenceService preferenceService) {
        this.preferenceService = preferenceService;
    }

    @PostMapping
    public int addPreference(@RequestBody Movie movie) {
        return preferenceService.addPreference(1, movie);
    }

    @GetMapping(path = "{userid}")
    public List<Movie> getPreference(@PathVariable("userid") int userid) {
        return preferenceService.getPreference(userid);
    }
}
