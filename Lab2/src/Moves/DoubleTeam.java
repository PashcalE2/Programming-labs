package Moves;

import ru.ifmo.se.pokemon.*;

public class DoubleTeam extends StatusMove {
    @Override
    protected String describe() {
        return "применять дабл тим на себя (че это значит? (увеличивает показатель уклонения...))";
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        p.setMod(Stat.EVASION, 1);
    }

    public DoubleTeam() {
        this.type = Type.NORMAL;
    }
}
