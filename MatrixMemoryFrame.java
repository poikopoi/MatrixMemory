package tasks.MyTasksGUI.MatrixMemoryPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Наташа on 28.06.2016.
 */
public class MatrixMemoryFrame extends JFrame{
    private ArrayList<Integer> buttonArrayList = new ArrayList<>();
    private int x = 2;
    private int y = 1;
    private JPanel panelGrid;
    private Color buttonColor;
    private JPanel panelCenter;
    private Timer t;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MatrixMemoryFrame frame = new MatrixMemoryFrame();
            }
        });
    }

    private MatrixMemoryFrame() {
        setTitle("MatrixMemory");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        createGUI();
        setVisible(true);
    }

    private void createGUI() {
        panelGrid = new JPanel();
        panelGrid.setLayout(new GridLayout(x,x));
        panelGrid.setBorder(BorderFactory.createLineBorder(Color.GREEN, 10, true));
        int forMemory = x*x-x-y;
        buttonArrayList.clear();
        for (int i = 0; i <x*x ; i++) {
            if (forMemory > 0) {
                buttonArrayList.add(1);
                forMemory--;
            } else {
                buttonArrayList.add(0);
            }
            Collections.shuffle(buttonArrayList);
        }
        System.out.println(buttonArrayList.size());
        for (int i = 0; i<buttonArrayList.size(); i++) {
            System.out.println(buttonArrayList.get(i));
            if (buttonArrayList.get(i)==1) {
                buttonColor = new Color(0xFF1318);
            } else if (buttonArrayList.get(i)==0) {
                buttonColor = new Color(0xF0FF28);
            }
            panelGrid.add(addButton(buttonColor, "1"));
        }
        panelCenter = new JPanel();

        panelCenter.add(panelGrid);
        add(panelCenter);
        //panelCenter.remove(panelGrid);
        ActionListener listener = new TimerNewPanel();
        t= new Timer(5000, listener);
        t.start();
    }

    private JButton addButton(Color color, String  name) {
        JButton button = new JButton();
        button.setName(name);
        button.setBackground(color);
        button.setEnabled(false);
        button.setPreferredSize(new Dimension(60-x, 60-x));
        panelGrid.add(button);
        return button;
    }


    private class TimerNewPanel implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            t.stop();
            panelCenter.remove(panelGrid);
            repaint();
            System.out.println("Ho-ho!");
            //Toolkit.getDefaultToolkit().beep();

        }
    }
}
