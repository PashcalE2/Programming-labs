package Pokemons;

import Moves.*;

public class Dunsparce extends Pokemon {
    public Dunsparce(String name, int lvl) {
        super(name, lvl);

        setType(Type.NORMAL);
        setStats(100, 70, 70, 65, 65, 45);

        addMove(new PoisonJab());
        addMove(new Blizzard());
        addMove(new DoubleTeam());
        addMove(new Swagger());
    }
}
