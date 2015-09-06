package com.wicpar.testplugin;

import com.wicpar.sinkingsimulator2base.utils.Logger;
import com.wicpar.sinkingsimulator2base.utils.output.ILog;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Frederic on 03/09/2015.
 */
public class Window implements ILog{
    private JTextArea textArea1;
    private JPanel panel;
    private JScrollPane sp1;
    private JTextField textField1;
    private JButton button2;

    public Window() {
        button2.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                textField1.setText("");
                textArea1.setText(Logger.toLog(textField1.getText()));
            }
        });
        textArea1.setText(Logger.toLog());
        textField1.addKeyListener(new KeyAdapter() {
            /**
             * Invoked when a key has been typed.
             * This event occurs when a key press is followed by a key release.
             *
             * @param e
             */
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                textArea1.setText(Logger.toLog(textField1.getText()));
            }
        });
    }

    public static Window main() {
        Window w;
        JFrame frame = new JFrame("Window");
        frame.setContentPane((w = new Window()).panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        return w;
    }

    @Override
    public void onLog() {
        textArea1.setText(Logger.toLog(textField1.getText()));
        sp1.getVerticalScrollBar().setValue(sp1.getVerticalScrollBar().getMaximum());
    }
}
