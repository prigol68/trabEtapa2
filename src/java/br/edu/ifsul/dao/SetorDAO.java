
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Funcionario;
import br.edu.ifsul.modelo.Setor;
import java.io.Serializable;

/**
 *
 * @daniel
 */
public class SetorDAO<T> extends DAOGenerico<Setor>implements Serializable {

    public SetorDAO(){
        super();
        super.setClassePersistente(Setor.class);
        super.setOrdem("nome");// ordem padrão
    }

}
