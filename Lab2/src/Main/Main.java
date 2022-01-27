package Main;

import ru.ifmo.se.pokemon.*;

/*

    Pokemons' default params (https://pokemondb.net/pokedex)

    Params:
        hp, att, def, spAtt, spDef, speed
        type

    Dunsparce:
        100, 70, 70, 65, 65, 45
        NORMAL

    Drifloon:
        90, 50, 34, 60, 44, 70
        GHOST FLYING

    Drifblim:
        150, 80, 44, 90, 54, 80
        GHOST FLYING

    Honedge:
        45, 80, 100, 35, 37, 28
        STEEL GHOST

    Doublade:
        59, 110, 150, 45, 49, 35
        STEEL GHOST

    AegislashBlade:
        60, 50, 140, 50, 140, 60
        STEEL GHOST

*/

// ===========================  SPEC.  MOVES  ===========================

class Blizzard extends SpecialMove {
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

class NightShade extends SpecialMove {
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

class WaterPulse extends SpecialMove {
    @Override
    protected String describe() {
        return "бульк";
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (Math.random() > 0.2) {
            double damage = ((0.4D * (double) p.getLevel() + 2.0D) * 40.0D / 150.0D) * p.getStat(Stat.ATTACK) / p.getStat(Stat.DEFENSE);
            p.addEffect((new Effect()).turns(4).stat(Stat.HP, (int) damage).chance(0.33D));
        }
    }

    public WaterPulse() {
        this.type = Type.WATER;
        this.power = 60.0D;
        this.accuracy = 1.0D;
    }
}

// ===========================  STATUS MOVES  ===========================

class DoubleTeam extends StatusMove {
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

class Confide extends StatusMove {
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

class Swagger extends StatusMove {
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

// ===========================   PHYS MOVES   ===========================

class PoisonJab extends PhysicalMove {
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

class Facade extends PhysicalMove {
    @Override
    protected String describe() {
        return "применяет фасад(и что это значит?)";
    }

    @Override
    protected double calcBaseDamage(Pokemon var1, Pokemon var2) {
        Status status = var1.getCondition();
        double k = (status == Status.BURN) || (status == Status.POISON) || (status == Status.PARALYZE) ? 2 : 1;
        return (0.4D * (double)var1.getLevel() + 2.0D) * this.power * k / 150.0D;
    }

    public Facade() {
        this.type = Type.NORMAL;
        this.power = 70.0D;
        this.accuracy = 1.0D;
    }
}

// ===========================    POKEMONS    ===========================

class Dunsparce extends Pokemon {
    public Dunsparce(String name, int lvl) {
        super(name, lvl);

        setType(Type.NORMAL);
        setStats(100, 70, 70, 65, 65, 45);

        addMove(new PoisonJab());
        addMove(new Blizzard());
        addMove(new DoubleTeam());
        addMove(new Swagger());
    }
}

class Drifloon extends Pokemon {
    public Drifloon(String name, int lvl) {
        super(name, lvl);

        setType(Type.GHOST, Type.FLYING);
        setStats(90, 50, 34, 60, 44, 70);

        addMove(new Swagger());
        addMove(new DoubleTeam());
        addMove(new Confide());
    }
}

class Drifblim extends Drifloon {
    public Drifblim(String name, int lvl) {
        super(name, lvl);

        setStats(150, 80, 44, 90, 54, 80);

        addMove(new NightShade());
    }
}

class Honedge extends Pokemon {
    public Honedge(String name, int lvl) {
        super(name, lvl);

        setType(Type.STEEL, Type.GHOST);
        setStats(45, 80, 100, 35, 37, 28);

        addMove(new Confide());
        addMove(new Swagger());
    }
}

class Doublade extends Honedge {
    public Doublade(String name, int lvl) {
        super(name, lvl);

        setStats(59, 110, 150, 45, 49, 35);

        addMove(new WaterPulse());
    }
}

class AegislashBlade extends Doublade {
    public AegislashBlade(String name, int lvl) {
        super(name, lvl);

        setStats(60, 50, 140, 50, 140, 60);

        addMove(new Facade());
    }
}

// ===========================   MAIN CLASS   ===========================

public class Main {

    public static void main(String[] args) {
        Battle b = new Battle();

        Pokemon[] team1 = { new Honedge("A", 1), new Doublade("B", 1), new AegislashBlade("C", 1) };
        Pokemon[] team2 = { new Dunsparce("1", 1), new Drifloon("2", 1), new Drifblim("3", 1) };

        for (Pokemon i : team1) {
            b.addAlly(i);
        }

        for (Pokemon i : team2) {
            b.addFoe(i);
        }

        b.go();
    }
}
