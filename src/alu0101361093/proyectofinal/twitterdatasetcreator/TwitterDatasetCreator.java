package alu0101361093.proyectofinal.twitterdatasetcreator;

import org.jfree.data.general.Dataset;
import org.json.JSONObject;

/**
 * Interface for Dataset Creation for the scoreboard charts.
 * Using an interface and its implementations enables the use of the Strategy Pattern.
 */
public interface TwitterDatasetCreator {
    Dataset createDataset(Object data1, Object data2, Object data3, Object data4, String name1, String name2, String name3, String name4);
}
