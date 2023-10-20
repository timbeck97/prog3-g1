package jogodavelha;

/**
 *
 * @author Tim
 */
public class Jogador {
    private String nome;
    private ETipoPosicao tipoPosicao;

    private boolean isComputador;

    public Jogador(String nome, ETipoPosicao tipoPosicao, boolean isComputador) {
        this.nome = nome;
        this.tipoPosicao = tipoPosicao;
        this.isComputador = isComputador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ETipoPosicao getTipoPosicao() {
        return tipoPosicao;
    }

    public void setTipoPosicao(ETipoPosicao tipoPosicao) {
        this.tipoPosicao = tipoPosicao;
    }

    public boolean isComputador() {
        return isComputador;
    }

    public void setComputador(boolean computador) {
        isComputador = computador;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", tipoPosicao=" + tipoPosicao +
                ", isComputador=" + isComputador +
                '}';
    }
}
