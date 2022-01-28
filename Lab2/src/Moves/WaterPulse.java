package Moves;

import ru.ifmo.se.pokemon.*;

public class WaterPulse extends SpecialMove {
    @Override
    protected String describe() {
        return "бульк";
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (Math.random() > 0.2) {
            double damage = ((0.4D * p.getLevel() + 2.0D) * 40.0D / 150.0D) * p.getStat(Stat.ATTACK) / p.getStat(Stat.DEFENSE);
            p.addEffect((new Effect()).turns(4).stat(Stat.HP, (int) damage).chance(0.33D));
        }
    }

    public WaterPulse() {
        this.type = Type.WATER;
        this.power = 60.0D;
        this.accuracy = 1.0D;
    }
}
