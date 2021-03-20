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
    private Nodo padre;
    private String name;
    private int height;

    public Nodo(String name, int clave) {
        this.clave = clave;
        this.left = null;
        this.right = null;
        this.name = name;
        this.padre = null;
        this.height = 1;
    }

    /**
     * @return the clave
     */
    public int getHeight(){
        return height;
    }
    public void setHeight(int height){
        this.height = 1;
    }
    
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

    public boolean is_Leaf() {
        boolean leif = false;
        if (right == null && left == null) {
            leif = true;
        }
        return leif;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the padre
     */
    public Nodo getPadre() {
        return padre;
    }

    /**
     * @param padre the padre to set
     */
    public void setPadre(Nodo padre) {
        this.padre = padre;
    }
    public void release(Nodo released){
        if(released.getClave() == left.getClave()){
            left.setPadre(null);
            this.setLeft(null);
        }
        else if(released.getClave() == right.getClave()){
            right.setPadre(null);
            this.setRight(null);
        }
    }

}
