package Personagens;
import java.util.Random;
public class Dados {
    private static Random random = new Random();

    public static int Dado4Lados() {
        return (random.nextInt(4) + 1) + (random.nextInt(4) + 1);
    }

    public static int Dado6Lados() {
        return (random.nextInt(6) + 1) + (random.nextInt(6) + 1);
    }

    public static int Dado8Lados() {
        return random.nextInt(8) + 1;
    }

    public static int Dado2Lados() {
        return (random.nextInt(2) + 1) + (random.nextInt(2) + 1) + (random.nextInt(2) + 1);
    }
}
