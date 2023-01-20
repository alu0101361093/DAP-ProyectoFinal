package alu0101361093.proyectofinal.view;

import alu0101361093.proyectofinal.twitterdatasetcreator.TwitterDatasetCreator;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 * Initializes a PieChart to be shown in the scoreboard.
 * The PieChart is created according to the datasetCreator.
 */
public class TwitterPieChart implements TwitterView {

    TwitterDatasetCreator datasetCreator;

    public TwitterPieChart(TwitterDatasetCreator datasetCreator) {
        this.datasetCreator = datasetCreator;
    }

    public void setDatasetCreator(TwitterDatasetCreator datasetCreator) {
        this.datasetCreator = datasetCreator;
    }
    @Override
    public ChartPanel display(Object data1, Object data2, Object data3, Object data4, String name1, String name2, String name3, String name4) {
        PieDataset dataset = (DefaultPieDataset) datasetCreator.createDataset(data1, data2, data3, data4, name1, name2, name3, name4);

        JFreeChart barChart = ChartFactory.createPieChart(
                "Últimas 48h",
                dataset,
                true, false, false);

        return new ChartPanel(barChart);
    }
}
