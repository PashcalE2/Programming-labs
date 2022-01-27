package Moves;

import ru.ifmo.se.pokemon.*;

public class Swagger extends StatusMove {
    @Override
    protected String describe() {
        return "применяет способность Swagger на противника";
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        p.setMod(Stat.ATTACK, 2);
        double damage = ((0.4D * (double)p.getLevel() + 2.0D) * 40.0D / 150.0D) * p.getStat(Stat.ATTACK) / p.getStat(Stat.DEFENSE);
        p.addEffect(new Effect().turns(4).chance(0.33D).stat(Stat.HP, (int)damage));
    }

    public Swagger() {
        this.type = Type.NORMAL;
        this.accuracy = 0.85D;
    }
}