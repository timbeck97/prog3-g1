package jogodavelha;

import java.util.Scanner;

/**
 *
 * @author Tim
 */
public class Jogo {

    private Jogador jogador1;
    private Jogador jogador2;
    private Tabuleiro tabuleiro;
    private Scanner scanner;

    private boolean turno=true;


    public void inicia(){
        this.scanner = new Scanner(System.in);
        this.tabuleiro = new Tabuleiro();
        this.defineJogadores();
        tabuleiro.printTabuleiro();
        this.jogar();
    }

public void jogar(){
    while(true){
        Jogador jogador= getJogadorDaVez();
        int posicao;
        if(jogador.isComputador()){
            posicao=tabuleiro.getPosicaoComputador();
            System.out.println(getNomeJogadorDaVez()+" selecionou a posição: "+posicao);
        }else{
            System.out.println(getNomeJogadorDaVez()+" digite a posição: ");
            posicao = this.scanner.nextInt();
            while(!tabuleiro.isPosicaoValida(posicao)){
                System.out.println("Posição inválida, digite novamente: ");
                posicao = this.scanner.nextInt();
            }
        }
        tabuleiro.setPosicao(posicao, jogador.getTipoPosicao());
        if(this.tabuleiro.isVencedor(jogador.getTipoPosicao())){
            this.tabuleiro.printTabuleiro();
            System.out.println(getNomeJogadorDaVez()+" venceu!");
            break;
        }
        if(this.tabuleiro.isCompleto()){
            this.tabuleiro.printTabuleiro();
            System.out.println("Empatou!");
            break;
        }
        turno=!turno;
        this.tabuleiro.printTabuleiro();
    }
}

    public void defineJogadores(){
        System.out.println("Digite o nome do jogador 1: ");
        String nome = this.scanner.nextLine();
        System.out.println("Digite o tipo de jogador 1 (X, O): ");
        ETipoPosicao tipoPosicao = ETipoPosicao.valueOf(this.scanner.nextLine().toUpperCase());
        this.jogador1 = new Jogador(nome, tipoPosicao, false);
        System.out.print("Jogador 2 será o computador (s, n):  ");
        boolean isComputador= this.scanner.nextLine().equalsIgnoreCase("s");
        ETipoPosicao p2=tipoPosicao.equals(ETipoPosicao.X)?ETipoPosicao.O:ETipoPosicao.X;
        String nomeJogador2;
        if(!isComputador){
            System.out.println("Digite o nome do jogador 2: ");
            nomeJogador2 = this.scanner.nextLine();
        }else{
            nomeJogador2="Computador";
        }
        this.jogador2 = new Jogador(nomeJogador2, p2, isComputador);
    }
    private String getNomeJogadorDaVez(){
        return getJogadorDaVez().getNome();
    }
    private Jogador getJogadorDaVez(){
        return turno?jogador1:jogador2;
    }


}
