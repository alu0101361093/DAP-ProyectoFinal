package alu0101361093.proyectofinal.view;

import org.jfree.chart.ChartPanel;

/**
 * Observer, subscribes to the subject (Controller).
 * When the Controller changes it notifies the View that a change took place,
 * Then the View is changed.
 */
public interface TwitterView {

    ChartPanel display(Object data1, Object data2, Object data3, Object data4, String name1, String name2, String name3, String name4);

}
