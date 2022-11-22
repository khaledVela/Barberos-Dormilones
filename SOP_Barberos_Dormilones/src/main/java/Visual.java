import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Visual extends JFrame {
    JPanel menu = new JPanel();
    ArrayList<Persona> lista = new ArrayList<>();
    int contador = 0;
    int esp = 0;
    int cont = 1;
    int duerme = 3;
    int caje=0;
    boolean fin = false;
    JLabel foto = new JLabel(new ImageIcon("fondo.png"));
    JLabel espera = new JLabel(new ImageIcon("cliente.png"));
    JLabel espera1 = new JLabel(new ImageIcon("cliente.png"));
    JLabel espera2 = new JLabel(new ImageIcon("cliente.png"));
    JLabel espera3 = new JLabel(new ImageIcon("cliente.png"));
    JLabel silla = new JLabel(new ImageIcon("espera.png"));
    JLabel barbero = new JLabel(new ImageIcon("dormido.png"));
    JLabel barbero1 = new JLabel(new ImageIcon("dormido.png"));
    JLabel barbero2 = new JLabel(new ImageIcon("dormido.png"));
    JLabel normal = new JLabel(new ImageIcon("normal.png"));
    JLabel normal1 = new JLabel(new ImageIcon("normal.png"));
    JLabel normal2 = new JLabel(new ImageIcon("normal.png"));
    JLabel loco = new JLabel(new ImageIcon("loco.png"));
    JLabel loco1 = new JLabel(new ImageIcon("loco.png"));
    JLabel loco2 = new JLabel(new ImageIcon("loco.png"));
    JLabel espalda = new JLabel(new ImageIcon("espaldas.png"));
    JLabel espalda1 = new JLabel(new ImageIcon("espaldas.png"));
    JLabel espalda2 = new JLabel(new ImageIcon("espaldas.png"));
    JLabel cajero = new JLabel(new ImageIcon("cajero.png"));

    public Visual() {
        super("Barberos dormilones");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(500, 200);
        setSize(1000, 700);
        init();
    }


    public void init() {
        menu.setLayout(null);
        menu.setBackground(new Color(2, 19, 38));
        add(menu);

        foto.setBounds(0, 0, 2000, 1100);
        foto.setVisible(true);
        menu.add(foto, null);

        espera.setBounds(0, 0, 170, 150);
        espera.setVisible(false);
        foto.add(espera, null);
        espera1.setBounds(150, 0, 170, 150);
        espera1.setVisible(false);
        foto.add(espera1, null);
        espera2.setBounds(300, 0, 170, 150);
        espera2.setVisible(false);
        foto.add(espera2, null);
        espera3.setBounds(450, 0, 170, 150);
        espera3.setVisible(false);
        foto.add(espera3, null);

        silla.setBounds(0, 30, 600, 200);
        silla.setVisible(true);
        foto.add(silla, null);

        barbero.setBounds(50, 350, 220, 300);
        barbero.setVisible(true);
        foto.add(barbero, null);
        barbero1.setBounds(250, 350, 220, 300);
        barbero1.setVisible(true);
        foto.add(barbero1, null);
        barbero2.setBounds(450, 350, 220, 300);
        barbero2.setVisible(true);
        foto.add(barbero2, null);

        normal.setBounds(30, 367, 220, 300);
        normal.setVisible(false);
        foto.add(normal, null);
        normal1.setBounds(230, 367, 220, 300);
        normal1.setVisible(false);
        foto.add(normal1, null);
        normal2.setBounds(430, 367, 220, 300);
        normal2.setVisible(false);
        foto.add(normal2, null);

        loco.setBounds(30, 400, 220, 140);
        loco.setVisible(false);
        foto.add(loco, null);
        loco1.setBounds(230, 400, 220, 140);
        loco1.setVisible(false);
        foto.add(loco1, null);
        loco2.setBounds(430, 400, 220, 140);
        loco2.setVisible(false);
        foto.add(loco2, null);


        espalda.setBounds(650, 30, 220, 220);
        espalda.setVisible(false);
        foto.add(espalda, null);
        espalda1.setBounds(650, 180, 220, 220);
        espalda1.setVisible(false);
        foto.add(espalda1, null);
        espalda2.setBounds(650, 330, 220, 220);
        espalda2.setVisible(false);
        foto.add(espalda2, null);

        cajero.setBounds(700, 0, 220, 220);
        cajero.setVisible(true);
        foto.add(cajero, null);

        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem item1 = new JMenuItem("Nuevo Cliente");
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(esp);
                if (esp <= 3) {
                    espera.setVisible(false);
                    espera1.setVisible(false);
                    espera2.setVisible(false);
                    espera3.setVisible(false);
                }
                contador = lista.size();
                if ((contador <= 10) && (esp < 4)) {
                    Persona persona = new Persona();
                    System.out.println("Creo persona nueva");
                    lista.add(persona);
                    contador++;
                    esp = 0;
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getEspera() == true) {
                            esp++;
                            switch (esp) {
                                case 1:
                                    espera.setVisible(true);
                                    break;
                                case 2:
                                    espera1.setVisible(true);
                                    break;
                                case 3:
                                    espera2.setVisible(true);
                                    break;
                                case 4:
                                    espera3.setVisible(true);
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Todas las sillas estan ocupadas");
                }
            }
        });
        JMenuItem item2 = new JMenuItem("Next");
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                siguiente();
            }
        });
        menu.add(item2);
        menu.add(item1);
        bar.add(menu);
        this.setJMenuBar(bar);
    }

    public void siguiente() {
        switch (cont) {
            case 1:
                System.out.println("ir a cortar");
                cont++;
                for (int i = 0; i < lista.size(); i++) {
                    if (lista.get(i).getEspera() == true) {
                        esp--;
                        if (duerme > 0) {
                            lista.get(i).setEspera(false);
                            lista.get(i).setCortar(true);
                            switch (duerme) {
                                case 1:
                                    espera.setVisible(false);
                                    barbero.setVisible(false);
                                    switch (lista.get(i).getTipoCorte()) {
                                        case 1:
                                            loco.setVisible(true);
                                            break;
                                        case 2:
                                            normal.setVisible(true);
                                            break;
                                    }
                                    break;
                                case 2:
                                    espera.setVisible(false);
                                    espera1.setVisible(false);
                                    barbero1.setVisible(false);
                                    switch (lista.get(i).getTipoCorte()) {
                                        case 1:
                                            loco1.setVisible(true);
                                            break;
                                        case 2:
                                            normal1.setVisible(true);
                                            break;
                                    }
                                    break;
                                case 3:
                                    espera.setVisible(false);
                                    espera1.setVisible(false);
                                    espera2.setVisible(false);
                                    barbero2.setVisible(false);
                                    switch (lista.get(i).getTipoCorte()) {
                                        case 1:
                                            loco2.setVisible(true);
                                            break;
                                        case 2:
                                            normal2.setVisible(true);
                                            break;
                                    }
                                    break;
                            }
                            duerme--;
                            if((duerme==1)&&( lista.size()>3)){
                                espera3.setVisible(false);
                                espera.setVisible(true);
                                esp =1;
                            }
                        }
                    }
                }
                break;
            case 2:

                System.out.println("ir a cajero");
                cont++;
                duerme = 3;
                for (int i = 0; i < lista.size(); i++) {
                    if (lista.get(i).getCortar() == true) {
                        if (duerme > 0) {
                            loco.setVisible(false);
                            lista.get(i).setCortar(false);
                            lista.get(i).setPaga(true);
                            switch (duerme) {
                                case 1:
                                    normal.setVisible(false);
                                    barbero.setVisible(true);
                                    loco.setVisible(false);
                                    espalda2.setVisible(true);
                                    caje=1;
                                    break;
                                case 2:
                                    barbero1.setVisible(true);
                                    normal1.setVisible(false);
                                    loco1.setVisible(false);
                                    espalda1.setVisible(true);
                                    caje=2;
                                    break;
                                case 3:
                                    barbero2.setVisible(true);
                                    normal2.setVisible(false);
                                    loco2.setVisible(false);
                                    espalda.setVisible(true);
                                    caje=3;
                                    break;
                            }
                            duerme--;
                        }
                    }
                }
            case 3:
                cont=1;
                System.out.println("salir");
                if(lista.get(1).getPaga()==true){
                    lista.remove(lista.get(1));
                    switch (caje){
                        case 3:
                            espalda2.setVisible(false);
                            break;
                        case 2:
                            espalda1.setVisible(false);
                            break;
                        case 1:
                            espalda.setVisible(false);
                            break;
                    }
                    caje--;
                }
                lista.remove(lista.get(1));
                break;
        }
    }

    public static void main(String[] args) {
        Visual visual = new Visual();
        visual.setVisible(true);
    }
}
