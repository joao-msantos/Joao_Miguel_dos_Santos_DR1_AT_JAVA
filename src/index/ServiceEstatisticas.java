package index;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.*;

public class ServiceEstatisticas {

    public static long calcularNumeroTotalPartidas(List<EstatisticasJogo> estatisticasJogos) {
        return estatisticasJogos.size();
    }
    public static String encontrarHeroiMaisJogado(List<EstatisticasJogo> estatisticasJogos) {
        Map<String, Long> contagemHerois = estatisticasJogos.stream()
                .collect(Collectors.groupingBy(EstatisticasJogo::getHeroiEscolhido, Collectors.counting()));

        String heroiMaisJogado = contagemHerois.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        return heroiMaisJogado;
    }
    public static String encontrarMonstroMaisEnfrentado(List<EstatisticasJogo> estatisticasJogos) {
        Map<String, Long> contagemMonstros = estatisticasJogos.stream()
                .collect(Collectors.groupingBy(EstatisticasJogo::getMonstroEnfrentado, Collectors.counting()));

        Optional<Map.Entry<String, Long>> monstroMaisEnfrentado = contagemMonstros.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        if (monstroMaisEnfrentado.isPresent()) {
            return monstroMaisEnfrentado.get().getKey();
        } else {
            return "Nenhum monstro enfrentado ainda";
        }
    }
    public static int encontrarRodadaMaisLonga(List<EstatisticasJogo> estatisticasJogos) {
        Optional<Integer> rodadaMaisLonga = estatisticasJogos.stream()
                .map(EstatisticasJogo::getQuantRodadas)
                .max(Integer::compare);

        return rodadaMaisLonga.orElse(0);
    }

    public static double calcularRazaoVitoriasDerrotas(List<EstatisticasJogo> estatisticasJogos) {
        long vitorias = estatisticasJogos.stream()
                .filter(e -> e.getResultado().equals("GANHOU"))
                .count();

        long derrotas = estatisticasJogos.stream()
                .filter(e -> e.getResultado().equals("PERDEU"))
                .count();

        if (derrotas == 0) {
            return vitorias;
        }  else{
            return (double) vitorias / derrotas;
        }
    }

    public static int calcularPontuacaoTotal(List<EstatisticasJogo> estatisticasJogos) {
        int pontuacao = 0;

        for (EstatisticasJogo jogo : estatisticasJogos) {
            if (jogo.getResultado().equalsIgnoreCase("GANHOU")) {
                pontuacao += 100;
            } else if (jogo.getResultado().equalsIgnoreCase("PERDEU")) {
                pontuacao -= 50;
            }
        }

        return pontuacao;
    }

    public static long numeroVitorias(List<EstatisticasJogo> estatisticasJogos)
    {
        long vitorias = estatisticasJogos.stream()
                .filter(e -> e.getResultado().equals("GANHOU"))
                .count();

        return vitorias;
    }

    public static long numeroDerrotas(List<EstatisticasJogo> estatisticasJogos)
    {
        long derrotas = estatisticasJogos.stream()
                .filter(e -> e.getResultado().equals("PERDEU"))
                .count();

        return derrotas;
    }
}
