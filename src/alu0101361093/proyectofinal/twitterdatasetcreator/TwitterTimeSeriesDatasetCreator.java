package alu0101361093.proyectofinal.twitterdatasetcreator;

import org.jfree.data.general.Dataset;
import org.jfree.data.time.*;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Locale;

/**
 * Creates a specific Dataset to initialize a TimeSeries in the Scoreboard
 */
public class TwitterTimeSeriesDatasetCreator implements TwitterDatasetCreator {

    private static DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ").withLocale(Locale.US);

    @Override
    public Dataset createDataset(Object data1, Object data2, Object data3, Object data4, String name1, String name2, String name3, String name4) {
        final TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.setDomainIsPointsInTime(true);

        if (!name1.isEmpty() && !name1.equals("#") && !name1.equals("@") && (name1 != null)) {
            final TimeSeries s1 = new TimeSeries(name1, Minute.class);
            for (Object o : (JSONArray) ( (JSONObject) data1).get("data") ) {
                JSONObject jsonObject = (JSONObject) o;
                LocalDateTime recordTime = formatter.parseLocalDateTime((String) jsonObject.get("start"));
                LocalDate recordDate = formatter.parseLocalDate((String) jsonObject.get("start"));
                s1.add(new Minute(recordTime.getMinuteOfHour(), recordTime.getHourOfDay(), recordDate.getDayOfMonth(), recordDate.getMonthOfYear(), recordDate.getYear()), (int) jsonObject.get("tweet_count"));
            }
            dataset.addSeries(s1);
        }
        if (!name2.isEmpty() && !name2.equals("#") && !name2.equals("@") && (name2 != null)) {
            final TimeSeries s2 = new TimeSeries(name2, Minute.class);
            for (Object o : (JSONArray) ( (JSONObject) data2).get("data") ) {
                JSONObject jsonObject = (JSONObject) o;
                LocalDateTime recordTime = formatter.parseLocalDateTime((String) jsonObject.get("start"));
                LocalDate recordDate = formatter.parseLocalDate((String) jsonObject.get("start"));
                s2.add(new Minute(recordTime.getMinuteOfHour(), recordTime.getHourOfDay(), recordDate.getDayOfMonth(), recordDate.getMonthOfYear(), recordDate.getYear()), (int) jsonObject.get("tweet_count"));}
            dataset.addSeries(s2);
        }
        if (!name3.isEmpty() && !name3.equals("#") && !name3.equals("@") && (name3 != null)) {
            final TimeSeries s3 = new TimeSeries(name3, Minute.class);
            for (Object o : (JSONArray) ( (JSONObject) data3).get("data") ) {
                JSONObject jsonObject = (JSONObject) o;
                LocalDateTime recordTime = formatter.parseLocalDateTime((String) jsonObject.get("start"));
                LocalDate recordDate = formatter.parseLocalDate((String) jsonObject.get("start"));
                s3.add(new Minute(recordTime.getMinuteOfHour(), recordTime.getHourOfDay(), recordDate.getDayOfMonth(), recordDate.getMonthOfYear(), recordDate.getYear()), (int) jsonObject.get("tweet_count"));}
            dataset.addSeries(s3);
        }
        if (!name4.isEmpty() && !name4.equals("#") && !name4.equals("@") && (name4 != null)) {
            final TimeSeries s4 = new TimeSeries(name4, Minute.class);
            for (Object o : (JSONArray) ( (JSONObject) data4).get("data") ) {
                JSONObject jsonObject = (JSONObject) o;
                LocalDateTime recordTime = formatter.parseLocalDateTime((String) jsonObject.get("start"));
                LocalDate recordDate = formatter.parseLocalDate((String) jsonObject.get("start"));
                s4.add(new Minute(recordTime.getMinuteOfHour(), recordTime.getHourOfDay(), recordDate.getDayOfMonth(), recordDate.getMonthOfYear(), recordDate.getYear()), (int) jsonObject.get("tweet_count"));}
            dataset.addSeries(s4);
        }

        return dataset;

    }
}
