package examen.contin.enma.DAO;

import examen.contin.enma.beans.MuestraForense;
import examen.contin.enma.beans.CentroForense;
import examen.contin.enma.beans.InformeForense;
import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.List;

public class MuestraForenseDAOImpl extends AbstractDAO implements DAO<MuestraForense> {


    @Override
    public List<MuestraForense> findAll() {
        List<MuestraForense> muestras = new ArrayList<>();
        //INNER JOIN OBLIGATORIO
        String sql = "SELECT ms.id, ms.codigoCaso, ms.tipoMuestra, ms.fechaRecogida, ms.estadoCustodia,ms.fk_centro_id, ms.autorExamen, cf.nombre as centro_forense"+
                "FROM MuestraForense ms" +
                "INNER JOIN CentroForense cf ON cf.fk_centro_id = ms.fk_centro_id" +
                "INNER JOIN InformeForense if ON ms.fk_muestra_id = if.fk_muestra_id";

        try{
            //USO EXCLUSIVO DE preparedStatement
            PreparedStatement pstmt = this.motorSQL.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                //Creamos Muestra
                MuestraForense muestra = new MuestraForense();
                muestra.setId(rs.getInt("id"));
                muestra.setCodigoCaso(rs.getInt("codigoCaso"));
                muestra.setTipoMuestra(rs.getString("tipoMuestra"));
                muestra.setEstadoCustodia(rs.getString("estadoCustodia"));

                //Creamos centro forense relacionado
                CentroForense centro = new CentroForense();
                centro.setId(rs.getInt("id"));
                centro.setNommbre(rs.getString("nombre"));
                centro.setPais(rs.getString("pais"));
                centro.setNivelSeguridad(rs.getInt("nivelSeguridad"));

                //Creamos el informe relacionado
                InformeForense informe = new InformeForense();
                informe.setId(rs.getInt("id"));
                informe.setAdnPositivo(rs.getBoolean("adnPositivo"));
                informe.setNivelRiesgo(rs.getInt("nivelRiesgo"));
                informe.setConclusion(rs.getString("conclusion"));

                //MAPPING: GUARDAMOS LOS OBJETOS EN LA MUESTRA
                muestra.setCentro(centro);
                muestra.setInforme(informe);
                muestras.add(muestra);
            }
        }catch (Exception e){
            System.out.println("Error en findALL: "+e.getMessage());

        }
        return muestras;
    }

    @Override
    public MuestraForense findById(int id) {
        //INNER JOIN OBLIGATORIO PARA RELACIONAR CON INFORME Y CENTRO
        String sql = "SELECT ms.id, ms.codigoCaso, ms.tipoMuestra, ms.fechaRecogida, ms.estadoCustodia,ms.fk_centro_id, ms.autorExamen, cf.nombre as centro_forense" +
                "FROM MuestraForense ms " +
                "INNER JOIN CentroForense cf ON cf.fk_centro_id = ms.fk_centro_id" +
                "INNER JOIN InformeForense if ON ms.fk_muestra_id = if.fk_muestra_id" +
                "WHERE ms.id = ?";

        try {
            PreparedStatement pstmt = this.motorSQL.getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                //Creamos Muestra
                MuestraForense muestra = new MuestraForense();
                muestra.setId(rs.getInt("id"));
                muestra.setCodigoCaso(rs.getInt("codigoCaso"));
                muestra.setTipoMuestra(rs.getString("tipoMuestra"));
                muestra.setEstadoCustodia(rs.getString("estadoCustodia"));

                //Mapeamons forense
                CentroForense centro = new CentroForense();
                centro.setId(rs.getInt("id"));
                centro.setNommbre(rs.getString("nombre"));
                centro.setPais(rs.getString("pais"));
                centro.setNivelSeguridad(rs.getInt("nivelSeguridad"));

                //Mapeamos informe
                InformeForense informe = new InformeForense();
                informe.setId(rs.getInt("id"));
                informe.setAdnPositivo(rs.getBoolean("adnPositivo"));
                informe.setNivelRiesgo(rs.getInt("nivelRiesgo"));
                informe.setConclusion(rs.getString("conclusion"));

                //Guardamos los objetos en Muestra (Mapping)
                muestra.setCentro(centro);
                muestra.setInforme(informe);
            }

        } catch (Exception e) {
            System.out.println("Error en findById: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void add(MuestraForense bean) {
        //Implementacion de una nueva muestra a la base de datos
        int filasAfectadas = 0;
        String sql = "INSER INTO MuestraForense (codigoCaso, tipoMuestra, estadoCustodia, fk_centro_id, autorExamen)" +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement pstmt = this.motorSQL.getConnection().prepareStatement(sql);
            pstmt.setInt(1, bean.getCodigoCaso());
            pstmt.setString(2, bean.getTipoMuestra());
            pstmt.setString(3, bean.getEstadoCustodia());

            //Extraemos id del centro mapeado dentro de la muestra
            pstmt.setInt(4, bean.getCentro().getId());

            //CAMBIAMOS POR NOMBRE REAL
            pstmt.setString(5, "Enma Contin DAM");

            filasAfectadas = pstmt.executeUpdate();
        }catch (Exception e){
            System.out.println("Error en add: " + e.getMessage());
        }
    }

    @Override
    public void update(MuestraForense bean) {
        //Implementacion para actualizar una muestra existente en la base de datos
        int filasAfectadas = 0;
        String sql = "UPDATE MuestraForense SET codigoCaso = ?, tipoMuestra = ?, estadoCustodia = ?, fk_centro_id = ? " +
                "WHERE id = ?";

        try {
            PreparedStatement pstmt = this.motorSQL.getConnection().prepareStatement(sql);
            pstmt.setInt(1, bean.getCodigoCaso());
            pstmt.setString(2, bean.getTipoMuestra());
            pstmt.setString(3, bean.getEstadoCustodia());

            pstmt.setInt(6, bean.getCentro().getId());
            pstmt.setInt(7, bean.getId()); // El ID para identificar qué muestra actualizar

            filasAfectadas = pstmt.executeUpdate();
            System.out.println("Muestra actualizado correctamente.");

        } catch (Exception e) {
            System.err.println("Error en update: " + e.getMessage());
        }

    }

    @Override
    public void delete(int id) {

    }
}
