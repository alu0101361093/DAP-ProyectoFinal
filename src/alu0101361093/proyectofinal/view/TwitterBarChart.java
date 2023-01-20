package alu0101361093.proyectofinal.view;

import alu0101361093.proyectofinal.twitterdatasetcreator.TwitterDatasetCreator;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;

/**
 * Initializes a BarChart to be shown in the scoreboard.
 * The BarChart is created according to the datasetCreator.
 */
public class TwitterBarChart implements TwitterView {

    TwitterDatasetCreator datasetCreator;

    public TwitterBarChart(TwitterDatasetCreator datasetCreator) {
        this.datasetCreator = datasetCreator;
    }

    public void setDatasetCreator(TwitterDatasetCreator datasetCreator) {
        this.datasetCreator = datasetCreator;
    }

    @Override
    public ChartPanel display(Object data1, Object data2, Object data3, Object data4, String name1, String name2, String name3, String name4) {

        DefaultCategoryDataset dataset = (DefaultCategoryDataset) datasetCreator.createDataset(data1, data2, data3, data4, name1, name2, name3, name4);

        JFreeChart barChart = ChartFactory.createBarChart(
                "Diagrama de barras",
                "",
                "Tweets",
                dataset,
                PlotOrientation.VERTICAL,
                true, false, false);


        final ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(750,400));
        chartPanel.revalidate();

        return chartPanel;
    }
}
