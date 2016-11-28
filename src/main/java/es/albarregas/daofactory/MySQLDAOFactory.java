/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  es.albarregas.dao.EquiposDAO
 *  es.albarregas.dao.IAlumnosDAO
 *  es.albarregas.dao.IEquiposDAO
 *  es.albarregas.dao.MysqlAlumnosDAO
 */
package es.albarregas.daofactory;

import es.albarregas.dao.EquiposDAO;
import es.albarregas.dao.IAlumnosDAO;
import es.albarregas.dao.IEquiposDAO;
import es.albarregas.dao.MysqlAlumnosDAO;
import es.albarregas.daofactory.DAOFactory;

public class MySQLDAOFactory extends DAOFactory {
    @Override
    public IAlumnosDAO getAlumnosDAO() {
        return new MysqlAlumnosDAO();
    }

    @Override
    public IEquiposDAO getEquiposDAO() {
        return new EquiposDAO();
    }
}