/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.openmarket.presentation;

import co.edu.unicauca.openmarket.domain.Category;
import co.edu.unicauca.openmarket.domain.Product;
import co.edu.unicauca.openmarket.domain.service.CategoryService;
import co.edu.unicauca.openmarket.domain.service.ProductService;
import co.edu.unicauca.openmarket.infra.Messages;
import co.edu.unicauca.openmarket.presentation.commands.OMCategorizeProductCommand;
import co.edu.unicauca.openmarket.presentation.commands.OMInvoker;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import reloj.frameworkobsobs.Observador;

/**
 *
 * @author Libardo Pantoja
 */
public class GUIProductsFind extends javax.swing.JDialog implements Observador{
    private ProductService productService;
    private CategoryService categoryService;
    private OMInvoker ominvoker;
    /**
     * Creates new form GUIProductsFind
     */
    public GUIProductsFind(java.awt.Frame parent, boolean modal,ProductService productService, CategoryService categoryService) {
        super(parent, modal);
        ominvoker = new OMInvoker();
        initComponents();
        initializeTable();
        this.productService = productService;
        this.categoryService = categoryService;
        setLocationRelativeTo(null); //centrar al ventana
        this.btnDeshacerCate.setVisible(ominvoker.hasUndoStack());
    }
    
    private void initializeTable() {
        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Id", "Name", "Description", "CategoryId"
                }
        ));
                
    }
    
        private void fillTable(List<Product> listProducts) {
        initializeTable();
        DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();

        Object rowData[] = new Object[4];//No columnas
        for (int i = 0; i < listProducts.size(); i++) {
            rowData[0] = listProducts.get(i).getProductId();
            rowData[1] = listProducts.get(i).getName();
            rowData[2] = listProducts.get(i).getDescription();
            rowData[3] = listProducts.get(i).getCategory().getCategoryId();
            
            model.addRow(rowData);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlCenter = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        pnlNorth = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rdoId = new javax.swing.JRadioButton();
        rdoName = new javax.swing.JRadioButton();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnSearchAll = new javax.swing.JButton();
        btnCategorizar = new javax.swing.JButton();
        btnDeshacerCate = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jPanel1 = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Búsqueda de productos");

        pnlCenter.setLayout(new java.awt.BorderLayout());

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblProducts);

        pnlCenter.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlCenter, java.awt.BorderLayout.CENTER);

        jLabel1.setText("Buscar por:");
        pnlNorth.add(jLabel1);

        buttonGroup1.add(rdoId);
        rdoId.setSelected(true);
        rdoId.setText("Id");
        pnlNorth.add(rdoId);

        buttonGroup1.add(rdoName);
        rdoName.setText("Nombre del producto");
        pnlNorth.add(rdoName);

        txtSearch.setPreferredSize(new java.awt.Dimension(62, 32));
        pnlNorth.add(txtSearch);

        btnSearch.setText("Buscar");
        pnlNorth.add(btnSearch);

        btnSearchAll.setText("Buscar Todos");
        btnSearchAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchAllActionPerformed(evt);
            }
        });
        pnlNorth.add(btnSearchAll);

        btnCategorizar.setText("Categorizar");
        btnCategorizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategorizarActionPerformed(evt);
            }
        });
        pnlNorth.add(btnCategorizar);

        btnDeshacerCate.setText("Deshacer Categoria");
        btnDeshacerCate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshacerCateActionPerformed(evt);
            }
        });
        pnlNorth.add(btnDeshacerCate);
        pnlNorth.add(filler1);

        getContentPane().add(pnlNorth, java.awt.BorderLayout.PAGE_START);

        btnClose.setText("Cerrar");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnClose);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnSearchAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchAllActionPerformed
        fillTable(productService.findAllProducts());
    }//GEN-LAST:event_btnSearchAllActionPerformed

    private void btnCategorizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategorizarActionPerformed
        int[] selectedRows = tblProducts.getSelectedRows();
        List<Product> previousProducts = new ArrayList<>();
        if (selectedRows.length > 0) {
            for (int row : selectedRows) {
                Object productId = tblProducts.getValueAt(row, 0);
                Object categoryId = tblProducts.getValueAt(row, 3);
                
                Product productP = new Product((Long) productId, "","", 0);
                Category categoryP = new Category();
                categoryP.setCategoryId( (long) categoryId);
                
                productP.setProductId( (long) productId);
                productP.setCategory(categoryP);
                
                previousProducts.add(productP);
            }
            List<Category> allCategories = categoryService.findAllCategories();
            DefaultListModel<String> listModel = new DefaultListModel<>();
            for (Category category : allCategories) {
                listModel.addElement(category.getCategoryId()+"+"+category.getName());
            }

            JList<String> listaCategorias = new JList<>(listModel);
            JScrollPane scrollPane = new JScrollPane(listaCategorias);

            
            int option = JOptionPane.showOptionDialog(null, scrollPane, "Categorizar Productos", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

            if (option == JOptionPane.OK_OPTION) {
                String categoriaSeleccionada = listaCategorias.getSelectedValue();

                if (categoriaSeleccionada != null){
                    String[] splits = categoriaSeleccionada.split("\\+");
                
                    Long categoryId = Long.parseLong(splits[0]);
                    System.out.println("Size Products"+ previousProducts.size());
                    OMCategorizeProductCommand comm = new OMCategorizeProductCommand(categoryId, previousProducts, productService);
                    ominvoker.addCommand(comm);
                    ominvoker.execute();

                    this.btnDeshacerCate.setVisible(ominvoker.hasUndoStack());

                    // Mostrar un mensaje con la categoría seleccionada
                    JOptionPane.showMessageDialog(null, "Producto(s) categorizado(s) en: " + categoriaSeleccionada);
                }else{
                    Messages.showMessageDialog("Debe seleccionar la categoria", "Atención");
                }
            }
  
        } else{
            Messages.showMessageDialog("Debe seleccionar uno o más productos de la tabla", "Atención");
        }
        
        
        
        
    }//GEN-LAST:event_btnCategorizarActionPerformed

    private void btnDeshacerCateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerCateActionPerformed
        ominvoker.unexecute();
        this.btnDeshacerCate.setVisible(ominvoker.hasUndoStack());
    }//GEN-LAST:event_btnDeshacerCateActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCategorizar;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDeshacerCate;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearchAll;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlNorth;
    private javax.swing.JRadioButton rdoId;
    private javax.swing.JRadioButton rdoName;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actualizar() {
        fillTable(productService.findAllProducts());
    }
}