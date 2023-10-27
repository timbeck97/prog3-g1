package jogodavelha;

import java.util.Scanner;

/**
 *
 * @author Tim
 */
public class Jogador implements IJogador {
    private String nome;
    private ETipoPosicao tipoPosicao;


    private Scanner scanner;

    public Jogador(String nome, ETipoPosicao tipoPosicao ) {
        this.nome = nome;
        this.tipoPosicao = tipoPosicao;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int getMovimento(Tabuleiro tabuleiro) {
        int posicao;
        System.out.println(nome+" digite a posição: ");
        posicao = this.scanner.nextInt();
        while(!tabuleiro.isPosicaoValida(posicao)){
            System.out.println("Posição inválida, digite novamente: ");
            posicao = this.scanner.nextInt();
        }
        return posicao;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public boolean isComputador() {
        return false;
    }

    @Override
    public ETipoPosicao getTipoPosicao() {
        return tipoPosicao;
    }


}
