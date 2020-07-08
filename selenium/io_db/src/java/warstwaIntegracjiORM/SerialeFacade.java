/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warstwaIntegracjiORM;

import entity.Seriale;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Artur
 */
@Stateless
public class SerialeFacade extends AbstractFacade<Seriale> {

    @PersistenceContext(unitName = "io_dbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SerialeFacade() {
        super(Seriale.class);
    }
    
}
