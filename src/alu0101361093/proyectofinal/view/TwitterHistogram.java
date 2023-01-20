package alu0101361093.proyectofinal.view;

import alu0101361093.proyectofinal.twitterdatasetcreator.TwitterDatasetCreator;
import alu0101361093.proyectofinal.twitterdatasetcreator.TwitterHistogramDatasetCreator;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;

import javax.swing.*;
import java.awt.*;

/**
 * Initializes a Histogram to be shown in the scoreboard.
 * The Histogram is created according to the datasetCreator.
 */
public class TwitterHistogram implements TwitterView {

    private TwitterDatasetCreator datasetCreator;

    public TwitterHistogram(TwitterDatasetCreator twitterDatasetCreator) {
        this.datasetCreator = twitterDatasetCreator;
    }

    public void setDatasetCreator(TwitterDatasetCreator datasetCreator) {
        this.datasetCreator = datasetCreator;
    }


    @Override
    public ChartPanel display(Object data1, Object data2, Object data3, Object data4, String name1, String name2, String name3, String name4) {

        DefaultCategoryDataset dataset = (DefaultCategoryDataset) datasetCreator.createDataset(data1, data2, data3, data4, name1, name2, name3, name4);

        JFreeChart chart = ChartFactory.createBarChart(
                "Tweets por día",
                "",
                "Tweets",
                dataset,
                PlotOrientation.VERTICAL,
                true, false, false);

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);

        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(750,400));
        chartPanel.revalidate();

        return chartPanel;
    }

}
