package lv.micro.server.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class MovieServiceDefault implements MovieService {

    private final MovieRepository repository;

    @Autowired
    public MovieServiceDefault(MovieRepository movieRepository) {
        this.repository = movieRepository;
    }

    @Override
    public Integer save(Movie movie) {
        MovieEntity entity = map(movie);
        MovieEntity saved = repository.save(entity);
        return saved.getId();
    }

    private MovieEntity map(Movie movie) {
        return new MovieEntity()
                .setId(movie.getId())
                .setTitle(movie.getTitle());
    }
}
