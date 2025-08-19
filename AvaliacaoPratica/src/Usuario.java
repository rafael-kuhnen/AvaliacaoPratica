public class Usuario {
    
    private String nome;
    private String email;
    private String senha;
    private Perfil perfil;

    public Usuario(String nome, String email, String senha, Perfil perfil) {
        setNome(nome);
        setEmail(email);
        setSenha(senha);
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) throws IllegalArgumentException {
        if (nome == null || nome.trim().isEmpty()) throw new IllegalArgumentException("Nome não pode ser vazio ou nulo");
        
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) throws IllegalArgumentException {
        if (email == null || email.trim().isEmpty()) throw new IllegalArgumentException("Email não pode ser vazio ou nulo");
        if (!email.contains("@")) throw new IllegalArgumentException("Email deve conter '@'");
        if (!email.contains(".")) throw new IllegalArgumentException("Email deve conter '.'");

        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) throws IllegalArgumentException {
        if (senha == null || senha.trim().isEmpty()) throw new IllegalArgumentException("Senha não pode ser vazia ou nula");

        this.senha = senha;
    }

    public Perfil getPerfil() {
        return perfil;
    }
    public void setPerfil(Perfil perfil) {
        if (perfil == null) throw new IllegalArgumentException("Perfil não pode ser nulo");
        
        this.perfil = perfil;
    }

    

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", perfil=" + perfil +
                '}';
    }

    
}
