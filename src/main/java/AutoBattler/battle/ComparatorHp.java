package AutoBattler.battle;

import java.util.Comparator;
import AutoBattler.entities.*;

public class ComparatorHp implements Comparator<Fighter>{

    @Override
    /**
     * Method to compare fighters by descending hit points
     * @param o1 The first fighter to compare with the second
     * @param o2 The second fighter to compare with the first
     * @return -1 if the first fighter has fewer hit points than the second
     * 1 if it's the opposite, and 0 if they have the same hit points
     * Returns -1 if hit points are equal and the first fighter's id is less than the second's
     * Returns 1 if hit points are equal and the second fighter's id is less than the first's
     * Returns 0 otherwise
     */
    public int compare(Fighter o1, Fighter o2) {
        Fighter f1 = (Fighter) o1;
        Fighter f2 = (Fighter) o2;
        if (f1.getHp() < f2.getHp()){
            return -1;
        }
        if (f1.getHp() > f2.getHp()){
            return 1;
        }
        if (f1.getId() < f2.getId()){
            return -1;
        }
        if (f1.getId() > f2.getId()) {
            return 1;
        }
        return 0;
    }
}
