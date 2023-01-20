package alu0101361093.proyectofinal.model;


import alu0101361093.proyectofinal.view.TwitterView;
import org.jfree.chart.ChartPanel;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public interface TwitterAPIModel {

    ArrayList<ChartPanel> getChartViews(String name1, String name2, String name3, String name4, ArrayList<TwitterView> viewTypes) throws IOException, URISyntaxException;

}
