/*
 /*
Universidad del Valle de Guatemala
Hoja de Trabajo 8 
Irene Molina 13480
Jorge Garcia 13175
Moises Urias 13015

 */
package hojadetrabajo8;

/**
 *
 * @authors http://www.sanfoundry.com/java-program-implement-splay-tree/
 * modificado por :Jorge García,Moises Urias,Irene Molina
 */

public class SplayTree implements WordSet {
         private SplayNode root;

     private int count = 0;

 

     /** Constructor **/

     public SplayTree()

     {

         root = null;

     }

 

     /** Function para revisar si el arbol esta vacio **/

     public boolean isEmpty()

     {

         return root == null;

     }

 

     /** clear tree **/

     public void clear()

     {

         root = null;

     }

 

     /** funcion para agregar elementos */

     public void add(Word ele)

     {

         SplayNode z = root;

         SplayNode p = null;

         while (z != null)

         {

             p = z;

             if (p.element.compareTo(ele)>0)

                 z = z.right;

             else

                 z = z.left;

         }

         z = new SplayNode();

         z.element = ele;

         z.parent = p;

         if (p == null)

             root = z;

         else if (p.element.compareTo(ele)>0)

             p.right = z;

         else

             p.left = z;

         Splay(z);

         count++;

     }

     /** rotacion 1 **/

     public void makeLeftChildParent(SplayNode c, SplayNode p)

     {

         if ((c == null) || (p == null) || (p.left != c) || (c.parent != p))

             throw new RuntimeException("WRONG");

 

         if (p.parent != null)

         {

             if (p == p.parent.left)

                 p.parent.left = c;

             else 

                 p.parent.right = c;

         }

         if (c.right != null)

             c.right.parent = p;

 

         c.parent = p.parent;

         p.parent = c;

         p.left = c.right;

         c.right = p;

     }

 

     /** rotacion 2 **/

     public void makeRightChildParent(SplayNode c, SplayNode p)

     {

         if ((c == null) || (p == null) || (p.right != c) || (c.parent != p))

             throw new RuntimeException("WRONG");

         if (p.parent != null)

         {

             if (p == p.parent.left)

                 p.parent.left = c;

             else

                 p.parent.right = c;

         }

         if (c.left != null)

             c.left.parent = p;

         c.parent = p.parent;

         p.parent = c;

         p.right = c.left;

         c.left = p;

     }

 

     /** funcion de Splay deside cuando usar las rotaciones **/

     private void Splay(SplayNode x)

     {

         while (x.parent != null)

         {

             SplayNode Parent = x.parent;

             SplayNode GrandParent = Parent.parent;

             if (GrandParent == null)

             {

                 if (x == Parent.left)

                     makeLeftChildParent(x, Parent);

                 else

                     makeRightChildParent(x, Parent);                 

             } 

             else

             {

                 if (x == Parent.left)

                 {

                     if (Parent == GrandParent.left)

                     {

                         makeLeftChildParent(Parent, GrandParent);

                         makeLeftChildParent(x, Parent);

                     }

                     else 

                     {

                         makeLeftChildParent(x, x.parent);

                         makeRightChildParent(x, x.parent);

                     }

                 }

                 else 

                 {

                     if (Parent == GrandParent.left)

                     {

                         makeRightChildParent(x, x.parent);

                         makeLeftChildParent(x, x.parent);

                     } 

                     else 

                     {

                         makeRightChildParent(Parent, GrandParent);

                         makeRightChildParent(x, Parent);

                     }

                 }

             }

         }

         root = x;

     }

     // metodo para llegar al elemento tipo Word
    public Word get(Word ele)

     {

         SplayNode z = root;

         while (z != null)

         {

             if (z.element.compareTo(ele)>0)

                 z = z.right;

             else if (z.element.compareTo(ele)<0)

                 z = z.left;

             else

                 return z.element;

         }

         return null;

     }
     
    
}
