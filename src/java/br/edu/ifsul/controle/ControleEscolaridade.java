package br.edu.ifsul.controle;




import br.edu.ifsul.dao.CidadeDAO;
import br.edu.ifsul.dao.EstadoDAO;
import br.edu.ifsul.dao.EscolaridadeDAO;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Escolaridade;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @daniel
 * 
 */
@ManagedBean(name = "controleEscolaridade")
@ViewScoped
public class ControleEscolaridade implements Serializable {
    private EscolaridadeDAO<Escolaridade> dao;
    private Escolaridade objeto;
   
    
    public ControleEscolaridade(){
        dao = new EscolaridadeDAO<>();
        
    }
    
    public String listar(){
        return "/privado/escolaridade/listar?faces-redirect=true";
    }
    
    public void novo(){
        setObjeto(new Escolaridade());        
    }
    
    public void salvar(){
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
    
    public void editar(Integer id){
        try {
            setObjeto(getDao().localizar(id));            
        } catch (Exception e){
            Util.mensagemErro("Erro ao recuperar objeto: "+Util.getMensagemErro(e));            
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
        } catch (Exception e){
            Util.mensagemErro("Erro ao recuperar objeto: "+Util.getMensagemErro(e));            
        }
    }    

    public EscolaridadeDAO<Escolaridade> getDao() {
        return dao;
    }

    public void setDao(EscolaridadeDAO<Escolaridade> dao) {
        this.dao = dao;
    }

    public Escolaridade getObjeto() {
        return objeto;
    }

    public void setObjeto(Escolaridade objeto) {
        this.objeto = objeto;
    }
        

    
}
