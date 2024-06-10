public class Tag {
    private String nome;
    private String descricao;
    private String cor;

    public Tag(String nome, String descricao, String cor) {
        this.nome = nome;
        this.descricao = descricao;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
