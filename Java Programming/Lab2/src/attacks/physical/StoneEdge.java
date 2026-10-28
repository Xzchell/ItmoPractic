package attacks.physical;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class StoneEdge extends PhysicalMove{

    public StoneEdge() {
        super(Type.ROCK, 100, 0.8);
    }

    @Override
    protected double calcCriticalHit(Pokemon p1, Pokemon p2) {
        return Math.random() < 1.0 / 8.0 ? 2.0 : 1.0;
    }

    @Override
    protected String describe() {
        return "Использует Каменный край";
    }
    
}
