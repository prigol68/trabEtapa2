
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Escolaridade;
import java.io.Serializable;

/**
 *
 * @daniel
 */
public class EscolaridadeDAO<T> extends DAOGenerico<Escolaridade>implements Serializable {

    public EscolaridadeDAO(){
        super();
        super.setClassePersistente(Escolaridade.class);
        super.setOrdem("nome");// ordem padrão
    }

}
