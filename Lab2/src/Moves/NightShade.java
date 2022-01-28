package Moves;

import ru.ifmo.se.pokemon.*;

public class NightShade extends SpecialMove {
    @Override
    protected String describe() {
        return "наносит урон равный своему уровню";
    }

    @Override
    protected double calcBaseDamage(Pokemon var1, Pokemon var2) {
        return var1.getLevel();
    }

    @Override
    protected double calcRandomDamage(Pokemon var1, Pokemon var2) {
        return 1.0D;
    }

    public NightShade() {
        this.type = Type.GHOST;
        this.power = 0.0D;
        this.accuracy = 1.0D;
    }
}
