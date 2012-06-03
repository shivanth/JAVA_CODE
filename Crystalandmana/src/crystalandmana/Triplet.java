/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crystalandmana;

/**
 *
 * @author Shivanth
 */
public class Triplet {
    private int r;
    private int g;
    private int b;
    private int product;

    /**
     * @return the r
     */
    public int getR() {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(int r) {
        this.r = r;
    }

    /**
     * @return the g
     */
    public int getG() {
        return g;
    }

    /**
     * @param g the g to set
     */
    public void setG(int g) {
        this.g = g;
    }

    /**
     * @return the b
     */
    public int getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(int b) {
        this.b = b;
    }

    /**
     * @return the product
     */
    public int getProduct() {
        return product;
    }
    /**
     * @param r r to set
     * @param g g to set
     * @param b b to set
     */
    public Triplet(int r,int g,int b){
        this.r=r;
        this.g=g;
        this.b=b;
    }
    public void recalculate_terms(){
        product=r*g*b;
    }
    
    
}
