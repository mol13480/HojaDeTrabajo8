/*
Universidad del Valle de Guatemala
Hoja de Trabajo 8 
Irene Molina 13480
Jorge Garcia 13175
Moises Urias 13015
 */

// RBT class
//
// CONSTRUCTION: with a negative infinity sentinel
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x (unimplemented)
// Word find( x )   --> Return item that matches x
// Word findMin( )  --> Return smallest item
// Word findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print all items
// ******************ERRORS********************************
// Exceptions are thrown by insert if warranted and remove.

/**
 * Implements a red-black tree.
 * Note that all "matching" is based on the compareTo method.
 * @author Mark Allen Weiss
 * @author Moises Samuel Urias Moreno
 */


package hojadetrabajo8;

public class RBT implements WordSet{
    /**
     * Construct the tree.
     */
    public RBT( ) {
        header      = new RedBlackNodeAnt( null );
        header.left = header.right = nullNode;
    }
    
    /**
     * Compare item and t.element, using compareTo, with
     * caveat that if t is header, then item is always larger.
     * This routine is called if is possible that t is header.
     * If it is not possible for t to be header, use compareTo directly.
     */
    private final int compare( Word item, RedBlackNodeAnt t ) {
        if( t == header )
            return 1;
        else
            return item.compareTo( t.element );
    }
    
    /**
     * Insert into the tree.
     * @param item the item to insert.
     * @throws DuplicateItemException if item is already present.
     */
    public void insert( Word item ) {
        current = parent = grand = header;
        nullNode.element = item;
        
        while( compare( item, current ) != 0 ) {
            great = grand; grand = parent; parent = current;
            current = compare( item, current ) < 0 ?
                current.left : current.right;
            
            // Check if two red children; fix if so
            if( current.left.color == RED && current.right.color == RED )
                handleReorient( item );
        }
        
        // Insertion fails if already present
        if( current != nullNode )
            throw new DuplicateItemException( item.toString( ) );
        current = new RedBlackNodeAnt( item, nullNode, nullNode );
        
        // Attach to parent
        if( compare( item, parent ) < 0 )
            parent.left = current;
        else
            parent.right = current;
        handleReorient( item );
    }
    
    /**
     * Remove from the tree.
     * @param x the item to remove.
     * @throws UnsupportedOperationException if called.
     */
    public void remove( Word x ) {
        throw new UnsupportedOperationException( );
    }
    
    /**
     * Find the smallest item  the tree.
     * @return the smallest item or null if empty.
     */
    public Word findMin( ) {
        if( isEmpty( ) )
            return null;
        
        RedBlackNodeAnt itr = header.right;
        
        while( itr.left != nullNode )
            itr = itr.left;
        
        return itr.element;
    }
    
    /**
     * Find the largest item in the tree.
     * @return the largest item or null if empty.
     */
    public Word findMax( ) {
        if( isEmpty( ) )
            return null;
        
        RedBlackNodeAnt itr = header.right;
        
        while( itr.right != nullNode )
            itr = itr.right;
        
        return itr.element;
    }
    
    /**
     * Find an item in the tree.
     * @param x the item to search for.
     * @return the matching item or null if not found.
     */
    public Word find( Word x ) {
        nullNode.element = x;
        current = header.right;
        
        for( ; ; ) {
            if( x.compareTo( current.element ) < 0 )
                current = current.left;
            else if( x.compareTo( current.element ) > 0 )
                current = current.right;
            else if( current != nullNode )
                return current.element;
            else
                return null;
        }
    }
    
    
    
    /**
     * Make the tree logically empty.
     */
    public void makeEmpty( ) {
        header.right = nullNode;
    }
    
    /**
     * Print all items.
     */
    public void printTree( ) {
        printTree( header.right );
    }
    
    /**
     * Internal method to print a subtree in sorted order.
     * @param t the node that roots the tree.
     */
    private void printTree( RedBlackNodeAnt t ) {
        if( t != nullNode ) {
            printTree( t.left );
            System.out.println( t.element );
            printTree( t.right );
        }
    }
    
    /**
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( ) {
        return header.right == nullNode;
    }
    
    /**
     * Internal routine that is called during an insertion
     * if a node has two red children. Performs flip and rotations.
     * @param item the item being inserted.
     */
    private void handleReorient( Word item ) {
        // Do the color flip
        current.color = RED;
        current.left.color = BLACK;
        current.right.color = BLACK;
        
        if( parent.color == RED )   // Have to rotate
        {
            grand.color = RED;
            if( ( compare( item, grand ) < 0 ) !=
                    ( compare( item, parent ) < 0 ) )
                parent = rotate( item, grand );  // Start dbl rotate
            current = rotate( item, great );
            current.color = BLACK;
        }
        header.right.color = BLACK; // Make root black
    }
    
    /**
     * Internal routine that performs a single or double rotation.
     * Because the result is attached to the parent, there are four cases.
     * Called by handleReorient.
     * @param item the item in handleReorient.
     * @param parent the parent of the root of the rotated subtree.
     * @return the root of the rotated subtree.
     */
    private RedBlackNodeAnt rotate( Word item, RedBlackNodeAnt parent ) {
        if( compare( item, parent ) < 0 )
            return parent.left = compare( item, parent.left ) < 0 ?
                rotateWithLeftChild( parent.left )  :  // LL
                rotateWithRightChild( parent.left ) ;  // LR
        else
            return parent.right = compare( item, parent.right ) < 0 ?
                rotateWithLeftChild( parent.right ) :  // RL
                rotateWithRightChild( parent.right );  // RR
    }
    
    /**
     * Rotate binary tree node with left child.
     */
    private static RedBlackNodeAnt rotateWithLeftChild( RedBlackNodeAnt k2 ) {
        RedBlackNodeAnt k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }
    
    /**
     * Rotate binary tree node with right child.
     */
    private static RedBlackNodeAnt rotateWithRightChild( RedBlackNodeAnt k1 ) {
        RedBlackNodeAnt k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }

    @Override
    public void add(Word wordObject) {
        this.insert(wordObject);
    }

  
    
    
    
    
     public Word get( Word x ) {
        nullNode.element = x;
        current = header.right;
        
        for( ; ; ) {
            if( x.compareTo(current.element)<0)
                current = current.left;
            else if( x.compareTo( current.element ) > 0 )
                current = current.right;
            else if( current != nullNode )
                return current.element;
            else
                return null;
        }
    }
    private static class RedBlackNodeAnt {
        // Constructors
        RedBlackNodeAnt( Word theElement ) {
            this( theElement, null, null );
        }
        
        RedBlackNodeAnt( Word theElement, RedBlackNodeAnt lt, RedBlackNodeAnt rt ) {
            element  = theElement;
            left     = lt;
            right    = rt;
            color    = RBT.BLACK;
        }
        
        Word   element;    // The data in the node
        RedBlackNodeAnt left;       // Left child
        RedBlackNodeAnt right;      // Right child
        int          color;      // Color
    }
    
    private RedBlackNodeAnt header;
    private static RedBlackNodeAnt nullNode;
    static         // Static initializer for nullNode
    {
        nullNode = new RedBlackNodeAnt( null );
        nullNode.left = nullNode.right = nullNode;
    }
    
    private static final int BLACK = 1;    // Black must be 1
    private static final int RED   = 0;
    
    // Used in insert routine and its helpers
    private static RedBlackNodeAnt current;
    private static RedBlackNodeAnt parent;
    private static RedBlackNodeAnt grand;
    private static RedBlackNodeAnt great;
    
    
}


