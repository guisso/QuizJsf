package io.github.guisso.jakartaee8.quizjsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Luis Guisso <luis.guisso at ifnmg.edu.br>
 */
@Named(value = "fakeDatabase")
@Dependent
public class FakeDatabase
        implements Serializable {

    private static List<Questionario> questionarios;

    @PostConstruct
    public void init() {

        if (questionarios == null) {

            System.out.println(">> FakeDatabase::init()");

            questionarios = new ArrayList<>();
            Questionario questionario;
            Questao questao;

            // -- Questionario 1
            questionario = new Questionario("Jakarta Persistence", "Exercício para verificação de aprendizagem com tema Jakarta Persistence");

            //-- Questão 1
            questao = new Questao("Avalie as afirmativas sobre a anotação @ManyToOne.");

            questao.addAlternativa(new Alternativa("Deve estar do lado UM do relacionamento.", false));
            questao.addAlternativa(new Alternativa("Consta na entidade dominante.", true));
            questao.addAlternativa(new Alternativa("Pode ser omitida se o relacionamento não for bidirecional.", true));

            questionario.addQuestao(questao);

            //-- Questão 2
            questao = new Questao("Sobre a anotação @Id:");

            questao.addAlternativa(new Alternativa("Pode ser inserida em um método getter.", true));
            questao.addAlternativa(new Alternativa("É empregada para referenciar chaves compostas.", false));
            questao.addAlternativa(new Alternativa("Pode conter um parâmetro para indicar a estratégia de como a chave será gerada.", false));
            questao.addAlternativa(new Alternativa("Pode ser utilizada em um atributo do tipo String.", true));

            questionario.addQuestao(questao);

            questionarios.add(questionario);

            // -- Questionario 2
            questionario = new Questionario("Jakarta Server Faces", "Exercício para verificação de aprendizagem com tema Jakarta Server Faces para o desenvolvimento de aplicações Web");

            //-- Questão 1
            questao = new Questao("Em um escopo @Dependent:");

            questao.addAlternativa(new Alternativa("O bean CDI gerenciado tem escopo de vida igual ao da apliação.", false));
            questao.addAlternativa(new Alternativa("O tempo de vida do bean anotado coincide com o tempo de vida do objeto no qual ele é injetado.", true));
            questao.addAlternativa(new Alternativa("Não tem função para versões 2.3 do JSF.", false));
            questao.addAlternativa(new Alternativa("Informa que um atributo de uma entidade não deve ser persistido.", false));

            questionario.addQuestao(questao);

            //-- Questão 2
            questao = new Questao("Analise as afirmações sobre navegação entre páginas JSF.");

            questao.addAlternativa(new Alternativa("Pode ser definida por meio de atributos 'outcome' de tags '<h:link />'.", true));
            questao.addAlternativa(new Alternativa("Pode ser dinâmica, ou seja, pode depender do resultado de avaliações de métodos acionados em atributos 'action' em tags tais como '<h:commandButton />' ou '<h:commandLink />'.", true));
            questao.addAlternativa(new Alternativa("Uma 'view ID' corresponde ao identificador de uma dada página.", true));
            questao.addAlternativa(new Alternativa("Se um 'outcome' não especificar a extensão da página de destino, tal extensão será a mesma da página atual.", true));

            questionario.addQuestao(questao);

            //-- Questão 3
            questao = new Questao("A respeito de templates JSF:");

            questao.addAlternativa(new Alternativa("É obrigatório que todo o conteúdo do cliente esteja contido em uma página XHTML completamente estruturada.", false));
            questao.addAlternativa(new Alternativa("'<ui:define/>' define um ponto que será substituído por um conteúdo do cliente. ", false));
            questao.addAlternativa(new Alternativa("Um template deve conter a anotação '@Template'.", false));
            questao.addAlternativa(new Alternativa("Todo conteúdo do cliente que é externo à tag '<ui:composition>' é ignorado ao ser anexado ao modelo.", true));
            questao.addAlternativa(new Alternativa("A tag '<ui:composition>' pode conter namespaces XML com, dentre outros, a finalidade de auxiliar a IDE a gerar assistência de autocomplemento ao desenvolvedor.", true));

            questionario.addQuestao(questao);

            questionarios.add(questionario);
        }

    }

    public List<Questionario> findAllQuestionarios() {
        return questionarios;
    }
    
    public Questionario findQuestionarioByCodigo(Long codigo) {
        return questionarios
                .stream()
                .filter(p -> p.getCodigo().equals(codigo))
                .findAny()
                .orElse(null);
    }

    public Questao findQuestaoById(Integer questionarioId, Long codigo) {
        List<Questao> questoes = questionarios
                .get(questionarioId).getQuestoes();
        return questoes
                .stream()
                .filter(q -> q.getCodigo().equals(codigo))
                .findAny()
                .orElse(null);
    }

}
