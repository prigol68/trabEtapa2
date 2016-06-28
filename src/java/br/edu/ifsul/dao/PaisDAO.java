
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Pais;
import java.io.Serializable;

/**
 *
 * @daniel
 */
public class PaisDAO<T> extends DAOGenerico<Pais>implements Serializable {

    public PaisDAO(){
        super();
        super.setClassePersistente(Pais.class);
        super.setOrdem("nome");// ordem padrão
    }

}
