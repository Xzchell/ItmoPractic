import pokemons.Buzzwole;
import pokemons.Chimchar;
import pokemons.Galvantula;
import pokemons.Infernape;
import pokemons.Joltik;
import pokemons.Monferno;
import ru.ifmo.se.pokemon.*;

public class App {
    public static void main(String[] args) throws Exception {
        Battle b = new Battle();
        b.addAlly(new Infernape("Infernape",49));
        b.addAlly(new Buzzwole("Buzzwole", 59));
        b.addAlly(new Galvantula("Galvantula", 42));

        b.addFoe(new Joltik("Joltik", 4));
        b.addFoe(new Chimchar("Chimchar", 15));
        b.addFoe(new Monferno("Monferno", 49));

        b.go();   
    }
}
