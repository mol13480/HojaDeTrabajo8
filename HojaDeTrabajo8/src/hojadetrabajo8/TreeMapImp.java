/*
Universidad del Valle de Guatemala
Hoja de Trabajo 8 
Irene Molina 13480
Jorge Garcia 13175
Moises Urias 13015
 */

package hojadetrabajo8;
import java.util.TreeMap;
/**
 *
 * @author Irene
 */

public class TreeMapImp implements WordSet{
    TreeMap tree=new TreeMap();
  
    
    
    public void add(Word W){
        //se agrega la palabra como key y value
        tree.put(W,W);
        
    }
    public Word get(Word W){
        //si se encuentra la palabra, se hace el get
        if(tree.containsKey(W))
        return (Word)tree.get(W);
        else return null;
    }
}
