public class NoLista {
    private String linha;
    private NoLista proximo;
    private NoLista anterior;

    public NoLista(String linha) {
        this.linha = linha;
        this.proximo = null;
        this.anterior = null;
    }

    public String getLinha() {
        return linha;
    }

    public NoLista getProximo() {
        return proximo;
    }

    public void setProximo(NoLista proximo) {
        this.proximo = proximo;
    }

    public NoLista getAnterior() {
        return anterior;
    }

    public void setAnterior(NoLista anterior) {
        this.anterior = anterior;
    }
}