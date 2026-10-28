package pokemons;

import attacks.physical.Facade;
import attacks.physical.WildCharge;
import attacks.special.Thunder;
import attacks.status.ThunderWave;
import ru.ifmo.se.pokemon.Type;

public class Galvantula extends Joltik{

    public Galvantula(String name, int level) {
        super(name, level);
        setType(Type.BUG, Type.ELECTRIC);
        setStats(70, 77, 60, 97, 60, 108);
        this.setMove(new Facade(), new ThunderWave(), new WildCharge(), new Thunder());
    }
    
}
