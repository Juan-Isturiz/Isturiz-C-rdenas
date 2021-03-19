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
    /** Método para insertar nuevos nodos
     * Este método insertará un elemento dentro del arbol en su lugar correspondido
     * asegurandose de que no sea un valor repetido basado en clave
     * @param name nombre del nodo
     * @param clave clave de identificacción del nodo
     */
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
                    if (aux.getLeft() == null) {
                        aux.setLeft(inserted);
                        finish = true;
                    } else {
                        aux = aux.getLeft();
                    }
                } else if (inserted.getClave() > aux.getClave()) {
                    if (aux.getRight() == null) {
                        aux.setRight(inserted);
                        finish = true;
                    } else {
                        aux = aux.getRight();
                    }

                }
            }
        }
    }
    /**
     Método auxiliar para buscar claves en el arbol
     Este metodo retornara un nodo en caso de encontrar uno que coincida con la
     * clave, de lo contrario retorna null 
     @param clave la clave a buscar
     @param root el nodo donde se busca la clave
     * @return found nodo encontrado
     **/
    public Nodo buscar(int clave, Nodo root){
        Nodo found = null;
        if(root.getClave() == clave){
            found = root;
        }else if(root.getClave() > clave){
            found = this.buscar(clave, root.getLeft());
        }else if (root.getClave() < clave){
            found = this.buscar(clave, root.getRight());
        }
        return found;
    }
    /** Método para buscar un nodo en el arbol
     * 
     * @param clave clave de identificación del nodo a buscar
     * @return found nodo buscado
     */
    public Nodo search(int clave){
        Nodo found = null;
        Nodo aux = proot;
        found = this.buscar(clave,aux);
        if (found == null){
            JOptionPane.showMessageDialog(null, "El nodo buscado no fue encontrado");
        }
        return found;
    }
    public void remove(int clave){
        Nodo delete = this.search(clave);
        if (!(delete == null)){
            
        }
    }

}
