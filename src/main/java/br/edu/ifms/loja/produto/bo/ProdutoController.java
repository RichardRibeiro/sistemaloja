/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.produto.bo;

import br.edu.ifms.loja.fornecedor.datamodel.Fornecedor;
import br.edu.ifms.loja.produto.datamodel.Produto;
import br.edu.ifms.loja.produto.view.ProdutoFormulario;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JPanel;
import maruyama.components.mvc.GenericCRUDController;
import maruyama.components.mvc.GenericCRUDModel;
import maruyama.components.mvc.GenericCRUDView;
import maruyama.components.swing.ObjectTableModel;

/**
 *
 * @author hj
 */
public class ProdutoController extends GenericCRUDController<Produto> {
    public ProdutoController(GenericCRUDModel model, GenericCRUDView view) {
        super(model, view);
        carregarComboBoxFornecedor(view, (ProdutoBO) model);
        inicializarAcoesDeBusca(view, (ProdutoBO) model);
      
    }

    public void inicializarAcoesDeBusca(GenericCRUDView view, ProdutoBO model) {
        view.getCampoBusca().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {

            }

            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {

            }

            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {
                String campo = (String) view.getComboBoxAtributoDeBusca().getSelectedItem();
                String valor = view.getCampoBusca().getText();
                List<Produto> lista = model.buscar(campo, valor);
                ObjectTableModel tableModel = new ObjectTableModel(Produto.class, lista);
                view.getTabela().setModel(tableModel);
            }
        });
    }
    
     public void carregarComboBoxFornecedor(GenericCRUDView view, ProdutoBO model) {
        ProdutoFormulario form = (ProdutoFormulario) view.getFormulario();
    //   form.getComboBoxFornecedor().removeAllItems();


        for (Fornecedor f : model.listarfornecedor()) {
                     System.out.println(f);
           form.getComboBoxFornecedor().addItem(f);
        }
}
    
     
   

    @Override
    public void dadosViewParaModel(Produto t, JPanel pnl) {
        ProdutoFormulario form = (ProdutoFormulario) pnl;
       t.setDescricao(form.getCampoDescricao().getText());
        t.setMarca(form.getCampoMarca().getText());
        t.setValor(Float.valueOf(form.getCampoValor().getText()));
        t.setModelo(form.getCampoModelo().getText());
        t.setQtde(Integer.parseInt(form.getCampoQuantidade().getText()));
        t.setFornecedor((Fornecedor) form.getComboBoxFornecedor().getSelectedItem());
    }

    @Override
    public void dadosModelParaView(Produto t, JPanel pnl) {
         ProdutoFormulario form = (ProdutoFormulario) pnl;
       form.getCampoDescricao().setText(t.getDescricao());
        form.getCampoMarca().setText(t.getMarca());
        form.getCampoModelo().setText(t.getModelo());
        form.getCampoValor().setText(String.valueOf(t.getValor()));
        form.getCampoQuantidade().setText(String.valueOf((t.getQtde())));
        form.getComboBoxFornecedor().setSelectedItem(t.getFornecedor());
    }

}
