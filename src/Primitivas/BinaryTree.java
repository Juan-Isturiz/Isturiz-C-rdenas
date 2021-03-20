/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Primitivas;

import javax.swing.JOptionPane;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;

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

    /**
     * Método para insertar nuevos nodos Este método insertará un elemento
     * dentro del arbol en su lugar correspondido asegurandose de que no sea un
     * valor repetido basado en clave
     *
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
                } else if (inserted.getClave() > aux.getClave()) {
                    if (aux.getLeft() == null) {
                        aux.setLeft(inserted);
                        inserted.setPadre(aux);
                        finish = true;
                    } else {
                        aux = aux.getLeft();
                    }
                } else if (inserted.getClave() < aux.getClave()) {
                    if (aux.getRight() == null) {
                        aux.setRight(inserted);
                        inserted.setPadre(aux);
                        finish = true;
                    } else {
                        aux = aux.getRight();
                    }

                }
            }
        }
    }

    /**
     * Método auxiliar para buscar claves en el arbol Este metodo retornara un
     * nodo en caso de encontrar uno que coincida con la clave, de lo contrario
     * retorna null
     *
     * @param clave la clave a buscar
     * @param root el nodo donde se busca la clave
     * @return found nodo encontrado
     *
     */
    public Nodo buscar(int clave, Nodo root) {
        Nodo found = null;
        if (root.getClave() == clave) {
            found = root;
        } else if (root.getClave() > clave) {
            found = this.buscar(clave, root.getLeft());
        } else if (root.getClave() < clave) {
            found = this.buscar(clave, root.getRight());
        }
        return found;
    }

    /**
     * Método para buscar un nodo en el arbol
     *
     * @param clave clave de identificación del nodo a buscar
     * @return found nodo buscado
     */
    public Nodo search(int clave) {
        Nodo found = null;
        Nodo aux = proot;
        found = this.buscar(clave, aux);
        if (found == null) {
            JOptionPane.showMessageDialog(null, "El nodo buscado no fue encontrado");
        }
        return found;
    }

    public Nodo minv(Nodo a) {
        Nodo aux = a.getRight();
        while ((aux.getLeft() != null)) {
            aux = aux.getLeft();
        }
        return aux;
    }

    public void remove(int clave) {
        Nodo deleted = this.search(clave);
        if (deleted != null) {
            Nodo aux;
            if (deleted.is_Leaf()) {
                if (deleted != proot) {
                    aux = deleted.getPadre();
                    aux.release(deleted);
                } else {
                    proot = null;
                }

            } else if (deleted.getLeft() == null || deleted.getRight() == null) {
                if (deleted == proot) {
                    if (deleted.getLeft() != null) {
                        deleted.getLeft().setPadre(null);

                    } else {
                        deleted.getRight().setPadre(null);
                        this.proot = deleted;
                    }
                } else if (deleted.getLeft() != null) {
                    deleted.getLeft().setPadre(deleted.getPadre());
                    if (deleted == deleted.getPadre().getRight()) {
                        deleted.getPadre().setRight(deleted.getLeft());
                    } else {
                        deleted.getPadre().setLeft(deleted.getLeft());

                    }
                } else {
                    deleted.getRight().setPadre(deleted.getPadre());
                    if (deleted == deleted.getPadre().getRight()) {
                        deleted.getPadre().setRight(deleted.getRight());
                    } else {
                        deleted.getPadre().setLeft(deleted.getRight());

                    }
                }
            } else {
                aux = this.minv(deleted);
                if (aux != deleted.getRight()) {
                    aux.setRight(deleted.getRight());
                    deleted.getRight().setPadre(aux);
                }
                if (aux != deleted.getLeft()) {
                    aux.setLeft(deleted.getLeft());
                    deleted.getLeft().setPadre(aux);
                }

                if (deleted != proot) {
                    if (deleted == deleted.getPadre().getRight()) {
                        deleted.getPadre().setRight(aux);
                    } else {
                        deleted.getPadre().setLeft(aux);
                    }
                    aux.setPadre(deleted.getPadre());

                } else {
                    this.proot = aux;
                }
            }
        }
    }

    public Graph sincro(Graph a, Nodo root) {
        System.setProperty("org.graphstream.ui", "swing");
        a.setAttribute("ui.antialias");
        a.setAttribute("ui.stylesheet", "graph { padding: 40px; } node { text-alignment: at-right; text-padding: 3px, 2px; text-background-mode: rounded-box; text-background-color: #EB2; text-color: #222; }edge {size: 3px; fill-color: #444;padding: -10px, -10px; }");
        String id = root.getName();
        a.addNode(id);
        if (root.getRight() != null) {
            this.sincro(a, root.getRight());
            String edgeid = id + root.getRight().getName();
            a.addEdge(edgeid, a.getNode(root.getName()), a.getNode(root.getRight().getName()),true);
        }
        if (root.getLeft() != null) {
            this.sincro(a, root.getLeft());
            String edgeid = id + root.getLeft().getName();
            a.addEdge(edgeid, a.getNode(id), a.getNode(root.getLeft().getName()),true);
        }
        
        for (Node node : a) {
            node.setAttribute("ui.label", node.getId());
            
        }
        return a;
    }
    public void showGraph(Graph a){
        
    }
}
