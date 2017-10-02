package pl.infobaza.rekrutacja.mytko.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    @Length.List({
            @Length(min = 3),
            @Length(max = 50),
    })
    private String title;

    @Column
    @NotNull
    @Length.List({
            @Length(min = 3),
            @Length(max = 1024),
    })
    private String description;

    @Column
    private Boolean status;

}
