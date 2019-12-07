/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.fornecedor.bo;

import br.edu.ifms.loja.fornecedor.datamodel.Fornecedor;
import br.edu.ifms.loja.fornecedor.view.FornecedorFormulario;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import java.util.List;
import maruyama.components.mvc.GenericCRUDController;
import maruyama.components.mvc.GenericCRUDModel;
import maruyama.components.mvc.GenericCRUDView;
import maruyama.components.swing.ObjectTableModel;

/**
 *
 * @author hj
 */
public class FornecedorController extends GenericCRUDController<Fornecedor> {
 private Fornecedor fornencedor;
    public FornecedorController(GenericCRUDModel model, GenericCRUDView view) {
        super(model, view);
        inicializarAcoesDeBusca(view, (FornecedorBO) model);
    }

    public void inicializarAcoesDeBusca(GenericCRUDView view, FornecedorBO model) {
        view.getCampoBusca().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String campo = (String) view.getComboBoxAtributoDeBusca().getSelectedItem();
                String valor = view.getCampoBusca().getText();
                List<Fornecedor> lista = model.buscar(campo, valor);
                ObjectTableModel tableModel = new ObjectTableModel(Fornecedor.class, lista);
                view.getTabela().setModel(tableModel);
            }
        });
    }

    @Override
    public void dadosViewParaModel(Fornecedor t, JPanel pnl) {
        FornecedorFormulario form = (FornecedorFormulario) pnl;
        t.setNomefantasia(form.getCampoNomeFantasia().getText());
        t.setRazaosocial(form.getCampoRazaoSocial().getText());
        t.setCnpj(form.getCampoCNPJ().getText());
        t.setTelefone(form.getCampoTelefone().getText());
        t.setEmail(form.getCampoEmail().getText());
        t.setCep(form.getCampoCEP().getText());
        t.setEndereco(form.getCampoEndereco().getText());
        t.setNumero(form.getCampoNumero().getText());
        t.setCidade(form.getComboBoxUfCidade().getSelectedCidade());

    }

    @Override
    public void dadosModelParaView(Fornecedor t, JPanel pnl) {
        FornecedorFormulario form = (FornecedorFormulario) pnl;
        form.getCampoNomeFantasia().setText(t.getNomefantasia());
        form.getCampoRazaoSocial().setText(t.getRazaosocial());
        form.getCampoCNPJ().setText(t.getCnpj());
        form.getCampoTelefone().setText(t.getTelefone());
        form.getCampoEmail().setText(t.getEmail());
        form.getCampoCEP().setText(t.getCep());
        form.getCampoEndereco().setText(t.getEndereco());
        form.getCampoNumero().setText(t.getNumero());
//        form.getComboBoxUfCidade().setSelectedCidade(t.getCidade());
        
         if (t.getCidade() == null) {
            return;
        }
           form.getComboBoxUfCidade().setSelectedCidade(t.getCidade());
        

    }

}
