package attacks.status;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class BulkUp extends StatusMove{
    public BulkUp(){
        super(Type.FIGHTING, 0, 1);
    }

    @Override 
    protected void applySelfEffects(Pokemon p){
        p.setMod(Stat.ATTACK, +1);
        p.setMod(Stat.DEFENSE, +1);
    }

    @Override
    protected String describe(){
        return "Повышает свою атаку и защиту";
    }
}
