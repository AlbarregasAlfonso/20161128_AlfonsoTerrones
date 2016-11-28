/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  es.albarregas.dao.IAlumnosDAO
 *  es.albarregas.dao.IEquiposDAO
 */
package es.albarregas.daofactory;

import es.albarregas.dao.IAlumnosDAO;
import es.albarregas.dao.IEquiposDAO;
import es.albarregas.daofactory.DAOFactory;

public class FicheroDAOFactory
extends DAOFactory {
    @Override
    public IAlumnosDAO getAlumnosDAO() {
        return null;
    }

    @Override
    public IEquiposDAO getEquiposDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}