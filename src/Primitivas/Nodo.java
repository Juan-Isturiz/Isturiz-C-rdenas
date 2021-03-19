/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Primitivas;

/**
 *
 * @author yunch
 */
public class Nodo {
    private int clave;
    private Nodo left;
    private Nodo right;
    public Nodo(){
        this.clave = 0;
        this.left = null;
        this.right = null;
    }

    /**
     * @return the clave
     */
    public int getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(int clave) {
        this.clave = clave;
    }

    /**
     * @return the left
     */
    public Nodo getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(Nodo left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public Nodo getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(Nodo right) {
        this.right = right;
    }
    public boolean is_Leaf(){
        boolean leif = false;
        if (right==null && left==null){
            leif = true;
        }
        return leif;
    }
}
