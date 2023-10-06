package index;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Relatorio {
    public void procurarLog(String nomeArquivo)
    {
        String nomeTratado = nomeArquivo + ".csv";
        String pasta = "src/index/temp/";

        File diretorio = new File(pasta);
        if (diretorio.exists() && diretorio.isDirectory()) {
            File[] arquivos = diretorio.listFiles();

            boolean arquivoEncontrado = false;
            if (arquivos != null) {

                for (File arquivo : arquivos) {
                    if (arquivo.getName().equals(nomeTratado)) {
                        System.out.println("Arquivo encontrado: " + arquivo.getAbsolutePath());
                        LerArquivo(pasta + nomeTratado);
                        arquivoEncontrado = true;
                        break;
                    }
                }
            }

            if (!arquivoEncontrado) {
                System.out.println("Arquivo não encontrado. Verifique o nome e tente novamente.");
            }
        } else {
            System.out.println("A pasta não existe ou não é um diretório válido.");
        }
    }

    public void LerArquivo(String arquivo) {

        List<EstatisticasJogo> listaDadosPartida = new ArrayList<>();

        boolean primeiraLinha = true;
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {

            String linha;
            while ((linha = br.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }
                String[] campos = linha.split(";");
                if (campos.length == 5) {
                    String dataPartida = campos[0].trim();
                    String heroiEscolhido = campos[1].trim();
                    String resultado = campos[2].trim();
                    String monstroEnfrentado = campos[3].trim();
                    int quantRodadas = Integer.parseInt(campos[4].trim());

                    EstatisticasJogo estatisticasJogo = new EstatisticasJogo(dataPartida, heroiEscolhido, resultado, monstroEnfrentado, quantRodadas);
                    listaDadosPartida.add(estatisticasJogo);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nNúmero de partidas: " + ServiceEstatisticas.calcularNumeroTotalPartidas(listaDadosPartida));
        System.out.println("Número de vitórias: " + ServiceEstatisticas.numeroVitorias(listaDadosPartida));
        System.out.println("Número de derrotas: " +ServiceEstatisticas.numeroDerrotas(listaDadosPartida));
        System.out.println("Pontuação final (vitória soma 100 pontos e derrota diminui 50 pontos): " + ServiceEstatisticas.calcularPontuacaoTotal(listaDadosPartida) +" pontos");
        System.out.println("Jogador preferido: "+ServiceEstatisticas.encontrarHeroiMaisJogado(listaDadosPartida));
        System.out.println("Monstro mais enfrentado: "+ServiceEstatisticas.encontrarMonstroMaisEnfrentado(listaDadosPartida));
        System.out.println("Rodada mais longa: "+ServiceEstatisticas.encontrarRodadaMaisLonga(listaDadosPartida));
        System.out.println("Razão entre win/lose: "+ServiceEstatisticas.calcularRazaoVitoriasDerrotas(listaDadosPartida));


    }
}

