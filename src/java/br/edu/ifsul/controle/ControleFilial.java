package br.edu.ifsul.controle;




import br.edu.ifsul.dao.FilialDAO;
import br.edu.ifsul.dao.CidadeDAO;
import br.edu.ifsul.modelo.Filial;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @daniel
 */
@ManagedBean(name = "controleFilial")
@ViewScoped
public class ControleFilial implements Serializable {
    private FilialDAO<Filial> dao;
    private Filial objeto;
    private CidadeDAO<Cidade> daoCidade;
    
    public ControleFilial(){
        dao = new FilialDAO<>();
        daoCidade = new CidadeDAO<>();
    }
    
    public String listar(){
        return "/privado/filial/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Filial();        
    }
    
    public void salvar(){
        boolean persistiu;
        if (objeto.getId() == null){
            persistiu = dao.persist(objeto);
        } else {
            persistiu = dao.merge(objeto);
        }        
        if(persistiu){
            Util.mensagemInformacao(dao.getMensagem());            
        } else {
            Util.mensagemErro(dao.getMensagem());            
        }                        
    }    
    
    public void editar(Integer id){
        try {
            objeto = dao.localizar(id);            
        } catch (Exception e){
            Util.mensagemErro("Erro ao recuperar objeto: "+Util.getMensagemErro(e));            
        }
    }
    
    public void remover(Integer id){
        try {
            objeto = dao.localizar(id);
            if(dao.remover(objeto)){
                Util.mensagemInformacao(dao.getMensagem());
            } else {
                Util.mensagemErro(dao.getMensagem());
            }            
        } catch (Exception e){
            Util.mensagemErro("Erro ao recuperar objeto: "+Util.getMensagemErro(e));            
        }
    }    
        

    public FilialDAO getDao() {
        return dao;
    }

    public void setDao(FilialDAO dao) {
        this.dao = dao;
    }

    public Filial getObjeto() {
        return objeto;
    }

    public void setObjeto(Filial objeto) {
        this.objeto = objeto;
    }

    public CidadeDAO<Cidade> getDaoCidade() {
        return daoCidade;
    }

    public void setDaoCidade(CidadeDAO<Cidade> daoCidade) {
        this.daoCidade = daoCidade;
    }
}
