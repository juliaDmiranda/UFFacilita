package model.contato;

public class Contato {
    private String tipo, nome, email, telefone;

    public Contato(String tipo, String nome, String email, String telefone) {
        this.tipo = tipo;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }
}
