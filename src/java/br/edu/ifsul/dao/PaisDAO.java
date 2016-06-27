
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Pais;
import java.io.Serializable;

/**
 *
 * @author Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 */
public class PaisDAO<T> extends DAOGenerico<Pais>implements Serializable {

    public PaisDAO(){
        super();
        super.setClassePersistente(Pais.class);
        super.setOrdem("nome");// ordem padrão
    }

}
