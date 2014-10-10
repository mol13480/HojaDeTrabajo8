/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojadetrabajo8;

/**
 *
 * @author Jorge
 */
public class SplayNode  {
       

     SplayNode left, right, parent;

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

     /** Constructor **/

     public SplayNode(Word ele, SplayNode left, SplayNode right, SplayNode parent)

     {

         this.left = left;

         this.right = right;

         this.parent = parent;

         this.element = ele;         

     }    
    
}
