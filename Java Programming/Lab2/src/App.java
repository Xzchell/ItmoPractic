import ru.ifmo.se.pokemon.*;

public class App {
    public static void main(String[] args) throws Exception {
        Battle b = new Battle();
        Pokemon p1 = new Pokemon("Pokemooon 1", 1);
        Pokemon p2 = new Pokemon("Pokeekke 2", 1);

        b.addAlly(p1);
        b.addFoe(p2);

        b.go();
        
    }
}
