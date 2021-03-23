package io.github.guisso.jakartaee8.quizjsf;

import java.util.Objects;

/**
 * Representação da entidade Alternativa
 * @author Luis Guisso <luis.guisso at ifnmg.edu.br>
 */
public class Alternativa {

    private static Long id = 0L;

    private Long codigo;
    private String enunciado;
    private Boolean correta;
    private Boolean resposta;

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public Boolean getCorreta() {
        return correta;
    }

    public void setCorreta(Boolean correta) {
        this.correta = correta;
    }

    public Boolean getResposta() {
        return resposta;
    }

    public void setResposta(Boolean resposta) {
        System.out.println("\r>> Alternativa: "
                + enunciado
                + "\r == " + resposta);
        this.resposta = resposta;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Alternativa() {
        codigo = ++id;

        // Lembrete: objeto Long não inicializado
        // this.resposta = null;
    }

    public Alternativa(String enunciado, Boolean correta) {
        this();
        this.enunciado = enunciado;
        this.correta = correta;
    }
    //</editor-fold>

    public Boolean isRespotaCorreta() {
        return resposta == null
                ? false 
                : resposta.equals(correta);
    }
    
    public String getIconeCorrecao() {
        if(isRespotaCorreta()) {
            return "<i style=\"color:green;\" class=\"fas fa-check-circle\"></i>";
        } else {
            return "<i style=\"color:red;\" class=\"fas fa-times-circle\"></i>";
        }
    }
    
    //<editor-fold defaultstate="collapsed" desc="hashCode/equals/toString">
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alternativa other = (Alternativa) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

    @Override
    public String toString() {
        return enunciado;
    }
    //</editor-fold>

}
