package crystalandmana;

import java.util.Comparator;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author Shivanth
 */
public class Triplet_comparator implements Comparator<Object> {

    @Override
    public int compare(Object a, Object b) {
        Triplet first = (Triplet) a;
        Triplet second = (Triplet) b;

        if (first.getProduct() > second.getProduct()) {
            return 1;
        } else if (first.getProduct() == second.getProduct()) {
            return 0;
        } else {
            return -1;
        }
    }
}
