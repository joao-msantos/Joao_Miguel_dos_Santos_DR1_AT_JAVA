package Personagens;

public interface IJogada {
    void AtacarOuDefender(Heroi heroi, Monstro monstro);

    void TrocarVez(Heroi heroi, Monstro monstro, String vez);

}
