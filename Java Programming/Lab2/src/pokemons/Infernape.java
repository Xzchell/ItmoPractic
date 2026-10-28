package pokemons;

import attacks.physical.FurySwipes;
import attacks.physical.StoneEdge;
import attacks.status.BulkUp;
import attacks.status.SlackOff;
import ru.ifmo.se.pokemon.Type;

public class Infernape extends Monferno{

    public Infernape(String name, int level) {
        super(name, level);
        setType(Type.FIRE, Type.FIGHTING);
        setStats(76, 104, 71, 104, 71, 108);
        this.setMove(new FurySwipes(), new BulkUp(), new SlackOff(), new StoneEdge());
    }


    
}
