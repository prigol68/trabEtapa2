
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Filial;
import java.io.Serializable;

/**
 *
 * @daniel
 */
public class FilialDAO<T> extends DAOGenerico<Filial>implements Serializable {

    public FilialDAO(){
        super();
        super.setClassePersistente(Filial.class);
        super.setOrdem("nome");// ordem padrão
    }

}
