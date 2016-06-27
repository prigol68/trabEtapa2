package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Usuario;
import java.io.Serializable;
import javax.persistence.Query;

/**
 *
 * @author Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 */
public class UsuarioDAO<T> extends DAOGenerico<Usuario> implements Serializable {

    public UsuarioDAO() {
        super();
        super.setClassePersistente(Usuario.class);
        super.setOrdem("nome");// ordem padrão
    }
    
    public boolean login(String apelido, String senha){
        Query query = super.getEm().createQuery("from Usuario where upper(apelido) = "
                + " :apelido and upper(senha) = :senha and ativo = TRUE");
        query.setParameter("apelido",apelido.toUpperCase());
        query.setParameter("senha", senha.toUpperCase());
        if (!query.getResultList().isEmpty()){
            return true;
        } else {
            return false;
        }
    }
    
    public Usuario localizaPorNomeUsuario(String apelido){
        Query query = super.getEm().createQuery("from Usuario where upper(apelido) = :apelido");
        // :apelido é um paramentro que a consulta espera. 
        // Na linha abaixo o valor do parametro é definido
        query.setParameter("apelido", apelido.toUpperCase());
        Usuario obj = (Usuario) query.getSingleResult();
        return obj;
    }

}
