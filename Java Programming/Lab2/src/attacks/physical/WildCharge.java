package attacks.physical;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class WildCharge extends PhysicalMove{
    public WildCharge(){
        super(Type.ELECTRIC, 90, 1.0f);
    }
 
    @Override
    protected void applySelfDamage(Pokemon p, double damage) {
         p.setMod(Stat.HP, (int) Math.round(damage * 0.25f));
    }
}
