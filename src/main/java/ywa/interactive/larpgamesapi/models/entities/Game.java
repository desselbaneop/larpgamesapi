package ywa.interactive.larpgamesapi.models.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Address;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Data
@Entity
@RequiredArgsConstructor
public class Game {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

/*    @ManyToOne
    private Lore lore;*/
    private String country;
    private String address;
    private int estimatedPlayers;
    private double price;
    private int playTime;
}
