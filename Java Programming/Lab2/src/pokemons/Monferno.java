package pokemons;

import attacks.physical.FurySwipes;
import attacks.status.BulkUp;
import attacks.status.SlackOff;
import ru.ifmo.se.pokemon.Type;

public class Monferno extends Chimchar{

    public Monferno(String name, int level) {
        super(name, level);
        setType(Type.FIGHTING, Type.FIRE);
        setStats(64, 78, 52, 78, 52, 81);
        this.setMove(new FurySwipes(), new BulkUp(), new SlackOff());
    }
    
}
