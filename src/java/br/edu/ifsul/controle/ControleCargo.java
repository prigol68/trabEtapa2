package br.edu.ifsul.controle;




import br.edu.ifsul.dao.CidadeDAO;
import br.edu.ifsul.dao.EstadoDAO;
import br.edu.ifsul.dao.CargoDAO;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Cargo;
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
@ManagedBean(name = "controleCargo")
@ViewScoped
public class ControleCargo implements Serializable {
    private CargoDAO<Cargo> dao;
    private Cargo objeto;
   
    
    public ControleCargo(){
        dao = new CargoDAO<>();
        
    }
    
    public String listar(){
        return "/privado/cargo/listar?faces-redirect=true";
    }
    
    public void novo(){
        setObjeto(new Cargo());        
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

    public CargoDAO<Cargo> getDao() {
        return dao;
    }

    public void setDao(CargoDAO<Cargo> dao) {
        this.dao = dao;
    }

    public Cargo getObjeto() {
        return objeto;
    }

    public void setObjeto(Cargo objeto) {
        this.objeto = objeto;
    }
        

    
}
