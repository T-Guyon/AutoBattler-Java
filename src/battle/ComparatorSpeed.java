package battle;

import java.util.Comparator;
import entities.*;

public class ComparatorSpeed implements Comparator<Fighter>{
    
    @Override
    /**
    * Method to compare fighters by decreasing speed
    * @param o1 The first fighter to compare with the second
    * @param o2 The second fighter to compare with the first
    * @return 1 if the speed of the first fighter is less than that of the second
    *        -1 if it is the opposite
    *         1 if the speeds are equal and the id of the first fighter is less than that of the second
    *        -1 if the speeds are equal and the id of the second fighter is less than that of the first
    *         0 otherwise
    */
    public int compare(Fighter o1, Fighter o2) {
        Fighter f1 = (Fighter) o1;
        Fighter f2 = (Fighter) o2;
        if(f1.getSpeed() < f2.getSpeed()){ 
            return 1;
        }
        if(f1.getSpeed() > f2.getSpeed()){
            return -1;
        }
        if(f1.getId() < f2.getId()){
            return -1;
        }
        if (f1.getId() > f2.getId()) {
            return 1;
        }
        return 0;
    }
}
