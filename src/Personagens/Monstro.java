package Personagens;

import index.LogJogo;
import index.Prints;

import java.util.Scanner;

public class Monstro extends Personagem implements IJogada{
    @Override
    public void AtacarOuDefender(Heroi heroi, Monstro monstro) {

        Scanner scan = new Scanner(System.in);

        System.out.println("\n--------------------------------------------------------------");
        System.out.println("\nVez do '" + monstro.tipo + "' iniciar a jogada.\n");

        int monstroAtaque = monstro.fatorAtaque();
        int heroiDefesa = heroi.fatorDefesa();
        String vez = monstro.tipo;

        Prints.Timing();

        System.out.println("Esses são os pontos de ataque do  " + monstro.tipo +": " + monstroAtaque);

        Prints.Timing();

        System.out.println("Esses são os pontos de defesa do  " + heroi.tipo +": " + heroiDefesa);

        if(monstroAtaque > heroiDefesa)
        {
            System.out.printf(monstro.tipo + " ataca.");

            Prints.Timing();

            int dano = monstro.calcularFatorDeDano() + monstro.força;
            System.out.printf("\nO dano foi de: "+ dano +"\n");

            if(heroi.pontosDeVida > 0)
            {
                heroi.setPontosDeVida(heroi.pontosDeVida - dano);
                System.out.println("Vida do " + heroi.tipo + ": " + heroi.pontosDeVida);
                if(heroi.pontosDeVida <= 0)
                {
                    numRodadas++;
                    System.out.println("Você foi derrotado pelo "+ monstro.tipo +". Tente ganhar numa próxima.");
                    LogJogo.gravarArquivo(heroi, "PERDEU", monstro,numRodadas);
                    System.exit(0);
                }
                System.out.println("\n--------------------------------------------------------------\n");
                numRodadas++;
                System.out.println("APERTE ENTER para continuar...");
                scan.nextLine();
                TrocarVez(heroi, monstro, vez);
            }
        }
        else
        {
            Prints.Timing();
            System.out.printf(heroi.tipo + " defendeu o ataque. Próxima rodada.\n");
            System.out.println("--------------------------------------------------------------\n");
            numRodadas++;
            System.out.println("APERTE ENTER para continuar...");
            scan.nextLine();
            TrocarVez(heroi, monstro, vez);
        }
    }

    public void TrocarVez(Heroi heroi, Monstro monstro, String vezJog)
    {
        if(vezJog.equals(heroi.tipo))
        {
            monstro.AtacarOuDefender(heroi, monstro);
        }
        else if(vezJog.equals(monstro.tipo))
        {
            heroi.AtacarOuDefender(heroi, monstro);
        }
    }

    public Monstro(String tipo, int pontosDeVida, int força, int defesa, int agilidade)
    {
        super(tipo, pontosDeVida, força, defesa, agilidade);
    }
}
