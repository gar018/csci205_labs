/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Name: Gordon Rose* Section: 01 - 9:00AM-9:50AM
 * Date: 10/19/22* Time: 11:10 PM
 *
 * Project: csci205_labs
 * Package: lab10.ex4
 * Class: CarScatterPlot
 *
 * Description: Scatter Plot object encapsulating a scatter plot of car data
 *
 *
 ****************************************
 */

package lab10.ex4;

import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import lab10.Car;

import java.util.ArrayList;

/**
 * a class that represents a ScatterPlot object, including
 * the data that will be plotted onto the axes
 */
public class CarScatterPlot {
    private ArrayList<Car> cars;

    private NumberAxis xAxis;
    private NumberAxis yAxis;

    private XYChart.Series<Number,Number> series;

    private ScatterChart<Number,Number> chart;

    /**
     * instantiation of the CarScatterPlot to encapsulate our data
     * @param cars
     */
    public CarScatterPlot(ArrayList<Car> cars) {
        this.cars = cars;

        //Instantiation of our ScatterChart Objects
        this.xAxis = new NumberAxis();
        this.yAxis = new NumberAxis();
        this.series = new XYChart.Series<>();

        //instantiate a ScatterChart object
        this.chart = new ScatterChart<>(xAxis,yAxis);
    }

    /**
     * encapsulate the variables to be plotted into the series, then add the series to the chart
     */
    public void plot() {
        //set title
        chart.setTitle("Weight vs. MPG for automobiles");

        //set labels
        yAxis.setLabel("Weight");
        xAxis.setLabel("MPG");

        //add data for each car instance

        cars.stream()
                .forEach(car -> {
                    XYChart.Data<Number,Number> datum = new XYChart.Data<>(car.getWeight(),car.getMpg());
                    series.getData().add(datum);
                });
        series.setName("Series 1");
        chart.getData().add(series);
    }

    public ScatterChart<Number, Number> getChart() {
        return chart;
    }
}
