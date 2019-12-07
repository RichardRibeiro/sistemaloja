/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.cliente.dao;

import br.edu.ifms.loja.app.dao.GenericDAO;
import br.edu.ifms.loja.cliente.datamodel.Cliente;
import java.util.List;
/**
 *
 * @author gusta
 */
public class ClienteDAO extends GenericDAO<Cliente>{ 
    public ClienteDAO() {
        super(Cliente.class);
    }
    
      public List<Cliente> buscarPorNome(String valor) {
        return getEm().createQuery("SELECT c FROM Cliente c WHERE UPPER(c.nome) LIKE :nome")
                .setParameter("nome", "%" + valor.toUpperCase() + "%")
                .getResultList();
    }
      
        public List<Cliente> buscarPorId(String valor) {
        Long id;
        try {
            id = new Long(valor);
            return getEm().createQuery("SELECT c FROM Cliente c WHERE c.id =:id")
                    .setParameter("id", id)
                    .getResultList();
        } catch (NumberFormatException ex) {
            return listarTodos();
        }
    }
        
         public List<Cliente> buscarPoCidade(String valor) {
        return getEm().createQuery("SELECT c FROM Cliente c WHERE UPPER (c.cidade.nome) LIKE :cidade_id")
                .setParameter("cidade_id", "%" + valor.toUpperCase() + "%")
                .getResultList();
    }

}
