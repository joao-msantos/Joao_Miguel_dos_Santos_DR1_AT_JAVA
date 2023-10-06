package index;

public class EstatisticasJogo {
    private String dataPartida;
    private String heroiEscolhido;
    private String resultado;
    private String monstroEnfrentado;
    private int quantRodadas;

    public EstatisticasJogo(String dataPartida, String heroiEscolhido, String resultado, String monstroEnfrentado, int quantRodadas) {
        this.dataPartida = dataPartida;
        this.heroiEscolhido = heroiEscolhido;
        this.resultado = resultado;
        this.monstroEnfrentado = monstroEnfrentado;
        this.quantRodadas = quantRodadas;
    }

    @Override
    public String toString() {
        return "DadosPartida{" +
                "dataPartida='" + dataPartida + '\'' +
                ", heroiEscolhido='" + heroiEscolhido + '\'' +
                ", resultado='" + resultado + '\'' +
                ", monstroEnfrentado='" + monstroEnfrentado + '\'' +
                ", quantRodadas=" + quantRodadas +
                '}';
    }

    public String getResultado() {
        return this.resultado;
    }

    public String getHeroiEscolhido() {
        return this.heroiEscolhido;
    }

    public String getMonstroEnfrentado() {
        return this.monstroEnfrentado;
    }

    public int getQuantRodadas() {
        return this.quantRodadas;
    }
}
