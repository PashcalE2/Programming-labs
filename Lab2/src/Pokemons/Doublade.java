package Pokemons;

import Moves.*;

public class Doublade extends Honedge {
    public Doublade(String name, int lvl) {
        super(name, lvl);

        setStats(59, 110, 150, 45, 49, 35);

        addMove(new WaterPulse());
    }
}