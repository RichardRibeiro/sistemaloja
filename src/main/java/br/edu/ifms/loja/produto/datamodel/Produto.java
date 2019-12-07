/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.produto.datamodel;

import br.edu.ifms.loja.fornecedor.datamodel.Fornecedor;
import com.towel.el.annotation.Resolvable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 *
 * @author hj
 */
@Entity
public class Produto {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Resolvable(colName = "ID")
    private Long idProduto;

    @Resolvable(colName = "Descrição")
    private String descricao;

    @Resolvable(colName = "Marca")
    private String marca;

    @Resolvable(colName = "Modelo")
    private String modelo;

    @Resolvable(colName = "Quantidade")
    private int qtde;

    @Resolvable(colName = "Valor")
    private Float valor;

    @Transient
    @Resolvable(colName = "Valor Total")
    private Float valorTotal;

    @Resolvable(colName = "Fornecedor")

    @ManyToOne
    private Fornecedor fornecedor;

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }



    @Override
    public String toString() {
        return "Produto{" + "descricao=" + descricao + '}';
    }

}