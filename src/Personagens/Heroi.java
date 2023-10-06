package Personagens;
import index.LogJogo;
import index.Prints;
import java.util.Scanner;

public class Heroi extends Personagem implements IJogada{

    @Override
    public void AtacarOuDefender(Heroi heroi, Monstro monstro) {

        Scanner scan = new Scanner(System.in);

        System.out.println("\n--------------------------------------------------------------");
        System.out.println("\nVez do '" + heroi.tipo + "' iniciar a jogada\n");
        
        int heroiAtaque = heroi.fatorAtaque();
        int monstroDefesa = monstro.fatorDefesa();
        String vez = heroi.tipo;

        Prints.Timing();
        
        System.out.println("Esses são os pontos de ataque do  " + heroi.tipo +": " + heroiAtaque);

        Prints.Timing();

        System.out.println("Esses são os pontos de defesa do  " + monstro.tipo +": " + monstroDefesa);

        if(heroiAtaque > monstroDefesa)
        {
            System.out.printf(heroi.tipo + " ataca.");

            Prints.Timing();

            int dano = heroi.calcularFatorDeDano() + heroi.força;
            System.out.printf("\nO dano foi de: "+ dano +"\n");

            if(monstro.pontosDeVida > 0)
            {
                monstro.setPontosDeVida(monstro.pontosDeVida - dano);
                System.out.println("Vida do " + monstro.tipo + ": " + monstro.pontosDeVida);
                if(monstro.pontosDeVida <= 0)
                {
                    numRodadas++;
                    System.out.println("Você ["+ heroi.tipo +"] venceu o jogo! Parabéns");
                    LogJogo.gravarArquivo(heroi, "GANHOU", monstro,numRodadas);
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
            System.out.printf(monstro.tipo + " defendeu o ataque. Próxima rodada.\n");
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

    public Heroi(String tipo, int pontosDeVida, int força, int defesa, int agilidade) {
        super(tipo, pontosDeVida, força, defesa, agilidade);
    }
}
