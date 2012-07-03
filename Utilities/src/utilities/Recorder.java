package utilities;

/*s
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author Shivanth
 */
public class Recorder extends ApplicationFrame{
    //ArrayList<String> types=new ArrayList<String>();
    public HashMap<String,XYSeries> data = new HashMap<>();
    public XYSeriesCollection sc = new XYSeriesCollection();
    static public JFreeChart chart;
    static public ChartPanel chartPanel;
/**
 *
 * @param Chart_name The name of the chart that will be displayed at the end
 */
    public Recorder(String Chart_name) {
        super(Chart_name);
    }


    /**
     *
     * @param graph A new line graph added to the Chart - Can add add any number of line graph to a chart
     */
    public void add_type(String graph){
        //types.add(s);
        data.put(graph,new XYSeries(graph));

    }

/**
 *
 * @param ycor The value at Y-axis for the graph
 * @param xcor The value at X-axis for the graph
 * @param type The line graph for which the (x,y) pair forms a set
 * @throws Exception Key not found,if the line graph represented by string type was not added using add_type
 */
     void Record(int ycor,int xcor,String type) throws Exception{
        if(!data.containsKey(type)){
            throw new Exception("Key Not found");
        }
        else {
            ((XYSeries)(data.get(type))).add(xcor,ycor);
        }
}
     /**
 *
 * @param ycor The value at Y-axis for the graph
 * @param xcor The value at X-axis for the graph
 * @param type The line graph for which the (x,y) pair forms a set
 * @throws Exception Key not found,if the line graph represented by string type was not added using add_type
 */
     void Record(float i,int factor,String type) throws Exception{
        if(!data.containsKey(type)){
            throw new Exception("Key Not found");
        }
        else {
            ((XYSeries)(data.get(type))).add(factor,i);
        }
}
     /**
      *
      * @param x Label for X-axis
      * @param y Label for Y-axis
      */

     void draw(String x,String y) {
         for(XYSeries s : data.values()){
             sc.addSeries(s);
         }
         chart = ChartFactory.createXYLineChart(
                "Output", // chart title
                x, // x axis label
                y, // y axis label
                sc, // data
                PlotOrientation.VERTICAL,
                true, // include legend
                true, // tooltips
                false // urls
                );
        chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        chartPanel.setVisible(true);
        ApplicationFrame f1 = new ApplicationFrame("Scores");
        f1.setContentPane(chartPanel);
        f1.setSize(1000, 1000);
        f1.setVisible(true);
        try {
            Thread.sleep(100000);
            //return f1;
        } catch (InterruptedException ex) {
            Logger.getLogger(Recorder.class.getName()).log(Level.SEVERE, null, ex);
        }

     }
}
