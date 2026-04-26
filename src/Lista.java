public class Lista {
    private NoLista inicio;
    private NoLista fim;

    public Lista() {
        this.inicio = null;
        this.fim = null;
    }

    public void adicionar(String linha) {
        NoLista novoNo = new NoLista(linha);
        if (estaVazia()) {
            inicio = novoNo;
        } else {
            fim.setProximo(novoNo);
            novoNo.setAnterior(fim);
        }
        fim = novoNo;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public NoLista getFim() {
        return fim;
    }
}