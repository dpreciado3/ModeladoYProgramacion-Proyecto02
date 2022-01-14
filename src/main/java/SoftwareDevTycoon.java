public class SoftwareDevTycoon {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        VistaGeneral vistaGeneral = new VistaGeneral();
        ModeloPartida modeloPartida = new ModeloPartida();
        ControladorStatus controladorStatus = new ControladorStatus(modeloPartida, vistaGeneral.getVistaStatus());
        ControladorFeedback controladorFeedback = new ControladorFeedback(modeloPartida, vistaGeneral.getVistaFeedback());
        ControladorPlayer controladorPlayer = new ControladorPlayer(modeloPartida, vistaGeneral.getVistaPlayer(),controladorFeedback);
        modeloPartida.registrarObservador(controladorStatus);
        modeloPartida.registrarObservador(controladorFeedback);
        controladorFeedback.setPlayer(controladorPlayer);
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                vistaGeneral.setVisible(true);
            }
        });
    }
    
}
