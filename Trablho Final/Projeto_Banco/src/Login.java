import java.util.ArrayList;

public class Login {
    public String usuario, senha;

    public boolean autentica(String usuario, String senha){
        return this.usuario.equals(usuario) && this.senha.equals(senha);
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }
}
