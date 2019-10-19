package dao;

import interfaces.CapacitacionI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import modelo.CapacitacionM;

public class CapacitacionImpl extends Conexion implements CapacitacionI {

    Format formatter = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void agregarCapacitacion(CapacitacionM capacitacion) throws Exception {
        this.conectar();
        try {
//            String sql = "INSERT INTO CAPACITACION(TIPPARCAP,NLIBCAP,FOLCAP,NREGCAP,NNDICAP,CNDICAP,NNOFCAP,CNOFCAP,NNCOCAP,CNCOCAP,FECCAP,CODEMP) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            String sql = "INSERT INTO CAPACITACION(TIPPARCAP,CURCAP,FECEJECAP,FECINICAP,"
                    + "FECFINCAP,FINCAP,HORCAP,TIPCAP,NLIBCAP,FOLCAP,NREGCAP,NNDICAP,"
                    + "CNDICAP,NNOFCAP,CNOFCAP,NNCOCAP,CNCOCAP,FECCAP,CODCEN,CODEMP) "
                    + "VALUES(?,?,?,TO_DATE(?,'DD/MM/YYYY'),TO_DATE(?,'DD/MM/YYYY'),?,?,?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY'),?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, capacitacion.getTIPPARCAP());
            ps.setString(2, capacitacion.getCURCAP());
            ps.setString(3, capacitacion.getFECEJECAP());
//            ps.setString(4, capacitacion.getINSCAP());
            ps.setString(4, capacitacion.getFECINICAP());
            ps.setString(5, capacitacion.getFECFINCAP());
            ps.setString(6, capacitacion.getFINCAP());
            ps.setString(7, capacitacion.getHORCAP());
            ps.setString(8, capacitacion.getTIPCAP());
            ps.setString(9, capacitacion.getNLIBCAP());
            ps.setString(10, capacitacion.getFOLCAP());
            ps.setString(11, capacitacion.getNREGCAP());
            ps.setString(12, capacitacion.getNNDICAP());
            ps.setString(13, capacitacion.getCNDICAP());
            ps.setString(14, capacitacion.getNNOFCAP());
            ps.setString(15, capacitacion.getCNOFCAP());
            ps.setString(16, capacitacion.getNNCOCAP());
            ps.setString(17, capacitacion.getCNCOCAP());
            ps.setString(18, capacitacion.getFECCAP());
            ps.setString(19, capacitacion.getCODCEN());
            ps.setString(20, capacitacion.getCODEMP());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificarCapacitacion(CapacitacionM capacitacion) throws Exception {
        this.conectar();
        try {
            String sql = "UPDATE CAPACITACION SET TIPPARCAP=?,CURCAP=?,FECEJECAP=?,"
                    + "FECINICAP=TO_DATE(?,'DD/MM/YYYY'),"
                    + "FECFINCAP=TO_DATE(?,'DD/MM/YYYY'),FINCAP=?,HORCAP=?,TIPCAP=?,"
                    + "NLIBCAP=?,FOLCAP=?,NREGCAP=?,NNDICAP=?,CNDICAP=?,NNOFCAP=?,CNOFCAP=?,"
                    + "NNCOCAP=?,CNCOCAP=?,FECCAP=?,CODCEN=?,CODEMP=? WHERE CODCAP LIKE ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, capacitacion.getTIPPARCAP());
            ps.setString(2, capacitacion.getCURCAP());
            ps.setString(3, capacitacion.getFECEJECAP());
//            ps.setString(4, capacitacion.getINSCAP());
            ps.setString(4, capacitacion.getFECINICAP());
            ps.setString(5, capacitacion.getFECFINCAP());
            ps.setString(6, capacitacion.getFINCAP());
            ps.setString(7, capacitacion.getHORCAP());
            ps.setString(8, capacitacion.getTIPCAP());
            ps.setString(9, capacitacion.getNLIBCAP());
            ps.setString(10, capacitacion.getFOLCAP());
            ps.setString(11, capacitacion.getNREGCAP());
            ps.setString(12, capacitacion.getNNDICAP());
            ps.setString(13, capacitacion.getCNDICAP());
            ps.setString(14, capacitacion.getNNOFCAP());
            ps.setString(15, capacitacion.getCNOFCAP());
            ps.setString(16, capacitacion.getNNCOCAP());
            ps.setString(17, capacitacion.getCNCOCAP());
            ps.setString(18, capacitacion.getFECCAP());
            ps.setString(19, capacitacion.getCODCEN());
            ps.setString(20, capacitacion.getCODEMP());
            ps.setString(21, capacitacion.getCODCAP());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void eliminarCapacitacion(CapacitacionM capacitacion) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE CAPACITACION SET ESTCAP = 'I' WHERE CODCAP LIKE ?";
//            String sql = "DELETE FROM CAPACITACION WHERE CODCAP = ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, capacitacion.getCODCAP());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public List<CapacitacionM> listarCapacitacion() throws Exception {
        List<CapacitacionM> listacapacitacion;
        ResultSet rs;
        try {
            this.conectar();
            String sql ="SELECT * FROM VW_CAPACITACION";
//            String sql = "SELECT CODCAP,TIPPARCAP,CURCAP,FECEJECAP,FECINICAP,"
//                    + "FECFINCAP,FINCAP,HORCAP,TIPCAP,NLIBCAP,FOLCAP,NREGCAP,NNDICAP,CNDICAP,"
//                    + "NNOFCAP,CNOFCAP,NNCOCAP,CNCOCAP,FECCAP,CENTRO.CODCEN AS CODCEN,CENTRO.NOMCEN,"
//                    + "EMPLEADO.CODEMP AS CODEMP,"
//                    + "(EMPLEADO.NOMEMP||' '||EMPLEADO.APAEMP||' '||EMPLEADO.AMAEMP) AS EMPLEADO "
//                    + "FROM CAPACITACION LEFT OUTER JOIN EMPLEADO ON CAPACITACION.CODEMP = EMPLEADO.CODEMP "
//                    + "LEFT OUTER JOIN CENTRO ON CAPACITACION.CODCEN = CENTRO.CODCEN"
//                    + "WHERE ESTCAP LIKE 'A'"
//                    + "ORDER BY (EMPLEADO.NOMEMP||' '||EMPLEADO.APAEMP||' '||EMPLEADO.AMAEMP)";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            rs = ps.executeQuery();
            listacapacitacion = new ArrayList<>();
            CapacitacionM lstCapacitacion;
            while (rs.next()) {
                lstCapacitacion = new CapacitacionM();
                lstCapacitacion.setCODCAP(rs.getString("CODCAP"));
                lstCapacitacion.setTIPPARCAP(rs.getString("TIPPARCAP"));
                lstCapacitacion.setCURCAP(rs.getString("CURCAP"));
                lstCapacitacion.setFECEJECAP(rs.getString("FECEJECAP"));
//                lstCapacitacion.setINSCAP(rs.getString("INSCAP"));
                lstCapacitacion.setFECINICAP(rs.getString("FECINICAP"));
                lstCapacitacion.setFECFINCAP(rs.getString("FECFINCAP"));
                lstCapacitacion.setFINCAP(rs.getString("FINCAP"));
                lstCapacitacion.setHORCAP(rs.getString("HORCAP"));
                lstCapacitacion.setTIPCAP(rs.getString("TIPCAP"));
                lstCapacitacion.setNLIBCAP(rs.getString("NLIBCAP"));
                lstCapacitacion.setFOLCAP(rs.getString("FOLCAP"));
                lstCapacitacion.setNREGCAP(rs.getString("NREGCAP"));
                lstCapacitacion.setNNDICAP(rs.getString("NNDICAP"));
                lstCapacitacion.setCNDICAP(rs.getString("CNDICAP"));
                lstCapacitacion.setNNOFCAP(rs.getString("NNOFCAP"));
                lstCapacitacion.setCNOFCAP(rs.getString("CNOFCAP"));
                lstCapacitacion.setNNCOCAP(rs.getString("NNCOCAP"));
                lstCapacitacion.setCNCOCAP(rs.getString("CNCOCAP"));
                lstCapacitacion.setFECCAP(rs.getString("FECCAP"));
                lstCapacitacion.setCODCEN(rs.getString("CODCEN"));
                lstCapacitacion.setCENTRO(rs.getString("CENTRO"));
                lstCapacitacion.setCODEMP(rs.getString("CODEMP"));
                lstCapacitacion.setEMPLEADO(rs.getString("EMPLEADO"));
                listacapacitacion.add(lstCapacitacion);
            }
            return listacapacitacion;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    public CapacitacionM leerID(String Codigo) throws Exception {
        CapacitacionM lstCapacitacion = null;
        ResultSet rs;

        try {
            this.conectar();
            String sql = "SELECT CODCAP,TIPPARCAP,CURCAP,FECEJECAP,FECINICAP,FECFINCAP,FINCAP,HORCAP,TIPCAP,NLIBCAP,"
                    + "FOLCAP,NREGCAP,NNDICAP,CNDICAP,NNOFCAP,CNOFCAP,NNCOCAP,CNCOCAP,FECCAP,EMPLEADO.CODEMP,"
                    + "UPPER(EMPLEADO.NOMEMP||' '||EMPLEADO.APAEMP||' '||EMPLEADO.AMAEMP) AS EMPLEADO "
                    + "FROM CAPACITACION LEFT OUTER JOIN EMPLEADO ON CAPACITACION.CODEMP = EMPLEADO.CODEMP WHERE CODCAP LIKE ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, Codigo);
            rs = st.executeQuery();
            while (rs.next()) {
                lstCapacitacion = new CapacitacionM();
                lstCapacitacion.setCODCAP(rs.getString("CODCAP"));
                lstCapacitacion.setTIPPARCAP(rs.getString("TIPPARCAP"));
                lstCapacitacion.setCURCAP(rs.getString("CURCAP"));
                lstCapacitacion.setFECEJECAP(rs.getString("FECEJECAP"));
//                lstCapacitacion.setINSCAP(rs.getString("INSCAP"));
                lstCapacitacion.setFECINICAP(rs.getString("FECINICAP"));
                lstCapacitacion.setFECFINCAP(rs.getString("FECFINCAP"));
                lstCapacitacion.setFINCAP(rs.getString("FINCAP"));
                lstCapacitacion.setHORCAP(rs.getString("HORCAP"));
                lstCapacitacion.setTIPCAP(rs.getString("TIPCAP"));
                lstCapacitacion.setNLIBCAP(rs.getString("NLIBCAP"));
                lstCapacitacion.setFOLCAP(rs.getString("FOLCAP"));
                lstCapacitacion.setNREGCAP(rs.getString("NREGCAP"));
                lstCapacitacion.setNNDICAP(rs.getString("NNDICAP"));
                lstCapacitacion.setCNDICAP(rs.getString("CNDICAP"));
                lstCapacitacion.setNNOFCAP(rs.getString("NNOFCAP"));
                lstCapacitacion.setCNOFCAP(rs.getString("CNOFCAP"));
                lstCapacitacion.setNNCOCAP(rs.getString("NNCOCAP"));
                lstCapacitacion.setCNCOCAP(rs.getString("CNCOCAP"));
                lstCapacitacion.setFECCAP(rs.getString("FECCAP"));
                lstCapacitacion.setCODEMP(rs.getString("CODEMP"));
                lstCapacitacion.setEMPLEADO(rs.getString("EMPLEADO"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lstCapacitacion;
    }

    public List<String> autocompleteEmpleado(String a) throws Exception {
        this.conectar();
        ResultSet rs;
        List<String> lista;
        try {
            String sql = "SELECT CODEMP, UPPER(APAEMP||' '||AMAEMP||', '||NOMEMP) AS EMPLE FROM EMPLEADO WHERE UPPER(APAEMP||' '||AMAEMP||', '||NOMEMP) LIKE UPPER(?)";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, "%" + a + "%");
            rs = ps.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                lista.add(rs.getString("EMPLE"));
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    public String leerEmpl(String a) throws Exception {
        this.conectar();
        ResultSet rs;
        try {
            String sql = "SELECT EMPLEADO.CODEMP FROM EMPLEADO WHERE UPPER(APAEMP||' '||AMAEMP||', '||NOMEMP) LIKE UPPER(?)";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, a);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("CODEMP");
            }
            return null;
        } catch (SQLException e) {
            throw e;

        }
    }
}
