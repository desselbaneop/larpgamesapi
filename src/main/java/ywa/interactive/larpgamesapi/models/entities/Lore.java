package ywa.interactive.larpgamesapi.models.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@RequiredArgsConstructor
public class Lore {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private int ageCategory;
    private double rating;
}
