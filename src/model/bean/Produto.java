/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.Date;

/**
 *
 * @author Eraldo
 */
public class Produto {
    private String descricao;
    private String finalidade;
    private double quantidade;
    private double valorUnidade;
    private double total;
    private int fkNota;
    private int idProduto;
    private Date dataCompra;
    private String formaPaga;

    public String getFormaPaga() {
        return formaPaga;
    }

    public void setFormaPaga(String formaPaga) {
        this.formaPaga = formaPaga;
    }
    
    

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }
    

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    
    

    public int getFkNota() {
        return fkNota;
    }

    public void setFkNota(int fkNota) {
        this.fkNota = fkNota;
    }
    
    

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnidade() {
        return valorUnidade;
    }

    public void setValorUnidade(double valorUnidade) {
        this.valorUnidade = valorUnidade;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
    
    
    
}
