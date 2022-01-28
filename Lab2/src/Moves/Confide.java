package Moves;

import ru.ifmo.se.pokemon.*;

public class Confide extends StatusMove {
    @Override
    protected String describe() {
        return "ослабляет модификатор специалной атаки на 1";
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        p.setMod(Stat.SPECIAL_ATTACK, -1);
    }

    public Confide() {
        this.type = Type.NORMAL;
    }
}
