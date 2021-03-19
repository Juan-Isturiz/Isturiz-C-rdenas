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
public class BinaryTree {

    private Nodo proot;

    public BinaryTree() {
        this.proot = null;
    }

    /**
     * @return the proot
     */
    public Nodo getProot() {
        return proot;
    }

    /**
     * @param proot the proot to set
     */
    public void setProot(Nodo proot) {
        this.proot = proot;
    }
    public boolean is_Empty(){
        boolean empty = false;
        if (this.proot == null){
            empty = true;
        }
        return empty;
    }
    public void insert(String name, int clave) {
        Nodo inserted = new Nodo(name, clave);
        if (this.is_Empty()){
            this.setProot(inserted);
        }
        
    }

}
