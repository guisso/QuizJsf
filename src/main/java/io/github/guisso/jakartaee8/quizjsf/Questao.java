package io.github.guisso.jakartaee8.quizjsf;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Representação da entidade Questão
 * @author Luis Guisso <luis.guisso at ifnmg.edu.br>
 */
public class Questao {

    private static Long id = 0L;

    private Long codigo;
    private String enunciado;
    private List<Alternativa> alternativas;

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

    public List<Alternativa> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Questao() {
        codigo = ++id;
        alternativas = new ArrayList<>();
    }

    public Questao(String enunciado) {
        this();
        this.enunciado = enunciado;
    }
    //</editor-fold>

    public void addAlternativa(Alternativa alternativa) {
        this.alternativas.add(alternativa);
    }

    public Integer calcularAcertos() {
return (int) alternativas
        .stream()
        .filter(a -> a.isRespotaCorreta())
        .count();
    }

    //<editor-fold defaultstate="collapsed" desc="hashCode/equals/toString">
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.codigo);
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
        final Questao other = (Questao) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

    @Override
    public String toString() {
        return enunciado;
    }
    //</editor-fold>

}
