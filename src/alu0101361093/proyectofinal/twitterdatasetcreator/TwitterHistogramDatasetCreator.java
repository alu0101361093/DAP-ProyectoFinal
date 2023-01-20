package alu0101361093.proyectofinal.twitterdatasetcreator;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.time.*;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Creates a specific Dataset to initialize a Histogram in the Scoreboard
 */
public class TwitterHistogramDatasetCreator implements TwitterDatasetCreator {

    private static DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ").withLocale(Locale.US);

    @Override
    public Dataset createDataset(Object data1, Object data2, Object data3, Object data4, String name1, String name2, String name3, String name4) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        if (!name1.isEmpty() || !(name1 == "#") || !(name1 == "@")) {
            for (Object o : (JSONArray) ( (JSONObject) data1).get("data") ) {
                JSONObject jsonObject = (JSONObject) o;
                LocalDateTime recordTime = formatter.parseLocalDateTime((String) jsonObject.get("start"));
                LocalDate recordDate = formatter.parseLocalDate((String) jsonObject.get("start"));
                String recordHourDayMonth =  recordDate.getDayOfMonth() + "-" + recordDate.getMonthOfYear() + "-" + recordTime.getHourOfDay();
                dataset.addValue( (int) jsonObject.get("tweet_count"), name1, new Hour(recordTime.getHourOfDay(), recordDate.getDayOfMonth(), recordDate.getMonthOfYear(), recordDate.getYear()));
            }
        }
        if (!name2.isEmpty() || !(name2 == "#") || !(name2 == "@")) {
            for (Object o : (JSONArray) ( (JSONObject) data2).get("data") ) {
                JSONObject jsonObject = (JSONObject) o;
                LocalDateTime recordTime = formatter.parseLocalDateTime((String) jsonObject.get("start"));
                LocalDate recordDate = formatter.parseLocalDate((String) jsonObject.get("start"));
                String recordHourDayMonth =  recordDate.getDayOfMonth() + "-" + recordDate.getMonthOfYear() + "-" + recordTime.getHourOfDay();
                dataset.addValue( (int) jsonObject.get("tweet_count"), name2, new Hour(recordTime.getHourOfDay(), recordDate.getDayOfMonth(), recordDate.getMonthOfYear(), recordDate.getYear()));}
        }
        if (!name3.isEmpty() || !(name3 == "#") || !(name3 == "@")) {
            for (Object o : (JSONArray) ( (JSONObject) data3).get("data") ) {
                JSONObject jsonObject = (JSONObject) o;
                LocalDateTime recordTime = formatter.parseLocalDateTime((String) jsonObject.get("start"));
                LocalDate recordDate = formatter.parseLocalDate((String) jsonObject.get("start"));
                String recordHourDayMonth =  recordDate.getDayOfMonth() + "-" + recordDate.getMonthOfYear() + "-" + recordTime.getHourOfDay();
                dataset.addValue( (int) jsonObject.get("tweet_count"), name3, new Hour(recordTime.getHourOfDay(), recordDate.getDayOfMonth(), recordDate.getMonthOfYear(), recordDate.getYear()));}
        }
        if (!name4.isEmpty() || !(name4 == "#") || !(name4 == "@")) {
            for (Object o : (JSONArray) ( (JSONObject) data4).get("data") ) {
                JSONObject jsonObject = (JSONObject) o;
                LocalDateTime recordTime = formatter.parseLocalDateTime((String) jsonObject.get("start"));
                LocalDate recordDate = formatter.parseLocalDate((String) jsonObject.get("start"));
                String recordHourDayMonth =  recordDate.getDayOfMonth() + "-" + recordDate.getMonthOfYear() + "-" + recordTime.getHourOfDay();
                dataset.addValue( (int) jsonObject.get("tweet_count"), name4, new Hour(recordTime.getHourOfDay(), recordDate.getDayOfMonth(), recordDate.getMonthOfYear(), recordDate.getYear()));}
        }

        return dataset;
    }
}
