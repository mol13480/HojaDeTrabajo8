/*
Universidad del Valle de Guatemala
Hoja de Trabajo 8 
Irene Molina 13480
Jorge Garcia 13175
Moises Urias 13015
 */

package hojadetrabajo8;
import java.util.*;
/**
 *
 * @author Irene
 */
public class HashMapImp implements WordSet{
    //Hashtable tree = new Hashtable();
    HashMap tree=new HashMap();
    
    public void add(Word W){
        //System.out.println(W.getWord()+" "+W.getType());
        //se agrega la palabra al hash map
        tree.put(W.getWord(),W.getType());
        
    }
    public Word get(Word W){
        System.out.println(":"+W.getWord()+" "+W.getType()+" "+tree.get(W.getWord()));
        //si se encuentra la palabra buscada, se hace el get
        if(tree.containsKey(W.getWord())){
            
            return new Word(W.getWord(),""+tree.get(W.getWord()));
        }
        else return null;
    }
}
