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
public class Juan_IsturizAida_Cardenas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BinaryTree a = new BinaryTree();
        a.insert("peter", 50);
        a.insert("caca", 30);
        a.insert("asd", 70);
        a.insert("xd", 10);
        a.insert("name", 40);
        a.insert("yeet", 80);
        a.insert("jimin", 90);
        a.insert("yeetnt", 60);
        a.insert("peter", 55);
        System.out.println(a.getProot().getRight().getRight().getRight().getName());
        a.remove(70);
        System.out.println(a.getProot().getRight().getLeft().getPadre().getName());
    }
    
}
