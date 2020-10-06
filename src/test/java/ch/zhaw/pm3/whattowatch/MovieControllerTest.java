package ch.zhaw.pm3.whattowatch;

import ch.zhaw.pm3.whattowatch.api.MovieController;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MovieControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private MovieController movieController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() throws Exception {
        assertThat(movieController).isNotNull();
    }

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        JSONObject obj = new JSONObject();

        obj.put("id", "foo");
        obj.put("name", "rhomberg");

        assertThat(this.restTemplate.getForObject("localhost:" + port + "/api/v1/movie",
                String.class)).contains("name");
    }
}
