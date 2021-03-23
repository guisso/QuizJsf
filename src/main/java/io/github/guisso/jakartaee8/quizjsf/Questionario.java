package io.github.guisso.jakartaee8.quizjsf;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Representação da entidade Questionário
 *
 * @author Luis Guisso <luis.guisso at ifnmg.edu.br>
 */
public class Questionario {

    private static Long id = 0L;

    private Long codigo;
    private String nome;
    private String descricao;
    private List<Questao> questoes;

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
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

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Questionario() {
        codigo = ++id;
        questoes = new ArrayList<>();
    }

    public Questionario(String nome, String descricao) {
        this();
        this.nome = nome;
        this.descricao = descricao;
    }
    //</editor-fold>

    public void addQuestao(Questao questao) {
        this.questoes.add(questao);
    }
    
    public Integer getTotalQuestoes() {
        return questoes.size();
    }
    
    public Integer calcularTotal() {
return questoes
        .stream()
        .mapToInt(q -> q.calcularAcertos())
        .sum();
    }

    //<editor-fold defaultstate="collapsed" desc="hashCode/equals/toString">
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codigo);
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
        final Questionario other = (Questionario) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

    @Override
    public String toString() {
        return nome;
    }
    //</editor-fold>

}
