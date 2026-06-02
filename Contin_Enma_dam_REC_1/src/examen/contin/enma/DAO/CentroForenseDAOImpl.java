package examen.contin.enma.DAO;

import examen.contin.enma.beans.CentroForense;
import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CentroForenseDAOImpl extends AbstractDAO implements DAO<CentroForense> {


    @Override
    public List<CentroForense> findAll() {
        List<CentroForense> centros = new ArrayList<>();
        //para obtener todos los centros de la base de datos
        //NO NECESITA INNER JOIN, NO SE RELACIONA CON OTRAS TABLAS
        String sql = "SELECT id, nombre, pais, nivelSeguridad, autorExamen FROM CentroForense";

        try{
            PreparedStatement pstmt = this.motorSQL.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                CentroForense centro = new CentroForense();
                centro.setId(rs.getInt("id"));
                centro.setNommbre(rs.getString("nombre"));
                centro.setPais(rs.getString("pais"));
                centro.setNivelSeguridad(rs.getInt("nivelSeguridad"));
                centros.add(centro);
            }
        }catch (Exception e){
            System.err.println("Error en findAll (CentroForense): " + e.getMessage());
        }

        return centros;

    }

    @Override
    public CentroForense findById(int id) {
        return null;
    }

    @Override
    public void add(CentroForense bean) {

    }

    @Override
    public void update(CentroForense bean) {

    }

    @Override
    public void delete(int id) {

    }
}
