/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.produto.bo;

import br.edu.ifms.loja.cidade.datamodel.Cidade;
import br.edu.ifms.loja.fornecedor.dao.FornecedorDAO;
import br.edu.ifms.loja.fornecedor.datamodel.Fornecedor;
import br.edu.ifms.loja.produto.dao.ProdutoDAO;
import br.edu.ifms.loja.produto.datamodel.Produto;
import br.edu.ifms.loja.uf.dao.UfDAO;
import br.edu.ifms.loja.uf.datamodel.Uf;
import java.util.ArrayList;
import java.util.List;
import maruyama.components.mvc.GenericCRUDModel;



/**
 *
 * @author hj
 */
public class ProdutoBO extends GenericCRUDModel<Produto> {
  private ProdutoDAO dao;
    private FornecedorDAO fornecedorDAO;

    public ProdutoBO() {
        dao = new ProdutoDAO();
        fornecedorDAO = new FornecedorDAO();
        preencherLista(dao.listarTodos());
    }
    
    public List<Fornecedor> listarfornecedor() {
        return fornecedorDAO.listarTodos();
    }

    @Override
    public void salvarEmBaseDeDados(Produto t) {
        dao.persistir(t);
    }

    @Override
    public void removerEmBaseDeDados(Produto t) {
        dao.remover(t);
    }

    @Override
    public List<Produto> carregarLista() {
        return dao.listarTodos();
    }

    @Override
    public List<Produto> buscar(String campo, String valor) {
        if (campo.equals("Nome")) {
            return dao.listarProdutoPordescricao(valor);
        }
        if (campo.equals("Marca")) {
            return dao.buscarPorMarca(valor);
        }
        if (campo.equals("ID")) {
            return dao.buscarProdutoPorId(valor);
        }
        return new ArrayList<Produto>();
    }

}
