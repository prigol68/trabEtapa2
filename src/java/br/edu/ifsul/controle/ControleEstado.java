package br.edu.ifsul.controle;




import br.edu.ifsul.dao.EstadoDAO;
import br.edu.ifsul.dao.PaisDAO;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Pais;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @daniel
 */
@ManagedBean(name = "controleEstado")
@ViewScoped
public class ControleEstado implements Serializable {
    private EstadoDAO<Estado> dao;
    private Estado objeto;
    private PaisDAO<Pais> daoPais;
    
    public ControleEstado(){
        dao = new EstadoDAO<>();
        daoPais = new PaisDAO<>();
    }
    
    public String listar(){
        return "/privado/estado/listar?faces-redirect=true";
    }
    
    public void novo(){
        setObjeto(new Estado());        
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

    public EstadoDAO<Estado> getDao() {
        return dao;
    }

    public void setDao(EstadoDAO<Estado> dao) {
        this.dao = dao;
    }

    public Estado getObjeto() {
        return objeto;
    }

    public void setObjeto(Estado objeto) {
        this.objeto = objeto;
    }

    public PaisDAO<Pais> getDaoPais() {
        return daoPais;
    }

    public void setDaoPais(PaisDAO<Pais> daoPais) {
        this.daoPais = daoPais;
    }
        

    
}
