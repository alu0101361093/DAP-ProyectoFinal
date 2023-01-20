package alu0101361093.proyectofinal.controller;

import alu0101361093.proyectofinal.model.TwitterAPIModel;
import alu0101361093.proyectofinal.twitterdatasetcreator.TwitterDatasetCreator;
import alu0101361093.proyectofinal.view.TwitterView;
import org.jfree.chart.ChartPanel;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Controller {

    private TwitterAPIModel model;

    public Controller(TwitterAPIModel model) {
        this.model = model;
    }

    public ArrayList<ChartPanel> getChartViews(String name1, String name2, String name3, String name4, ArrayList<TwitterView> views) {
        try {
            return model.getChartViews( name1, name2, name3, name4, views);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public void setModel(TwitterAPIModel model) {
        this.model = model;
    }

}
