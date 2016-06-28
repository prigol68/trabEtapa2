package br.edu.ifsul.controle;

import br.edu.ifsul.dao.FuncionarioDAO;
import br.edu.ifsul.dao.SetorDAO;
import br.edu.ifsul.modelo.Funcionario;
import br.edu.ifsul.modelo.Setor;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @daniel
 */
@ManagedBean(name = "controleSetor")
@ViewScoped
public class ControleSetor implements Serializable {

    private SetorDAO<Setor> dao;
    private Setor objeto;
   
    private FuncionarioDAO<Funcionario> daoFuncionario;
    private Funcionario funcionario;

    public ControleSetor() {
        dao = new SetorDAO<>();
        daoFuncionario = new FuncionarioDAO<>();
    }
    
    public void adicionarAtuacoes(){
        if (getFuncionario() != null){
            if(!objeto.getAtuam().contains(funcionario)){
                getObjeto().getAtuam().add(getFuncionario());
                Util.mensagemInformacao("Desejo adicionado com sucesso");
            } else {
                Util.mensagemErro("Produto já existe na lista");
            } 
        }
    }
    
    public void removerAtuacoes(int index){
        setFuncionario(getObjeto().getAtuam().get(index));
        getObjeto().getAtuam().remove(getFuncionario());
        Util.mensagemInformacao("Desejo removido com sucesso!");
    }

   
    
    
    public String listar() {
        return "/privado/setor/listar?faces-redirect=true";
    }

    public void novo() {
        setObjeto(new Setor());
    }

    public void salvar() {
        boolean persistiu;
        if (getObjeto().getId() == null){
            persistiu = getDao().persist(getObjeto());
        } else {
            persistiu = getDao().merge(getObjeto());
        }        
        if(persistiu){
            Util.mensagemInformacao(getDao().getMensagem());            
        } else {
            Util.mensagemErro(getDao().getMensagem());            
        }   
    }

    public void editar(Integer id) {
        try {
            setObjeto(getDao().localizar(id));
        } catch (Exception e) {
            Util.mensagemErro(e.getMessage());
        }
    }
    
    public void remover(Integer id){
        try {
            setObjeto(getDao().localizar(id));
            if(getDao().remover(getObjeto())){
                Util.mensagemInformacao(getDao().getMensagem());
            } else {
                Util.mensagemErro(getDao().getMensagem());
            }  
        } catch(Exception e){
            Util.mensagemErro(e.getMessage());
        }
    }

    public SetorDAO<Setor> getDao() {
        return dao;
    }

    public void setDao(SetorDAO<Setor> dao) {
        this.dao = dao;
    }

    public Setor getObjeto() {
        return objeto;
    }

    public void setObjeto(Setor objeto) {
        this.objeto = objeto;
    }

    public FuncionarioDAO<Funcionario> getDaoFuncionario() {
        return daoFuncionario;
    }

    public void setDaoFuncionario(FuncionarioDAO<Funcionario> daoFuncionario) {
        this.daoFuncionario = daoFuncionario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    
}
