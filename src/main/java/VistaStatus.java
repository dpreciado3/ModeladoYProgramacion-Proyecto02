public class VistaStatus extends javax.swing.JPanel {
    private String fecha;
    private String nivel;
    private String dinero;
    private String nombre;

    /**
     * Creates new form VistaStatus
     */
    public VistaStatus() {
        initComponents();
        fecha = "";
        nivel = "";
        dinero = "";
        nombre = "";
        jTextArea1.setText("NOMBRE: " + nombre 
                + "\nFECHA: " + fecha
                + "\nDINERO: " + dinero
                + "\nNIVEL: " + nivel);
    }
    
    public void actualizarStatus() {
        jTextArea1.setText("NOMBRE: " + nombre 
                + "\nFECHA: " + fecha
                + "\nDINERO: " + dinero
                + "\nNIVEL: " + nivel);
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
        actualizarStatus();
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
        actualizarStatus();
    }

    public void setDinero(String dinero) {
        this.dinero = dinero;
        actualizarStatus();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        actualizarStatus();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextArea1 = new javax.swing.JTextArea();

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextArea1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextArea1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
