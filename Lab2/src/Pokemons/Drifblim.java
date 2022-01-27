package Pokemons;

import Moves.*;

public class Drifblim extends Drifloon {
    public Drifblim(String name, int lvl) {
        super(name, lvl);

        setStats(150, 80, 44, 90, 54, 80);

        addMove(new NightShade());
    }
}