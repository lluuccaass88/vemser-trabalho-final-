package src.logistica.model;

public class Usuario {
    private Integer id;
    private String nome;
    private String usuario;
    private String senha;
    private Perfil perfil; // 1 - Colaborador, 2 - Motorista
    private String cpf;
    private String cnh;

    public Usuario() {
    }

    public Usuario(Integer id, String nome, String usuario, String senha, Perfil perfil, String cpf, String cnh) {
        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.perfil = perfil; // 1 - Colaborador, 2 - Motorista
        this.cpf = cpf;
        this.cnh = cnh;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", usuario='" + usuario + '\'' +
                ", senha='" + senha + '\'' +
                ", perfil=" + perfil +
                ", cpf='" + cpf + '\'' +
                ", cnh='" + cnh + '\'' +
                '}';
    }
}