package Pokemons;

import Moves.*;
import ru.ifmo.se.pokemon.*;

public class Honedge extends Pokemon {
    public Honedge(String name, int lvl) {
        super(name, lvl);

        setType(Type.STEEL, Type.GHOST);
        setStats(45, 80, 100, 35, 37, 28);

        addMove(new Confide());
        addMove(new Swagger());
    }
}