
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Funcionario;
import java.io.Serializable;

/**
 *
 * @daniel
 */
public class FuncionarioDAO<T> extends DAOGenerico<Funcionario>implements Serializable {

    public FuncionarioDAO(){
        super();
        super.setClassePersistente(Funcionario.class);
        super.setOrdem("nome");// ordem padrão
    }

}
