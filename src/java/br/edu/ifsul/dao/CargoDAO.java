
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Cargo;
import br.edu.ifsul.modelo.Cidade;
import java.io.Serializable;

/**
 *
 * @daniel
 */
public class CargoDAO<T> extends DAOGenerico<Cargo>implements Serializable {

    public CargoDAO(){
        super();
        super.setClassePersistente(Cargo.class);
        super.setOrdem("nome");// ordem padrão
    }

}
