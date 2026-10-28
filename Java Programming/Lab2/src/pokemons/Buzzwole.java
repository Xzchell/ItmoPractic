package pokemons;
import attacks.physical.DynamicPunch;
import attacks.status.BulkUp;
import attacks.status.Confide;
import attacks.status.Rest;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Buzzwole extends Pokemon{
    public Buzzwole (String name, int level){
        super(name, level);
        setType(Type.BUG, Type.FIGHTING);
        setStats(107.0, 139.0, 139.0, 53.0, 53.0, 79.0);
        this.setMove(new DynamicPunch(), new Rest(), new BulkUp(), new Confide());
    }
}