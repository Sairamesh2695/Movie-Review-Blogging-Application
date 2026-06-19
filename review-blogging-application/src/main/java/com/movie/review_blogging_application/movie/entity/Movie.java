package com.movie.review_blogging_application.movie.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "movies")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    private String director;
    private String genre;
    private int releaseYear;
    private String description;
    private String posterUrl;
    private Integer tagVersion = 1;
    private Boolean isDeleted = Boolean.FALSE;

    @Override
    public boolean equals(Object object){
        if(this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;
        Movie that = (Movie) object;
        return Objects.equals(id,that.id);
    }

    @Override
    public int hashCode(){return Objects.hash(id);}

    public void updateTagVersion(){
        this.tagVersion = this.tagVersion + 1;
    }
}
