/*
PROYECTO #2 - BATALLA NAVAL
INGENIERIA EN COMPUTACION
INSTITUTO TECNOLOGICO DE COSTA RICA
PROGRAMACION ORIENTADA A OBJETOS
II SEMESTRE 2019
INTEGRANTES: 
            -ALEXANDER ARTAVIA QUESADA
            -JOAN SANCHEZ CHINCHILLA
            -ARMANDO CASTRO RUIZ
PROFESORA:
            -SAMANTA RAMIJAN
*/


package proyecto2_batallanaval;


public class ComoJugarFrame extends javax.swing.JFrame {

   
    public ComoJugarFrame() {
        initComponents();
        this.setLocationRelativeTo(null);   //ASI SE PONE LA VENTANA CENTRADA
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        volverButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("                                                                                                                                                  ¿Cómo Jugar?");
        setPreferredSize(new java.awt.Dimension(1200, 800));
        setResizable(false);
        getContentPane().setLayout(null);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText(" a) Objetivo del juego\n\n  -Hundir los 9 barcos de tu oponente antes que él acabe con los tuyos.\n  -Cada jugador tiene 2 tableros compuesto por 10 filas y 10 columnas:\n  \n  1.Tablero de posición: es tu territorio, en él distribuirás tu flota antes de comenzar la partida. Durante la partida pasará a un segundo plano (más pequeño), \n  y sólo será de observación. Verás la posición de tus barcos y los disparos de tu oponente en tu territorio, pero no podrás realizar ningún cambio ni disparo en él.\n\n  2.Tablero principal: es el territorio de tu enemigo, donde tiene desplegada su flota. Será aquí donde se desarrollen tus movimientos (disparos) y tratarás de hundir \n  los barcos enemigos. Aparecerá en tu pantalla una vez comience la partida y en él quedarán registrados todos tus movimientos, reflejando tanto los disparos al agua \n  como los barcos hundidos hasta el momento.\n \n  Cada jugador tiene una flota de 9 barcos de diferente tamaño, por lo que cada uno ocupará un número determinado de casillas en el tablero:\n\n  1 PortaAviones: ocupa 4 casillas.\n  3 Submarinos/ Acorazados: ocupan 3 casillas. \n  3 Destructores: ocupan 2 casillas.\n  2 Fragatas: ocupan 1 casilla.\n\n b) Terminología y movimientos:\n\n  Agua: cuando disparas sobre una casilla donde no está colocado ningún barco enemigo, disparas al agua. En tu tablero principal aparecerá una X y pasa el turno \n  a tu oponente.\n\n  Tocado: cuando disparas en una casilla en la que está ubicado un barco enemigo que ocupa 2 o más casillas y destruyes sólo una parte del barco, le has tocado. \n  En tu tablero principal aparece esa parte del barco con fuego. Vuelves a disparar.\n\n  Hundido: si disparas en una casilla en la que está ubicado un fragata (1 casilla) u otro barco con el resto de casillas tocadas, le has hundido, es decir, has eliminado \n  ese barco del juego. Aparecerá en tu tablero principal el barco completo echando humo. Vuelves a disparar, siempre y cuando no hayas hundido toda la flota de tu \n  enemigo, en cuyo caso habrás ganado.\n\n c) Controles:\n\n  -Para colocar los barcos dentro del tablero de posición, deberá seleccionar la fila y la columna de cada casilla que se necesite. (Cuatro casillas para el PortaAviones, \n  tres para los Submarinos/Acorazados, dos para los Destructores y una para las fragatas). Luego de seleccionarlas se da clic en el botón de continuar. \n  Si las coordenadas son correctas, podrá observar su barco en el tablero de posición, de lo contrario se le notificará.\n\n  -Para realizar los disparos, simplemente se debe oprimir el botón del tablero principal donde desea realizar su disparo.\n\n d) Reglas generales:\n\n  -Número de jugadores: 2 (mínimo y máximo).\n\n  -Una vez posicionas tus barcos y comienzas la partida, no podrás volver a cambiarlos de posición.\n\n  -Podrás disparar en cualquier casilla del tablero, salvo en las que ya has disparado.\n\n  -No puedes deshacer disparos ni propios ni de tus oponentes. Es un juego por turnos: haces tu disparo, si es \"agua\" el turno pasa a tu oponente; si \"tocas\" y/o hundes \n  un barco enemigo, vuelves a disparar.\n\n\n");
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 1101, 801);

        volverButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        volverButton.setText("Volver");
        volverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverButtonActionPerformed(evt);
            }
        });
        getContentPane().add(volverButton);
        volverButton.setBounds(1110, 310, 70, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverButtonActionPerformed
        dispose();
    }//GEN-LAST:event_volverButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(ComoJugarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComoJugarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComoJugarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComoJugarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ComoJugarFrame().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton volverButton;
    // End of variables declaration//GEN-END:variables
}