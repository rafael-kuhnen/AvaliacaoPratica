public class Documento {
    
    String titulo;
    String descricao;

    public Documento(String titulo, String descricao) {
        setTitulo(titulo);
        setDescricao(descricao);
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) throws IllegalArgumentException {
        if (titulo == null || titulo.trim().isEmpty()) throw new IllegalArgumentException("Título não pode ser vazio ou nulo");
        
        this.titulo = titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
