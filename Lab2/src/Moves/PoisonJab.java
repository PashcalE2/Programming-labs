package Moves;

import ru.ifmo.se.pokemon.*;

public class PoisonJab extends PhysicalMove {
    @Override
    protected String describe() {
        return "бьет и может быть отравит";
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        for (Type v : p.getTypes()) {
            if (v == Type.POISON || v == Type.STEEL) {
                return ;
            }
        }

        p.setCondition((new Effect()).chance(0.3D).condition(Status.POISON).turns(3));
    }

    public PoisonJab() {
        this.type = Type.POISON;
        this.power = 80.0D;
        this.accuracy = 1.0D;
    }
}