/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.fornecedor.dao;

import br.edu.ifms.loja.app.dao.GenericDAO;
import br.edu.ifms.loja.fornecedor.datamodel.Fornecedor;
import br.edu.ifms.loja.uf.datamodel.Uf;
import java.util.List;

/**
 *
 * @author hj
 */
public class FornecedorDAO extends GenericDAO<Fornecedor> {

    public FornecedorDAO() {
        super(Fornecedor.class);
    }

    public List<Fornecedor> listarPorNomeFantasia(String valor) {
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT f ");
        consulta.append("FROM Fornecedor f ");
        consulta.append("WHERE f.nomefantasia LIKE :Nomefantasia");

        return getEm().createQuery(consulta.toString())
                .setParameter("Nomefantasia", "%" + valor + "%")
                .getResultList();
    }
        public List<Fornecedor> listarPorRazaoSocial(String valor) {
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT f ");
        consulta.append("FROM Fornecedor f ");
        consulta.append("WHERE f.razaosocial LIKE :Razaosocial");

        return getEm().createQuery(consulta.toString())
                .setParameter("Razaosocial", "%" + valor + "%")
                .getResultList();
    }
            public List<Fornecedor> buscarFonecedorPorId(String valor) {
        Long id;
        try {
            id = new Long(valor);
            return getEm().createQuery("SELECT f FROM Fornecedor f WHERE f.id =:id")
                    .setParameter("id", id)
                    .getResultList();
        } catch (NumberFormatException ex) {
            return listarTodos();
        }
    }

}
