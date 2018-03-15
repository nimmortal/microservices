package lv.micro.server.movie;

import lv.micro.server.director.DirectorEntity;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "movie")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    private DirectorEntity director;

    public Integer getId() {
        return id;
    }

    public MovieEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public MovieEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public DirectorEntity getDirector() {
        return director;
    }

    public MovieEntity setDirector(DirectorEntity director) {
        this.director = director;
        return this;
    }
}
