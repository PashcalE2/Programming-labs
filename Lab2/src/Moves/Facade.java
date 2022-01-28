package Moves;

import ru.ifmo.se.pokemon.*;

public class Facade extends PhysicalMove {
    @Override
    protected String describe() {
        return "применяет фасад(и что это значит?)";
    }

    @Override
    protected double calcBaseDamage(Pokemon var1, Pokemon var2) {
        Status status = var1.getCondition();
        double k = (status == Status.BURN) || (status == Status.POISON) || (status == Status.PARALYZE) ? 2 : 1;
        return (0.4D * var1.getLevel() + 2.0D) * this.power * k / 150.0D;
    }

    public Facade() {
        this.type = Type.NORMAL;
        this.power = 70.0D;
        this.accuracy = 1.0D;
    }
}
