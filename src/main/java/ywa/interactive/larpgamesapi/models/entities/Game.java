package ywa.interactive.larpgamesapi.models.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@RequiredArgsConstructor
public class Game {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    private String country;

    @Column
    private String address;

    @Column(name = "estimated_players")
    private int estimatedPlayers;

    @Column
    private double price;

    @Column(name = "duration")
    private int playTime;

    @ManyToOne
    @JoinColumn(name="lore_id", nullable = false)
    private Lore lore;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Game game = (Game) o;
        return id != null && Objects.equals(id, game.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
