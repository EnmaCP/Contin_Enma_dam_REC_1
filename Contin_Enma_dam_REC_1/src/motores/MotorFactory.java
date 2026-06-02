package motores;

public class MotorFactory {

    public static final int POSTGRE =1;

    public static MotorSQL create(int tipoMotor){
        if(tipoMotor == POSTGRE){
            return new PostgreMotorSQL();
        }
        return null;
    }
}
