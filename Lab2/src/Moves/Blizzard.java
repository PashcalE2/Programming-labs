package Moves;

import ru.ifmo.se.pokemon.*;

public class Blizzard extends SpecialMove {
    @Override
    protected String describe() {
        return "наносит урон, может заморозит";
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        p.setCondition((new Effect()).condition(Status.FREEZE).turns(1).chance(0.1D));
    }

    public Blizzard() {
        this.type = Type.ICE;
        this.power = 110.0D;
        this.accuracy = 0.7D;
    }
}