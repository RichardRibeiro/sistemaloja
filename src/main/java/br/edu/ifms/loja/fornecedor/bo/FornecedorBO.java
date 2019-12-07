/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.fornecedor.bo;

import br.edu.ifms.loja.fornecedor.dao.FornecedorDAO;
import br.edu.ifms.loja.fornecedor.datamodel.Fornecedor;
import br.edu.ifms.loja.uf.dao.UfDAO;
import br.edu.ifms.loja.uf.datamodel.Uf;
import java.util.ArrayList;
import java.util.List;
import maruyama.components.mvc.GenericCRUDModel;

/**
 *
 * @author hj
 */
public class FornecedorBO extends GenericCRUDModel<Fornecedor> {

    private FornecedorDAO dao;
    private UfDAO ufDAO;

    public FornecedorBO() {
        dao = new FornecedorDAO();
        ufDAO = new UfDAO();
        preencherLista(dao.listarTodos());
    }

    public List<Uf> listarUfs() {
        return ufDAO.listarTodos();
    }

    @Override
    public void salvarEmBaseDeDados(Fornecedor t) {
        dao.persistir(t);
    }

    @Override
    public void removerEmBaseDeDados(Fornecedor t) {
        dao.remover(t);
    }

    @Override
    public List<Fornecedor> carregarLista() {
        return dao.listarTodos();
    }

    @Override
    public List<Fornecedor> buscar(String campo, String valor) {
        if (campo.equals("Nome fantasia")) {
            return dao.listarPorNomeFantasia(valor);
        }
         if (campo.equals("Razao Social")) {
            return dao.listarPorRazaoSocial(valor);
        }
          if (campo.equals("ID")) {
            return dao.buscarFonecedorPorId(valor);
        }
       
        return new ArrayList<Fornecedor>();
    }

}
