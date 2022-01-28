package Main;

import ru.ifmo.se.pokemon.*;
import Pokemons.*;

public class Main {

    public static void main(String[] args) {
        Battle b = new Battle();

        Pokemon[] team1 = { new Honedge("A", 1), new Doublade("B", 1), new AegislashBlade("C", 1) };
        Pokemon[] team2 = { new Dunsparce("1", 1), new Drifloon("2", 1), new Drifblim("3", 1) };

        for (Pokemon i : team1) {
            b.addAlly(i);
        }

        for (Pokemon i : team2) {
            b.addFoe(i);
        }

        b.go();
    }
}
