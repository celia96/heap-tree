// Skew heap of integers, implemented using IntTree
//
// based on Bailey's "SkewHeap"
//
// CS 201 HW 7
//
// Name:

public class IntSkewHeap implements IntHeap {

    protected IntTree t;        // the heap

    // constructor
    public IntSkewHeap() {
        t = empty();
    }

    // private constructor (used by left() and right())
    protected IntSkewHeap(IntTree tree) {
        t = tree;
    }

    
    // returns true iff heap has no values
    public boolean isEmpty() {
        return isEmpty(t);
    }

    // returns the minimum int at the root of the heap ( = Bailey's getFirst())
    // pre: !isEmpty()
    public int value() {
        return t.value();
    }

    // removes all elements from the heap
    public void clear() {
        t = empty();
    }

    // returns left "sub-heap" of heap
    // pre: !isEmpty()
    public IntHeap left() {
        return new IntSkewHeap(t.left());
    }

    // returns right "sub-heap" of heap
    // pre: !isEmpty()
    public IntHeap right() {
        return new IntSkewHeap(t.right());
    }


    /************************************************************/

    /* You'll have to write the add and remove methods.
     *
     * Start by pasting in the appropriate code from
     * Bailey's "SkewHeap.java"
     */

    
    // adds value to heap
    public void add(int value) {
    	/*
    	BinaryTree<E> smallTree = new BinaryTree<E>(value,EMPTY,EMPTY);
        root = merge(smallTree,root);
        count++;
    	 */
        t = merge(leaf(value), t);
        
    }
    protected static IntTree merge(IntTree left, IntTree right) {
	    if (isEmpty(left)) return right;
	    if (isEmpty(right)) return left;
	    int leftVal = left.value();
	    int rightVal = right.value();
	    IntTree result;
	    if (rightVal < leftVal) {
	        result = merge(right,left);
	    } else {
	        result = left;
	        // assertion left side is smaller than right
	        // left is new root
	        if (isEmpty(left(result)))
	        {
	            setLeft(result, right);
	        } else {
	            IntTree temp = right(result);
	            setRight(result, result.left());
	            setLeft(result, merge(temp,right));
	        }
	    }
	    return result;
    }
    // removes and returns the minimum int at the root of the heap
    // pre: !isEmpty()
    public int remove() {
    	/*
    	E result = root.value();
        root = merge(root.left(),root.right());
        count--;
        return result;  
    	 */
    	int result = value(t);
        t = merge(t.left(), t.right());
        return result;  
    }



    /************************************************************/
    
    // Local abbreviations for static IntList methods
        
    public static IntTree empty() {
        return IntTree.empty();
    }
        
    public static boolean isEmpty(IntTree T) {
        return IntTree.isEmpty(T);
    }
        
    public static IntTree leaf(int val) {
        return IntTree.leaf(val);
    }
        
    public static int value(IntTree T) {
        return IntTree.value(T);
    }
        
    public static IntTree left(IntTree T) {
        return IntTree.left(T);
    }
        
    public static IntTree right(IntTree T) {
        return IntTree.right(T);
    }
        
    public static void setValue(IntTree T, int newValue) {
        IntTree.setValue(T, newValue);
    }
        
    public static void setLeft(IntTree T, IntTree newLeft) {
        IntTree.setLeft(T, newLeft);
    }
        
    public static void setRight(IntTree T, IntTree newRight) {
        IntTree.setRight(T, newRight);
    }
}
