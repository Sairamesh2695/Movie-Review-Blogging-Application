package com.movie.review_blogging_application.user.entity;

import com.movie.review_blogging_application.user.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    private Boolean isActive = Boolean.FALSE;

    private String password;

    private String bio;

    private Integer tagVersion = 1;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Override
    public boolean equals(Object object){
        if(this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;
        User that = (User) object;
        return Objects.equals(id,that.id);
    }

    @Override
    public int hashCode(){return Objects.hash(id);}

    public void updateTagVersion(){
        this.tagVersion = this.tagVersion + 1;
    }
}
