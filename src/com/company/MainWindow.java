package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventListener;

public class MainWindow extends JFrame  {
    Counter counter = new Counter();
    Container mainContainer;

    JTextField countText;

    JButton plusButton;
    JButton minusButton;

    JPanel mainPanel;
    JPanel counterInterface;

    public MainWindow() {
        createMainPanel();

        mainContainer = this.getContentPane();
        this.setLayout(new BorderLayout());

        this.add(mainPanel, BorderLayout.CENTER);

        createCounterInterface();

        mainPanel.add(counterInterface);
    }

    void createMainPanel() {
        mainPanel = new JPanel(new GridBagLayout());

        mainPanel.setBackground(new Color(47, 49, 54));
    }

    void createCounterInterface() {
        countText = new JTextField(counter.getCounter());
        countText.setPreferredSize(new Dimension(50, 30));
        countText.setHorizontalAlignment(SwingConstants.RIGHT);
        countText.setEditable(false);

        minusButton = new JButton("-");
        minusButton.setFocusPainted(false);
        minusButton.setBackground(new Color(237, 66, 69));
        minusButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        minusButton.setBorder(new MatteBorder(5, 20, 5, 20, new Color(237, 66, 69)));
        minusButton.setForeground(new Color(255, 255, 255));
        minusButton.addActionListener(new CounterMinusHandler());

        plusButton = new JButton("+");
        plusButton.setFocusPainted(false);
        plusButton.setBackground(new Color(237, 66, 69));
        plusButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        plusButton.setBorder(new MatteBorder(5, 20, 5, 20, new Color(237, 66, 69)));
        plusButton.setForeground(new Color(255, 255, 255));
        plusButton.addActionListener(new CounterPlusHandler());

        counterInterface = new JPanel(new FlowLayout(FlowLayout.CENTER));
        counterInterface.setBackground(new Color(47, 49, 54));

        counterInterface.add(minusButton);
        counterInterface.add(countText);
        counterInterface.add(plusButton);
    }

    class CounterPlusHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int count = Integer.parseInt(counter.getCounter());
            count = count + 1;
            counter.setCounter(Integer.toString(count));
            countText.setText(counter.getCounter());
        }
    }

    class CounterMinusHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int count = Integer.parseInt(counter.getCounter());
            count = count - 1;
            counter.setCounter(Integer.toString(count));
            countText.setText(counter.getCounter());
        }
    }
}