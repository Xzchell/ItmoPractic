package attacks.physical;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class FurySwipes extends PhysicalMove{

    final private int MAX_COUNT_HITS = 5;
    final private int MIN_COUNT_HITS = 2;

    public FurySwipes() {
        super(Type.NORMAL, 18, 0.8);
    }

    @Override
    protected double calcBaseDamage(Pokemon p1, Pokemon p2) {
        double damage = super.calcBaseDamage(p1, p2);
        return damage * getHitsCount(MIN_COUNT_HITS, MAX_COUNT_HITS);
    }

    private int getHitsCount(int min, int max){
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    @Override
    protected String describe() {
        return "Использует Шквал ударов";
    }
    
}
