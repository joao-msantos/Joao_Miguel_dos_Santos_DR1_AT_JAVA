package index;

public class Prints {
    public void ImprimirCarregamento(int quant)
    {
        for (int i = 0; i < quant; i++) {
            System.out.print(".");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void ImprimirTabelaMonstro()
    {
        System.out.println("Monstro    - Ponto de vida - Força - Defesa - Agilidade - Fator de Dano\n" +
                "Morto-vivo -     25        -   4   -    0   -     1     -       2d4\n" +
                "ORC        -     20        -   6   -    2   -     2     -       1d8\n" +
                "Kobold     -     20        -   4   -    2   -     4     -       3d2");
    }
    public void ImprimirTabelaHeroi(){
        System.out.println("[ ] Heroi  - Ponto de vida - Força - Defesa - Agilidade - Fator de Dano\n" +
                "[1] Guerreiro -     12      -   4   -    3   -     3     -       2d4\n" +
                "[2] Bárbaro   -     13      -   6   -    1   -     3     -       2d6\n" +
                "[3] Paladino  -     15      -   2   -    5   -     1    -        2d4");
    }

    public static void Timing()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }
}
