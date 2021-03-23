package io.github.guisso.jakartaee8.quizjsf;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author Luis Guisso <luis.guisso at ifnmg.edu.br>
 */
@Named
@SessionScoped
public class QuestionarioControllerBean
        implements Serializable {

    // FakeDatabase é injetado neste objeto e,
    // portanto, anexado à sessão porque seu ciclo
    // de vida é @Dependent
    @Inject
    private FakeDatabase fakeDatabase;

    private Long questionarioSelecionadoId;
    private Questionario questionarioSelecionado;

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public FakeDatabase getFakeDatabase() {
        return fakeDatabase;
    }

    public Long getQuestionarioSelecionadoId() {
        return questionarioSelecionadoId;
    }

    // Seleção do questionário recebido como parâmetro via 
    // URL e associação por meio das tags <f:metadata/> 
    // e <f:viewParam/>
    public void setQuestionarioSelecionadoId(Long questionarioSelecionadoId) {
        questionarioSelecionado = fakeDatabase.findQuestionarioByCodigo(questionarioSelecionadoId);
        System.out.println("\r>> Questionario selecionado: "
                + questionarioSelecionado.getNome());
        this.questionarioSelecionadoId = questionarioSelecionadoId;
    }

    public Questionario getQuestionarioSelecionado() {
        return questionarioSelecionado;
    }

    public void setQuestionarioSelecionado(Questionario questionarioSelecionado) {
        this.questionarioSelecionado = questionarioSelecionado;
    }
    //</editor-fold>    

    public Character toChar(int idx) {
        return (char) ('a' + idx);
    }
    
}
