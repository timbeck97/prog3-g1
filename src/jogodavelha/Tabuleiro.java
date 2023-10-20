package jogodavelha;

import java.util.Arrays;

/**
 *
 * @author Tim
 */
public class Tabuleiro {
    private ETipoPosicao[][] tabuleiro;

    public Tabuleiro() {
        this.tabuleiro = new ETipoPosicao[3][3];
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3 ; coluna++) {
                this.tabuleiro[linha][coluna] = ETipoPosicao.VAZIO;
            }
        }

    }
    public boolean isPosicaoValida(int posicao){
        if(posicao< 1 || posicao > 9){
            return false;
        }
        int[] posicoes= getPosicao(posicao);
        int linha = posicoes[0];
        int coluna = posicoes[1];
        return this.tabuleiro[linha][coluna] == ETipoPosicao.VAZIO;
    }
    public void setPosicao(int posicao, ETipoPosicao tipoPosicao) {
        int[] posicoes= getPosicao(posicao);
        int linha = posicoes[0];
        int coluna = posicoes[1];
        if(this.tabuleiro[linha][coluna] == ETipoPosicao.VAZIO){
            this.tabuleiro[linha][coluna] = tipoPosicao;

        }
    }


    public boolean isCompleto() {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3 ; coluna++) {
                if(this.tabuleiro[linha][coluna] == ETipoPosicao.VAZIO){
                    return false;
                }
            }
        }
        return true;
    }

    public int getPosicaoComputador(){
        int posicaoComputador = (int) (Math.random() * 9);
        int linha = getPosicao(posicaoComputador)[0];
        int coluna = getPosicao(posicaoComputador)[1];
        while(this.tabuleiro[linha][coluna] != ETipoPosicao.VAZIO){
            posicaoComputador = (int) (Math.random() * 9);
            linha = getPosicao(posicaoComputador)[0];
            coluna = getPosicao(posicaoComputador)[1];
        }
        return posicaoComputador;

    }
    public boolean isVencedor(ETipoPosicao tipoPosicao) {
        for (int linha = 0; linha < 3; linha++) {
            if (this.tabuleiro[linha][0] == tipoPosicao &&
                    this.tabuleiro[linha][1] == tipoPosicao &&
                    this.tabuleiro[linha][2] == tipoPosicao) {
                return true;
            }
        }

        // Verifica se há vencedor nas colunas
        for (int coluna = 0; coluna < 3; coluna++) {
            if (this.tabuleiro[0][coluna] == tipoPosicao &&
                    this.tabuleiro[1][coluna] == tipoPosicao &&
                    this.tabuleiro[2][coluna] == tipoPosicao) {
                return true;
            }
        }

        // Verifica se há vencedor na diagonal principal
        if (this.tabuleiro[0][0] == tipoPosicao &&
                this.tabuleiro[1][1] == tipoPosicao &&
                this.tabuleiro[2][2] == tipoPosicao) {
            return true;
        }

        // Verifica se há vencedor na diagonal secundária
        if (this.tabuleiro[0][2] == tipoPosicao &&
                this.tabuleiro[1][1] == tipoPosicao &&
                this.tabuleiro[2][0] == tipoPosicao) {
            return true;
        }
        return false;
    }
    public void printTabuleiro(){
        for (int linha = 0; linha < 3; linha++) {
            System.out.println("-------------");
            for (int coluna = 0; coluna < 3; coluna++) {
                System.out.print("| ");
                if(this.tabuleiro[linha][coluna] == ETipoPosicao.VAZIO){
                    System.out.print("  ");
                }else{
                    System.out.print(this.tabuleiro[linha][coluna] + " ");
                }
            }
            System.out.println("|");
        }
        System.out.println("-------------");
    }
    private int[] getPosicao(int posicao){
        int linha, coluna;
        switch (posicao){
            case 1:
                linha = 0;
                coluna = 0;
                break;
            case 2:
                linha = 0;
                coluna = 1;
                break;
            case 3:
                linha = 0;
                coluna = 2;
                break;
            case 4:
                linha = 1;
                coluna = 0;
                break;
            case 5:
                linha = 1;
                coluna = 1;
                break;
            case 6:
                linha = 1;
                coluna = 2;
                break;
            case 7:
                linha = 2;
                coluna=0;
                break;
            case 8:
                linha=2;
                coluna=1;
                break;
            case 9:
                linha=2;
                coluna=2;
                break;
            default:
                linha = 0;
                coluna = 0;
                break;
        }
        //int linha = (numero - 1) / 3;
        //int coluna = (numero - 1) % 3;
        return new int[]{linha, coluna};
    }
    @Override
    public String toString() {
        return "Tabuleiro{" +
                "tabuleiro=" + Arrays.toString(tabuleiro) +
                '}';
    }
}
