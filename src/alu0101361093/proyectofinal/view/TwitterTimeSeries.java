package alu0101361093.proyectofinal.view;

import alu0101361093.proyectofinal.twitterdatasetcreator.TwitterDatasetCreator;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.xy.XYDataset;

import java.awt.*;

/**
 * Initializes a TimeSeries to be shown in the scoreboard.
 * The TimeSeries is created according to the datasetCreator.
 */
public class TwitterTimeSeries implements TwitterView {


    private TwitterDatasetCreator datasetCreator;

    public TwitterTimeSeries(TwitterDatasetCreator twitterDatasetCreator) {
        this.datasetCreator = twitterDatasetCreator;
    }

    public void setDatasetCreator(TwitterDatasetCreator datasetCreator) {
        this.datasetCreator = datasetCreator;
    }


    @Override
    public ChartPanel display(Object data1, Object data2, Object data3, Object data4, String name1, String name2, String name3, String name4) {

        XYDataset dataset = (XYDataset) datasetCreator.createDataset(data1, data2, data3, data4, name1, name2, name3, name4);

        final JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Línea de tiempo",
                "Día",
                "Nº Tweets",
                dataset,
                true,
                true,
                false
        );

        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(750,400));
        chartPanel.revalidate();

        return chartPanel;
    }
}
