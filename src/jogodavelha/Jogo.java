package jogodavelha;

import java.util.Scanner;

/**
 *
 * @author Tim
 */
public class Jogo {

    private IJogador jogador1;
    private IJogador jogador2;
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
        IJogador jogador= getJogadorDaVez();
        int posicao=jogador.getMovimento(tabuleiro);
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
        jogador1 = new Jogador(nome, tipoPosicao);
        System.out.print("Jogador 2 será o computador (s, n):  ");
        boolean isComputador= this.scanner.nextLine().equalsIgnoreCase("s");
        ETipoPosicao p2=tipoPosicao.equals(ETipoPosicao.X)?ETipoPosicao.O:ETipoPosicao.X;
        if(!isComputador){
            String nomeJogador2;
            System.out.println("Digite o nome do jogador 2: ");
            nomeJogador2 = this.scanner.nextLine();
            jogador2=new Jogador(nomeJogador2, tipoPosicao);
        }else{
            jogador2 = new Computador(p2);
        }

    }
    private String getNomeJogadorDaVez(){
        return getJogadorDaVez().getNome();
    }
    private IJogador getJogadorDaVez(){
        return turno?jogador1:jogador2;
    }


}
