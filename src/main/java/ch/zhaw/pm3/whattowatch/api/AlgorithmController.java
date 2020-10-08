package ch.zhaw.pm3.whattowatch.api;

import ch.zhaw.pm3.whattowatch.model.Movie;
import ch.zhaw.pm3.whattowatch.service.AlgorithmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/algorithm")
@RestController
public class AlgorithmController {
    private final AlgorithmService algorithmService;

    @Autowired
    public AlgorithmController(AlgorithmService algorithmService) {
        this.algorithmService = algorithmService;
    }

    @GetMapping(path = "{count}")
    public List<Movie> getSpecificRecommendations(@PathVariable("count") int count) {
        return algorithmService.getSpecificRecommendations(count);
    }

    @PostMapping
    public void addPreference(@RequestBody Movie movie) {
        algorithmService.addPreference(movie);
    }
}
