package Pokemons;

import Moves.*;
import ru.ifmo.se.pokemon.*;

public class Drifloon extends Pokemon {
    public Drifloon(String name, int lvl) {
        super(name, lvl);

        setType(Type.GHOST, Type.FLYING);
        setStats(90, 50, 34, 60, 44, 70);

        addMove(new Swagger());
        addMove(new DoubleTeam());
        addMove(new Confide());
    }
}