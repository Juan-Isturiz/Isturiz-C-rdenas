/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Primitivas;

import javax.swing.JOptionPane;

/**
 * Clase para los Arboles binarios Clase Arbol binario se crea sin parametros
 * obligatorios
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

    /**
     *
     * @return boolean empty que determina si el arbol está vacío
     */
    public boolean is_Empty() {
        boolean empty = false;
        if (this.proot == null) {
            empty = true;
        }
        return empty;
    }

    public void insert(String name, int clave) {
        Nodo inserted = new Nodo(name, clave);
        if (this.is_Empty()) {
            this.setProot(inserted);
        } else {
            Nodo aux = proot;
            boolean finish = false;
            while (!finish) {
                if (inserted == aux) {
                    JOptionPane.showMessageDialog(null, "El nodo que desea insertar ya existe");
                    finish = true;
                } else if (inserted.getClave() < aux.getClave()) {
                    
                }
            }
        }
    }

}
