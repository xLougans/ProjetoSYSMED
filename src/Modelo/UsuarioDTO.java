package Modelo;

public class UsuarioDTO {
    
    private Integer userCod, userRg;
    private String userNome, userUsuario, userEmail, userTipo, userSenha, userSenha2;
    private String pesquisa;

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }
    
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserUsuario() {
        return userUsuario;
    }

    public void setUserUsuario(String userUsuario) {
        this.userUsuario = userUsuario;
    }

    public Integer getUserCod() {
        return userCod;
    }

    public void setUserCod(Integer userCod) {
        this.userCod = userCod;
    }

    public Integer getUserRg() {
        return userRg;
    }

    public void setUserRg(Integer userRg) {
        this.userRg = userRg;
    }

    public String getUserNome() {
        return userNome;
    }

    public void setUserNome(String userNome) {
        this.userNome = userNome;
    }

    public String getUserTipo() {
        return userTipo;
    }

    public void setUserTipo(String userTipo) {
        this.userTipo = userTipo;
    }

    public String getUserSenha() {
        return userSenha;
    }

    public void setUserSenha(String userSenha) {
        this.userSenha = userSenha;
    }

    public String getUserSenha2() {
        return userSenha2;
    }

    public void setUserSenha2(String userSenha2) {
        this.userSenha2 = userSenha2;
    }
    
}
