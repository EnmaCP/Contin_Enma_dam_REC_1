package examen.contin.enma.DAO;

import motores.MotorFactory;
import motores.MotorSQL;

public abstract class AbstractDAO {
    //variable protegida para que las clases hijas puedan usar el motorSQL

    protected MotorSQL motorSQL;

    public AbstractDAO() {
        //Creamos con PostgreSQL usando la fábrica
        this.motorSQL = MotorFactory.create(MotorFactory.POSTGRE);
    }
}
