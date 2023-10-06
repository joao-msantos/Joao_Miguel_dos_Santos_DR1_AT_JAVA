package index;

import Personagens.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Main {
    static Random random = new Random();
    static Jogador jogador;
    static Prints prints = new Prints();
    static Scanner scanner = new Scanner(System.in);
    static Relatorio relatorio = new Relatorio();

    public static void main(String[] args)
    {
        System.out.println("\nBem Vindo ao nosso jogo de Batalha Medieval!");
        System.out.println("Se estiver pronto, pressione ENTER para começar");
        scanner.nextLine();

        int opcao;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("{1} Jogar");
            System.out.println("{2} Ver Relatório");

            try {
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.println("Iniciando o jogo");
                        prints.ImprimirCarregamento(3);
                        EscolhaInicial();
                        break;
                    case 2:
                        System.out.println("Comece inserindo o nick do jogador que deseja obter o relatório:");
                        Scanner scanner2 = new Scanner(System.in);
                        String nickRelatorio = scanner2.nextLine();
                        System.out.println("Exibindo o relatório");
                        prints.ImprimirCarregamento(3);

                        relatorio.procurarLog(nickRelatorio);
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Opção inválida. Por favor, insira um número inteiro.");
                scanner.nextLine();
                opcao = 0;
            }
        } while (opcao != 1 && opcao != 2);
        scanner.close();
    }
    public static void EscolhaInicial(){
        Scanner scanner1 = new Scanner(System.in);
        String nick = null;

        while (nick == null) {
            System.out.println("\nEntre com o seu nickname: ");
            nick = scanner1.nextLine();
            Jogador.nickName = nick;

            if (nick == null || nick.trim().isEmpty()) {
                System.out.println("O nickname não pode ser vazio. Tente novamente.");
                nick = null;
            }
        }

        System.out.println("Escolha um herói\n");
        prints.ImprimirTabelaHeroi();
        try
        {
            int escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    jogador = new Jogador(new Guerreiro());
                    SorteioInicial();
                    break;
                case 2:
                    jogador = new Jogador(new Barbaro());
                    SorteioInicial();
                    break;
                case 3:
                    jogador = new Jogador(new Paladino());
                    SorteioInicial();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    EscolhaInicial();
                    break;
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Opção inválida. Por favor, insira um número inteiro.");
            EscolhaInicial();
        }
    }

    public static void SorteioInicial()
    {
        System.out.println("\nTabela de monstros:\n");

        prints.ImprimirTabelaMonstro();

        Monstro monstro1 = new MortoVivo();
        Monstro monstro2 = new Orc();
        Monstro monstro3 = new Kobold();

        List<Monstro> listaDeMonstros = new ArrayList<>();
        listaDeMonstros.add(monstro1);
        listaDeMonstros.add(monstro2);
        listaDeMonstros.add(monstro3);

        System.out.println("\nSorteando o monstro que você irá enfrentar");

        prints.ImprimirCarregamento(10);

        int indiceMonstroAleatorio = random.nextInt(listaDeMonstros.size());
        Monstro monstroSorteado = listaDeMonstros.get(indiceMonstroAleatorio);

        System.out.println("\nMonstro sorteado, você enfrentará o " + monstroSorteado.tipo +".\nBoa batalha!");

        CalcularIniciativa(monstroSorteado);
    }

    public static void CalcularIniciativa(Monstro monstroSort)
    {
        System.out.println("\nAgora cada oponente jogará um dado de 10 lados. O que tirar o número maior somado à agilidade, inicia a partida.");
        System.out.println("Os dados estão sendo lançados");
        prints.ImprimirCarregamento(5);

        int dadoInicioHeroi = (random.nextInt(10) + 1) + jogador.getHeroi().agilidade;
        int dadoInicioMonstro = (random.nextInt(10) + 1) + monstroSort.agilidade;

        if(dadoInicioHeroi > dadoInicioMonstro)
        {
            jogador.getHeroi().AtacarOuDefender(jogador.getHeroi(), monstroSort);
        }
        else if(dadoInicioMonstro > dadoInicioHeroi)
        {
            monstroSort.AtacarOuDefender(jogador.getHeroi(), monstroSort);
        }
        else
        {
            System.out.println("Deu empate. Reiniciando sorteio.");
            CalcularIniciativa(monstroSort);
        }
    }
}