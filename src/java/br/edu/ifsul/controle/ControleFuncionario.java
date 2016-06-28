package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CidadeDAO;
import br.edu.ifsul.dao.FilialDAO;
import br.edu.ifsul.dao.FuncionarioDAO;
import br.edu.ifsul.dao.UsuarioDAO;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Filial;
import br.edu.ifsul.modelo.Funcionario;
import br.edu.ifsul.modelo.Telefone;
import br.edu.ifsul.modelo.Usuario;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @daniel
 */
@ManagedBean(name = "controleFuncionario")
@ViewScoped
public class ControleFuncionario implements Serializable {

    private FuncionarioDAO<Funcionario> dao;
    private Funcionario objeto;
    private CidadeDAO<Cidade> daoCidade;
    private Telefone telefone;
    private FilialDAO<Filial> daoFilial;
    private Boolean novoTelefone;

    public ControleFuncionario() {
        dao = new FuncionarioDAO<>();
        daoCidade = new CidadeDAO<>();
        daoFilial = new FilialDAO<>();
    }
    


    public String listar() {
        return "/privado/funcionario/listar?faces-redirect=true";
    }

    public void novo() {
        setObjeto(new Funcionario());
        
    }

    public void salvar() {
        try {
            if (getObjeto().getId() == null) {
                getDao().persist(getObjeto());
            } else {
                getDao().merge(getObjeto());
            }
            Util.mensagemInformacao("Objeto persistido com sucesso");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao persistir: " + e.getMessage());
        }
    }

    public void editar(Integer id) {
        try {
            setObjeto(getDao().localizar(id));
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar obejto: " + e.getMessage());
        }
    }

    public void remover(Integer id) {
        try {
            setObjeto(getDao().localizar(id));
            getDao().remover(getObjeto());
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e) {
            Util.mensagemErro("Erro a remover objeto: " + e.getMessage());
        }
    }

    public void novoTelefone() {
        setTelefone(new Telefone());
        setNovoTelefone((Boolean) true);
    }

    public void alterarTelefone(int index) {
        setTelefone(getObjeto().getTelefones().get(index));
        setNovoTelefone((Boolean) false);
    }

    public void salvarNumeroTelefone() {
        if (getNovoTelefone()) {
            getObjeto().adicionarTelefone(getTelefone());
        } else {
            Util.mensagemInformacao("Não foi possivel salvar ");
        }
        Util.mensagemInformacao("Operação realizada com sucesso");
    }

    public void atualizaNumeroTelefone() {
        if (getTelefone() != null) {
            if (getTelefone().getNumero()!= null) {
                getTelefone().setNumero(getTelefone().getNumero());
            }
        }
    }

    

    public void removerTelefone(int index) {
        getObjeto().removertelefone(index);
        Util.mensagemInformacao("Item removido com sucesso");
    }

    public FuncionarioDAO<Funcionario> getDao() {
        return dao;
    }

    public void setDao(FuncionarioDAO<Funcionario> dao) {
        this.dao = dao;
    }

    public Funcionario getObjeto() {
        return objeto;
    }

    public void setObjeto(Funcionario objeto) {
        this.objeto = objeto;
    }

    public CidadeDAO<Cidade> getDaoCidade() {
        return daoCidade;
    }

    public void setDaoCidade(CidadeDAO<Cidade> daoCidade) {
        this.daoCidade = daoCidade;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public Boolean getNovoTelefone() {
        return novoTelefone;
    }

    public void setNovoTelefone(Boolean novoTelefone) {
        this.novoTelefone = novoTelefone;
    }

    public FilialDAO<Filial> getDaoFilial() {
        return daoFilial;
    }

    public void setDaoFilial(FilialDAO<Filial> daoFilial) {
        this.daoFilial = daoFilial;
    }

    

    

    

}
