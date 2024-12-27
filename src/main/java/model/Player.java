package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player implements Comparable<Player> {
    private String name;
    private int score;

    @Override
    public int compareTo(Player o) {
        return Integer.compare( o.score,this.score);
    }
}
