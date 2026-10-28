package attacks.status;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Status;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class Rest extends StatusMove{

    public Rest() {
        super(Type.PSYCHIC, 0, 1.0);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        p.setMod(Stat.HP, (int) -(p.getStat(Stat.HP) - p.getHP()));
        p.addEffect(new Effect().condition(Status.SLEEP).turns(2));
    }

    @Override
    protected String describe() {
        return "Восстанавливает здоровье и засыпает";
    }
    
}
