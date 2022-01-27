package Pokemons;

import Moves.*;

public class AegislashBlade extends Doublade {
    public AegislashBlade(String name, int lvl) {
        super(name, lvl);

        setStats(60, 50, 140, 50, 140, 60);

        addMove(new Facade());
    }
}
