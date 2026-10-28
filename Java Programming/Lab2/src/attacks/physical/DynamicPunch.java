package attacks.physical;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class DynamicPunch extends PhysicalMove{
    public DynamicPunch(){
        super(Type.FIGHTING, 100, 0.5);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        p.confuse();
    }

    @Override
    protected String describe() {
        return "Использует Динамический удар";
    }
}
