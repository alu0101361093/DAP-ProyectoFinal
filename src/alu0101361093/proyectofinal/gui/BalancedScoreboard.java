package alu0101361093.proyectofinal.gui;

import alu0101361093.proyectofinal.controller.Controller;
import alu0101361093.proyectofinal.model.TwitterAPIModelImpl;
import alu0101361093.proyectofinal.twitterdatasetcreator.BarChartDatasetCreator;
import alu0101361093.proyectofinal.twitterdatasetcreator.PieChartDatasetCreator;
import alu0101361093.proyectofinal.twitterdatasetcreator.TwitterHistogramDatasetCreator;
import alu0101361093.proyectofinal.twitterdatasetcreator.TwitterTimeSeriesDatasetCreator;
import alu0101361093.proyectofinal.view.*;
import org.jfree.chart.ChartPanel;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BalancedScoreboard extends JFrame {
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    private int button1State, button2State, button3State, button4State;

    private String searchOperator1, searchOperator2, searchOperator3, searchOperator4;

    private JButton mostrarButton;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JButton modoAutomáticoNoButton;

    boolean automaticMode;

    TwitterView view1, view2, view3, view4;

    private Controller controller = new Controller(new TwitterAPIModelImpl());

    private ActionListener automaticModeActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            showCharts();
        }

    };

    private Timer timer = new Timer(5000, automaticModeActionListener);

    public static void main(String[] args) {
        JFrame frame = new BalancedScoreboard();
        frame.setVisible(true);
    }

    private void setViews(TwitterView view1, TwitterView view2, TwitterView view3, TwitterView view4) {
        this.view1 = view2;
        this.view2 = view2;
        this.view3 = view3;
        this.view4 = view4;
    }

    public BalancedScoreboard() {
        super("BalancedScoreboard");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

        button1State = 0;
        button2State = 0;
        button3State = 0;
        button4State = 0;
        automaticMode = false;

        //Create the charts
        view1 = new TwitterBarChart(new BarChartDatasetCreator());
        view2 = new TwitterPieChart(new PieChartDatasetCreator());
        view3 = new TwitterHistogram(new TwitterHistogramDatasetCreator());
        view4 = new TwitterTimeSeries(new TwitterTimeSeriesDatasetCreator());

        button1.addActionListener(e -> {
            if (button1State == 0) {
                button1State++;
                button1.setText("#");
                searchOperator1 = "#";
            } else if (button1State == 1) {
                button1State++;
                button1.setText("\uD83D\uDD0E");
                searchOperator1 = "";
            } else if (button1State == 2) {
                button1State = 0;
                button1.setText("@");
                searchOperator1 = "@";
            }
        });
        button2.addActionListener(e -> {
                if (button2State == 0) {
                    button2State++;
                    button2.setText("#");
                    searchOperator2 = "#";
                }
                else if (button2State == 1) {
                    button2State++;
                    button2.setText("\uD83D\uDD0E");
                    searchOperator2 = "";
                }
                else if (button2State == 2) {
                    button2State = 0;
                    button2.setText("@");
                    searchOperator2 = "@";
                }
        });
        button3.addActionListener(e -> {
            if (button3State == 0) {
                button3State++;
                button3.setText("#");
                searchOperator3 = "#";
            }
            else if (button3State == 1) {
                button3State++;
                button3.setText("\uD83D\uDD0E");
                searchOperator3 = "";
            }
            else if (button3State == 2) {
                button3State = 0;
                button3.setText("@");
                searchOperator3 = "@";
            }
        });
        button4.addActionListener(e -> {
            if (button4State == 0) {
                button4State++;
                button4.setText("#");
                searchOperator4 = "#";
            }
            else if (button4State == 1) {
                button4State++;
                button4.setText("\uD83D\uDD0E");
                searchOperator4 = "";
            }
            else if (button4State == 2) {
                button4State = 0;
                button4.setText("@");
                searchOperator4 = "@";
            }
        });

        modoAutomáticoNoButton.addActionListener(e -> {
            if (!automaticMode) {
                automaticMode = true;
                modoAutomáticoNoButton.setText("Modo automático: Sí");
            }
            else if (automaticMode) {
                automaticMode = false;
                modoAutomáticoNoButton.setText("Modo automático: No");
            }

        });

        mostrarButton.addActionListener(e -> {
            showCharts();
        });

    }



    // HASHTAG: getTweetCounts("#pokemon", bearerToken);
    // BÚSQUEDA: getTweetCounts("Pokémon", bearerToken); -- CONTIENE EXACTAMENTE ESA FRASE
    //MENCIONES: getTweetCounts("@ull", bearerToken);

    private void showCharts() {

        //Clear the previously created panels
        clearPanels();

        // Get the search parameters
        String name1 = textField1.getText();
        if (searchOperator1 != null)
            name1 = searchOperator1 + name1;

        String name2 = textField2.getText();
        if (searchOperator2 != null)
            name2 = searchOperator2 + name2;

        String name3 = textField3.getText();
        if (searchOperator3 != null)
            name3 = searchOperator3 + name3;

        String name4 = textField4.getText();
        if (searchOperator4 != null)
            name4 = searchOperator4 + name4;

        panel1.setLayout(new java.awt.BorderLayout());
        panel2.setLayout(new java.awt.BorderLayout());
        panel3.setLayout(new java.awt.BorderLayout());
        panel4.setLayout(new java.awt.BorderLayout());

        ArrayList<TwitterView> views = new ArrayList<>();
        views.add(view1);
        views.add(view2);
        views.add(view3);
        views.add(view4);


        final ArrayList<ChartPanel> chartPanels = controller.getChartViews(name1, name2, name3, name4, views);

        final ChartPanel chartPanel1 = chartPanels.get(0);
        final ChartPanel chartPanel2 = chartPanels.get(1);
        final ChartPanel chartPanel3 = chartPanels.get(2);
        final ChartPanel chartPanel4 = chartPanels.get(3);

        chartPanel1.setPreferredSize(new Dimension(500,400));
        chartPanel2.setPreferredSize(new Dimension(500,400));
        chartPanel3.setPreferredSize(new Dimension(500,400));
        chartPanel4.setPreferredSize(new Dimension(500,400));

        panel1.add(chartPanel1, BorderLayout.CENTER);
        panel1.validate();

        chartPanel2.setPreferredSize(new Dimension(500,400));
        panel2.add(chartPanel2, BorderLayout.CENTER);
        panel2.validate();

        chartPanel3.setPreferredSize(new Dimension(500,400));
        panel3.add(chartPanel3, BorderLayout.CENTER);
        panel3.validate();

        chartPanel4.setPreferredSize(new Dimension(500,400));
        panel4.add(chartPanel4, BorderLayout.CENTER);
        panel4.validate();

        pack();
        setLocationRelativeTo(null);

        if (automaticMode) {
            timer.start();
        }

    }

    /**
     * Clears the chart panels of the scoreboard
     */
    private void clearPanels() {
        panel1.removeAll();
        panel2.removeAll();
        panel3.removeAll();
        panel4.removeAll();
    }
}
