import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {

    JLabel labelSubtitulo;

    JButton btnLanzar, btnParar, btnVer;

    public Menu (){

        componentes();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        setTitle("Menu operaciones para Tomcat");
    }

    public void componentes(){

        labelSubtitulo=new JLabel();
        labelSubtitulo.setBounds(70,25,180,20);
        labelSubtitulo.setText("Seleccione una opción:");
        add(labelSubtitulo);

        btnLanzar=new JButton();
        btnLanzar.setBounds(70,50,150,50);
        btnLanzar.setText("Lanzar Tomcat");
        add(btnLanzar);
        btnLanzar.addActionListener(this);

        btnParar=new JButton();
        btnParar.setBounds(70,100,150,50);
        btnParar.setText("Parar Tomcat");
        add(btnParar);
        btnParar.addActionListener(this);

        btnVer=new JButton();
        btnVer.setBounds(70,150,150,50);
        btnVer.setText("Ver estado Tomcat");
        add(btnVer);
        btnVer.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(btnLanzar)){
            String comandoLanzar = "/Library/Tomcat/bin/startup.sh";
            try {
                Process p = Runtime.getRuntime().exec(comandoLanzar);
            } catch (Exception ex) {
                System.out.println("Error al ejecutar el comando: " + comandoLanzar);
                ex.printStackTrace();
            }
            System.out.println("Se ha iniciado el servicio");
        }

        if (e.getSource().equals(btnParar)){
            String comandoParar = "/Library/Tomcat/bin/shutdown.sh";
            try {
                Process p = Runtime.getRuntime().exec(comandoParar);
            } catch (Exception ex) {
                System.out.println("Error al ejecutar el comando: " + comandoParar);
                ex.printStackTrace();
            }
            System.out.println("Se ha parado el servicio");
        }

        if (e.getSource().equals(btnVer)){
            String comandoVer = "/Applications/Firefox.app/Contents/MacOS/firefox  http://localhost:8080/";
            try {
                Process p = Runtime.getRuntime().exec(comandoVer);
            } catch (Exception ex) {
                System.out.println("Error al ejecutar el comando: " + comandoVer);
                ex.printStackTrace();
            }
            System.out.println("Se ha pulsado el botón VER");
        }

    }
}
