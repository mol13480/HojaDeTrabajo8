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
 * @author Jorge
 */

/// clase nodo para el splayNode
public class SplayNode  {
       
    // nodos aledaños
     SplayNode left, right, parent;
     //valor
     Word element;

 

     /** Constructor **/

     public SplayNode()

     {

         this(null, null, null, null);

     }          

     /** Constructor **/

     public SplayNode(Word ele)

     {

         this(ele, null, null, null);

     } 

     /** Constructor con etradas completas **/

     public SplayNode(Word ele, SplayNode left, SplayNode right, SplayNode parent)

     {

         this.left = left;

         this.right = right;

         this.parent = parent;

         this.element = ele;         

     }    
    
}
