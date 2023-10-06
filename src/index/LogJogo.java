package index;

import Personagens.Heroi;
import Personagens.Monstro;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.File;

public abstract class LogJogo {
    public static void gravarArquivo(Heroi heroiEscolhido, String resultado, Monstro monstroEntfrentado, int quantRodadas){
        String diretorio = "src/index/temp/";
        String nomeArquivo = diretorio + Jogador.nickName + ".csv";

        Date dataPartida = new Date();
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        try {
            File arquivo = new File(nomeArquivo);

            if (!arquivo.exists()) {
                if (arquivo.createNewFile()) {
                    System.out.println("O arquivo de LOG foi criado com sucesso.");
                    BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true));

                    writer.write("Data da Partida;Heroi escolhido;Resultado;Monstro enfrentado;Quantidade de Rodadas");
                    String linha = dataFormatada.format(dataPartida) + ";" + heroiEscolhido.tipo + ";" + resultado + ";"
                            + monstroEntfrentado.tipo + ";" + quantRodadas;
                    writer.newLine();
                    writer.write(linha);
                    writer.newLine();
                    writer.close();
                } else {
                    System.out.println("Não foi possível criar o arquivo de LOG.");
                }
            } else {
                System.out.println("O LOG foi gravado com sucesso no seu arquivo.csv");
                BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true));
                String linha = dataFormatada.format(dataPartida) + ";" + heroiEscolhido.tipo + ";" + resultado + ";"
                        + monstroEntfrentado.tipo + ";" + quantRodadas;
                writer.write(linha);
                writer.newLine();
                writer.close();
            }
        } catch (IOException e) {
            System.err.println("Erro ao gravar dados no arquivo de LOG.csv: " + e.getMessage());
        }
        }
    }

