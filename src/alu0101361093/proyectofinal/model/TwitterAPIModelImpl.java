package alu0101361093.proyectofinal.model;

import alu0101361093.proyectofinal.gui.BalancedScoreboard;
import alu0101361093.proyectofinal.twitter.TwitterAPIQueries;
import alu0101361093.proyectofinal.twitterdatasetcreator.BarChartDatasetCreator;
import alu0101361093.proyectofinal.twitterdatasetcreator.PieChartDatasetCreator;
import alu0101361093.proyectofinal.twitterdatasetcreator.TwitterDatasetCreator;
import alu0101361093.proyectofinal.view.TwitterBarChart;
import alu0101361093.proyectofinal.view.TwitterPieChart;
import alu0101361093.proyectofinal.view.TwitterView;
import org.jfree.chart.ChartPanel;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * Model for Twitter API Queries. Returns the information provided by the API.
 */
public class TwitterAPIModelImpl implements TwitterAPIModel {

    private static final String BEARER_TOKEN = "AAAAAAAAAAAAAAAAAAAAAOJ%2BkQEAAAAAQLjIy%2B6b4v%2BlFIo%2FghEqAekxlLg%3D5HWnCvS1TyIACaQxpSjD6hYPnZJp45yB3uG1HGYGcRrHHxeW1I";

    private String getTweetCounts(String searchParameter) throws IOException, URISyntaxException {
        return TwitterAPIQueries.getTweetCounts(searchParameter, BEARER_TOKEN);
    }

    @Override
    public ArrayList<ChartPanel> getChartViews(String name1, String name2, String name3, String name4, ArrayList<TwitterView> viewTypes) throws IOException, URISyntaxException {

        //Initialize empty JSONs
        JSONObject data1 = new JSONObject();
        JSONObject data2 = new JSONObject();
        JSONObject data3 = new JSONObject();
        JSONObject data4 = new JSONObject();

        //Retrieve the tweet data from the controller
        if (name1 != null)
            data1 = new JSONObject(getTweetCounts(name1));
        if (name2 != null)
            data2 = new JSONObject(getTweetCounts(name2));
        if (name3 != null)
            data3 = new JSONObject(getTweetCounts(name3));
        if (name4 != null)
            data4 = new JSONObject(getTweetCounts(name4));

        ArrayList<ChartPanel> chartPanels = new ArrayList<>();

        for (TwitterView view : viewTypes)
            chartPanels.add(view.display(data1, data2, data3, data4, name1, name2, name3, name4));

        return chartPanels;

    }

}
