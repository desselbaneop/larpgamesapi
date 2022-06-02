package ywa.interactive.larpgamesapi.models.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@RequiredArgsConstructor
public class Lore {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @Column
    private String description;

    @Column(name = "age_category")
    private int ageCategory;

    @Column
    private double rating;

    @Column
    @OneToMany(mappedBy = "lore")
    @ToString.Exclude
    private List<Game> games;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Lore lore = (Lore) o;
        return false;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
