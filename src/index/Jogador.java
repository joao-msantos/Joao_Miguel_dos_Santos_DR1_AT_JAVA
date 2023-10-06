package index;

import Personagens.Heroi;

public class Jogador {
    public static String nickName;
    private Heroi heroi;

    public Heroi getHeroi() {
        return heroi;
    }

    public void setHeroi(Heroi heroi) {
        this.heroi = heroi;
    }

    public Jogador (Heroi heroi)
    {
        this.heroi = heroi;
    }
}
