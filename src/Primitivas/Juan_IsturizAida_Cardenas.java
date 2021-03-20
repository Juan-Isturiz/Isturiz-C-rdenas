/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Primitivas;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.layout.HierarchicalLayout;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author yunch
 */
public class Juan_IsturizAida_Cardenas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BinaryTree a = new BinaryTree();
        a.insert("peter", 50);
        a.insert("caca", 30);
        a.insert("penta", 0);
        a.insert("20", 20);
        a.insert("asd", 70);
        a.insert("xd", 32);
        a.insert("name", 40);
        a.insert("yeet", 80);
        a.insert("jimin", 90);
        a.insert("yeetnt", 60);
        a.insert("cristo", 55);
        a.insert("pito", 56);
        a.insert("onvre", 54);
        Graph b = new SingleGraph("xd");
        b = a.sincro(b, a.getProot());
        Viewer viewer = b.display(false);
        b.getNode(a.getProot().getRight().getName()).setAttribute("ui.frozen");
        b.getNode(a.getProot().getRight().getName()).setAttribute("x", -3);
        b.getNode(a.getProot().getRight().getName()).setAttribute("y", -6);
        b.getNode(a.getProot().getLeft().getName()).setAttribute("ui.frozen");
        b.getNode(a.getProot().getLeft().getName()).setAttribute("x", 3);
        b.getNode(a.getProot().getLeft().getName()).setAttribute("y", -6);
        b.getNode(a.getProot().getName()).setAttribute("ui.frozen");
        b.getNode(a.getProot().getName()).setAttribute("x", 0);
        b.getNode(a.getProot().getName()).setAttribute("y", 40);
  
	
      
    }
    
}
