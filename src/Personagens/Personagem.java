package Personagens;

import java.util.Random;

public class Personagem {
    public String tipo;
    public int pontosDeVida;
    public int força;
    public int defesa;
    public int agilidade;
    public int numRodadas = 1;

    public void setPontosDeVida(int pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }
    public int getForça() {
        return força;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public Personagem(String tipo, int pontosDeVida, int força, int defesa, int agilidade)
    {
        this.tipo = tipo;
        this.pontosDeVida = pontosDeVida;
        this.força = força;
        this.defesa = defesa;
        this.agilidade = agilidade;
    }

    Random random = new Random();

    public int fatorAtaque()
    {
        int dadoDe10Faces = random.nextInt(10) + 1;
        int agilidade = getAgilidade();
        int força = getForça();
        return dadoDe10Faces + agilidade + força;
    }

    public int fatorDefesa()
    {
        int dadoDe10Faces = random.nextInt(10) + 1;
        int agilidade = getAgilidade();
        int defesa = getDefesa();
        return dadoDe10Faces + agilidade + defesa;
    }

    private int tipoDeDado;
    public int calcularFatorDeDano() {
        switch (tipoDeDado) {
            case 2 :
                return Dados.Dado2Lados();
            case 4:
                return Dados.Dado4Lados();
            case 6:
                return Dados.Dado6Lados();
            case 8:
                return Dados.Dado8Lados();
            default:
                return 0;
        }
    }
    protected void setTipoDeDado(int i) {
        tipoDeDado = i;
    }
}
