/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import model.bean.Produto;




/**
 *
 * @author Eraldo
 */
public class ProdutoDAO {
    
    public void create(Produto produto){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO produto (descricao, finalidade, quantidade, valor_unidade, valor_total, fk_nota) VALUES (?,?,?,?,?,?)");
            stmt.setString(1, produto.getDescricao());
            stmt.setString(2, produto.getFinalidade());
            stmt.setDouble(3, produto.getQuantidade());
            stmt.setDouble(4, produto.getValorUnidade());
            stmt.setDouble(5, produto.getTotal());
            stmt.setInt(6, produto.getFkNota());
            
            stmt.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public ArrayList<Produto> ler(String sql){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Produto produto = new Produto();
                
                produto.setDescricao(rs.getString("descricao"));
                produto.setFinalidade(rs.getString("finalidade"));
                produto.setQuantidade(rs.getDouble("quantidade"));
                produto.setValorUnidade(rs.getDouble("valor_unidade"));
                produto.setTotal(rs.getDouble("valor_total"));
                produto.setFkNota(rs.getInt("fk_nota"));
                try{
                    produto.setDataCompra(rs.getDate("nota.data_compra"));
                }catch(SQLException ex){
                    
                }
                
                produtos.add(produto);
                
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return produtos;
        
        
        
        
    }
    
    
    
    
}
