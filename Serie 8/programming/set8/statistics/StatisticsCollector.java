package programming.set8.statistics;
import java.util.ArrayList;
import java.util.Iterator;

public class StatisticsCollector {
    ArrayList list = new ArrayList();
    
    /**
     * adds a single parameter of type double to a list of numbers
     * @param item
     */
    public void addItem(double item){
        list.add(item);
    }
    
    /**
     * Returns the number of objects in the list
     * @return number of objects in the list
     */
    public int getCount(){
        return list.size();
    }
    
    /**
     * adds all numbers in the list
     * @return sum of all numbers in the list
     */
    public double getSum(){
        Iterator it = list.iterator();
        double sum = 0;
        while (it.hasNext()){ //runs until there is no next object in the list
            sum += (double)it.next(); //cast object to double 
        }
        return sum;
    }
    
    /**
     * returns the minimum item added so far
     * @return minimum Item
     */
    public double getMinimum(){
        if (list.size() == 0) return Double.POSITIVE_INFINITY;
        Iterator it = list.iterator();
        double min = Math.pow(1*10, 1000000000);
        double next = 0;
        while (it.hasNext()){
            next = (double)it.next();
            if (min > next){
                min = next;
            }
        }
        return min;
    }
    
    /**
     * returns the maximum item added so far
     * @return maximum item
     */
    public double getMaximum(){
        if (list.size() == 0) return Double.NEGATIVE_INFINITY;
        Iterator it = list.iterator();
        double max = 0;
        double next = 0;
        while (it.hasNext()){
            next = (double)it.next();
            if (max < next){
                max = next;
            }
        }
        return max;
    }
    
    /**
     * returns the average of all numbers in the list
     * @return average
     */
    public double getAverage(){
        if (list.size() == 0) return 0;
        return getSum()/list.size();
    }
    
    /**
     * returns the standard deviation of all numbers in the list
     * @return standard deviation
     */
    public double getStandardDeviation(){
        if (list.size() == 0) return 0;
        Iterator it = list.iterator();
        double n = 0;
        while (it.hasNext()){
            n += Math.pow(((double)it.next() - getAverage()), 2);
        }
        return Math.sqrt(n/list.size());
    }
    

}