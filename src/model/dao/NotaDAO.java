package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Nota;

/**
 *
 * @author Eraldo
 */
public class NotaDAO {
    
    
    public void inserir(Nota nota){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO nota(data_compra, forma_pagamento, total_nota) VALUES (?,?,?)");
            stmt.setDate(1, nota.getDataCompra());
            stmt.setString(2, nota.getFormaPagamento());
            stmt.setDouble(3, nota.getTotalNota());
            
            stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERRO: "+ ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        
        
        
    }
    
    public ArrayList<Nota> ler(String sql){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Nota> notas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Nota not = new Nota();
                not.setIdNota(rs.getInt("id_nota"));
                not.setFormaPagamento(rs.getString("forma_pagamento"));
                not.setDataCompra(rs.getDate("data_compra"));
                not.setTotalNota(rs.getDouble("total_nota"));
                
                notas.add(not);
                
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERRO: "+ ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return notas;
        
        
    }
    
    
    
}
