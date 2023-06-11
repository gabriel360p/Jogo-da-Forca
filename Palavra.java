public class Palavra{
    private String palavra;
    private String dica;

    public Palavra() {
    }

    public Palavra(String palavra, String dica) {
        this.palavra = palavra;
        this.dica = dica;
    }

    public String getPalavra() {
        return this.palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public String getDica() {
        return this.dica;
    }

    public void setDica(String dica) {
        this.dica = dica;
    }
    
} 