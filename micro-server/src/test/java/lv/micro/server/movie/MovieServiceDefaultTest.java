package lv.micro.server.movie;

import lv.micro.server.ServiceConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServiceConfiguration.class)
@TestPropertySource("classpath:test.properties")
@Transactional
public class MovieServiceDefaultTest {

    @Autowired
    private MovieService movieService;

    @Test
    public void shouldSaveMovie() {
        // Assert
        Movie movie = new Movie().setTitle("Movie");

        // Act
        Integer saveId = movieService.save(movie);

        // Arrange
        assertThat(saveId).isNotNull();
    }
}