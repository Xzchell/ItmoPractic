package pokemons;

import attacks.physical.Facade;
import attacks.physical.WildCharge;
import attacks.status.ThunderWave;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Joltik extends Pokemon{
    public Joltik(String name, int level){
        super(name, level);
        setType(Type.ELECTRIC, Type.BUG);
        setStats(50.0, 47, 50, 57, 50, 65);
        this.setMove(new Facade(), new ThunderWave(), new WildCharge());
    }
}
