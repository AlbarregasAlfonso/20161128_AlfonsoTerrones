/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  es.albarregas.dao.IAlumnosDAO
 *  es.albarregas.dao.IEquiposDAO
 *  es.albarregas.daofactory.FicheroDAOFactory
 *  es.albarregas.daofactory.MySQLDAOFactory
 *  es.albarregas.daofactory.OracleDAOFactory
 */
package es.albarregas.daofactory;

import es.albarregas.dao.IEquiposDAO;
import es.albarregas.daofactory.FicheroDAOFactory;
import es.albarregas.daofactory.MySQLDAOFactory;
import es.albarregas.daofactory.OracleDAOFactory;
import es.albarregas.dao.IAlumnosDAO;

public abstract class DAOFactory {
    public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int FICHERO = 3;

    public abstract IAlumnosDAO getAlumnosDAO();

    public abstract IEquiposDAO getEquiposDAO();

    public static DAOFactory getDAOFactory(int tipo) {
        MySQLDAOFactory daof = null;
        switch (tipo) {
            case 1: {
                daof = new MySQLDAOFactory();
                break;
            }
            case 2: {
    //            daof = new OracleDAOFactory();
                break;
            }
            case 3: {
      //          daof = new FicheroDAOFactory();
            }
        }
        return daof;
    }
}