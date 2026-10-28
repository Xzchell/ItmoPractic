package attacks.physical;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Status;
import ru.ifmo.se.pokemon.Type;

public class Facade extends PhysicalMove{
    public Facade(){
        super(Type.NORMAL, 70, 1.0);
    }

    @Override
    protected double calcBaseDamage(Pokemon p1, Pokemon p2) {
        double damage = super.calcBaseDamage(p1, p2);
        
        if(p1.getCondition() == Status.BURN || p1.getCondition() == Status.POISON || p1.getCondition() == Status.PARALYZE)
            return damage * 2;
        return damage;
    }

    @Override
    protected String describe() {
        return "Использует Атаку по фасаду";
    }
}
