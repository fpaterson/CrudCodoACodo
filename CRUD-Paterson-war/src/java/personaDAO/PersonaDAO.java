package personaDAO;

import config.Conexion;
import interfaces.CRUD;
import java.util.ArrayList;
import java.util.List;
import persona.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonaDAO implements CRUD {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Persona p = new Persona();
    
    @Override
    public List listar() {
        ArrayList<Persona> list = new ArrayList<>();
        String sql = "select * from persona";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Persona per = new Persona();
                per.setID(rs.getInt("id"));
                per.setDni(Integer.parseInt(rs.getString("dni")));
                per.setNombre(rs.getString("nombres"));
                
                list.add(per);
            }
        } catch (Exception e) {
            
        }
        return list;
    }
    
    @Override
    public Persona list(int id) {
        String sql = "select * from persona where id =" + id;
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                p.setID(rs.getInt("id"));
                p.setDni(rs.getInt("dni"));
                p.setNombre(rs.getString("nombres"));
            }
                
        } catch (Exception e) {            
        }
        return p;
    }
    
    @Override
    public boolean add(Persona per) {
        String sql = "insert into persona(dni, nombres)values('"+ String.valueOf(per.getDNI()) +"','" + per.getNombre() +"')";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {  
        }
        
        return false;
    }
    
    @Override
    public boolean eliminar(int id) {
        String sql = "delete from persona where id=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        
        return false;
    }

    @Override
    public boolean edit(Persona per) {
        String sql = "update persona SET dni='"+ String.valueOf(per.getDNI()) +"',nombres='" + per.getNombre() +"' where id=" + String.valueOf(per.getID());
        System.out.println(sql);
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
}