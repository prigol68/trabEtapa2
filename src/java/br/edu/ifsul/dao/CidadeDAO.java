
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Cidade;
import java.io.Serializable;

/**
 *
 * @daniel
 */
public class CidadeDAO<T> extends DAOGenerico<Cidade>implements Serializable {

    public CidadeDAO(){
        super();
        super.setClassePersistente(Cidade.class);
        super.setOrdem("nome");// ordem padrão
    }

}
