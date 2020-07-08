/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warstwaIntegracjiORM;

import entity.Odcinki;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Artur
 */
@Stateless
public class OdcinkiFacade extends AbstractFacade<Odcinki> {

    @PersistenceContext(unitName = "io_dbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OdcinkiFacade() {
        super(Odcinki.class);
    }
    
}
