package pokemons;

import attacks.physical.FurySwipes;
import attacks.status.BulkUp;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Chimchar extends Pokemon{

    public Chimchar(String name, int level) {
        super(name, level);
        setType(Type.FIRE);
        setStats(44, 58, 44, 58, 44, 61);
        this.setMove(new BulkUp(), new FurySwipes());
    }
}
