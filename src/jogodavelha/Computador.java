package jogodavelha;

public class Computador implements IJogador {


    private ETipoPosicao posicao;

    public Computador(ETipoPosicao posicao) {
        this.posicao = posicao;
    }

    @Override
    public int getMovimento(Tabuleiro tab) {
        ETipoPosicao[][] tabuleiro = tab.getTabuleiro();

        ETipoPosicao oponente=posicao.equals(ETipoPosicao.O)?ETipoPosicao.X:ETipoPosicao.O;

        // tenta ganhar
        for (int i = 1; i <= 9; i++) {
            int[] pos = Tabuleiro.getPosicao(i);
            int linha = pos[0];
            int coluna = pos[1];

            if (tabuleiro[linha][coluna] == ETipoPosicao.VAZIO) {
                // Simule uma jogada
                tabuleiro[linha][coluna] = posicao;

                if (tab.isVencedor(posicao)) {
                    // desfaz simulacao e retorna posicao
                    tabuleiro[linha][coluna] = ETipoPosicao.VAZIO;
                    return i;
                }

                tabuleiro[linha][coluna] = ETipoPosicao.VAZIO; // Desfaça a simulação
            }
        }

        // tenta bloquer o oponente de ganhar
        for (int i = 1; i <= 9; i++) {
            int[] pos = Tabuleiro.getPosicao(i);
            int linha = pos[0];
            int coluna = pos[1];

            if (tabuleiro[linha][coluna] == ETipoPosicao.VAZIO) {
                // Simule uma jogada para verificar se o jogador ganharia
                tabuleiro[linha][coluna] = oponente;

                if (tab.isVencedor(oponente)) {
                    // desfaz simulacao e retorna posicao
                    tabuleiro[linha][coluna] = posicao;
                    return i;
                }
                // Desfaça a simulação
                tabuleiro[linha][coluna] = ETipoPosicao.VAZIO;
            }
        }


        //gera aleatorio
        int posicaoComputador = (int) (Math.random() * 9);
        int linha = Tabuleiro.getPosicao(posicaoComputador)[0];
        int coluna = Tabuleiro.getPosicao(posicaoComputador)[1];
        while(tabuleiro[linha][coluna] != ETipoPosicao.VAZIO){
            posicaoComputador = (int) (Math.random() * 9);
            linha = Tabuleiro.getPosicao(posicaoComputador)[0];
            coluna = Tabuleiro.getPosicao(posicaoComputador)[1];
        }

        return posicaoComputador;
    }
    @Override
    public String getNome() {
        return "Computador";
    }

    @Override
    public boolean isComputador() {
        return true;
    }
    @Override
    public ETipoPosicao getTipoPosicao() {
        return posicao;
    }
}
