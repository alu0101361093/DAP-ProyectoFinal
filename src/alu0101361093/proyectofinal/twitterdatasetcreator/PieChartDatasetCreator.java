package alu0101361093.proyectofinal.twitterdatasetcreator;

import org.jfree.data.general.Dataset;
import org.jfree.data.general.DefaultPieDataset;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Creates a specific Dataset to initialize a PieChart in the Scoreboard
 */
public class PieChartDatasetCreator implements TwitterDatasetCreator {
    @Override
    public Dataset createDataset(Object data1, Object data2, Object data3, Object data4, String name1, String name2, String name3, String name4) {

        DefaultPieDataset dataset = new DefaultPieDataset();

        if (!name1.isEmpty() || !(name1 == "#") || !(name1 == "@")) {
            int count1 = 0;
            JSONObject jsonData1 = (JSONObject) data1;
            JSONArray array1 = (JSONArray) (jsonData1.get("data"));
            for (Object o : array1) {
                count1 += (int) ((JSONObject) o).get("tweet_count");
            }
            dataset.setValue(name1, count1);
        }
        if (!name2.isEmpty() || !(name2 == "#") || !(name2 == "@")) {
            int count2 = 0;
            JSONObject jsonData2 = (JSONObject) data2;
            JSONArray array2 = (JSONArray) (jsonData2.get("data"));
            for (Object o : array2)
                count2 += (int) ((JSONObject) o).get("tweet_count");
            dataset.setValue(name2, count2);
        }
        if (!name3.isEmpty() || !(name3 == "#") || !(name3 == "@")) {
            int count3 = 0;
            JSONObject jsonData3 = (JSONObject) data3;
            JSONArray array3 = (JSONArray) (jsonData3.get("data"));
            for (Object o : array3)
                count3 += (int) ((JSONObject) o).get("tweet_count");
            dataset.setValue(name3, count3);
        }
        if (!name4.isEmpty() || !(name4 == "#") || !(name4 == "@")) {
            int count4 = 0;
            JSONObject jsonData4 = (JSONObject) data4;
            JSONArray array4 = (JSONArray) (jsonData4.get("data"));
            for (Object o : array4)
                count4 += (int) ((JSONObject) o).get("tweet_count");
            dataset.setValue(name4, count4);
        }

        return dataset;
    }
}