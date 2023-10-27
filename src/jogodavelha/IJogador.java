package jogodavelha;

public interface IJogador {

    public int getMovimento(Tabuleiro tabuleiro);

    public String getNome();

    public boolean isComputador();

    public ETipoPosicao getTipoPosicao();
}
