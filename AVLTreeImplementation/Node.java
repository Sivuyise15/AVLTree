/** Individual representation of single node in the tree
 * @Author Sivuyise Matwa
 * Date: 19 March 2024
 * @param <T>
 */
public class Node<T extends Comparable<T>>{
    /** fisrt data items of the node
     */
    public T data;

    /**
     * height of the tree
     */
    int height;
    /** second data items of the node
     */
    public T data1;
    /** third data items of the node
     */
    public T data2;
    /** representation of the left child of the node
     */
    public Node<T> Left;
    /** representation of the right child of the node
     */
    public Node<T> Right;

    /** constructor to initialise all the attributes of the tree
     * @Param Data, Data1, data3, LEFT, RIGHT
     */

    public Node(T Data, T Data1, T Data2, Node<T> LEFT, Node<T> RIGHT){
        data = Data;
        data1 = Data1;
        data2 = Data2;
        Left = LEFT;
        Right = RIGHT;
        height = 0;
    }

    /** set the height of the tree
     * @param height
     */

    public void setHeight(int height) {
        this.height = height;
    }

    /** get the node in the left subtree
     * @return
     */

    public Node<T> getLeft(){
        return Left;
    }

    /** get the node in right subtree
     * @return
     */
    public Node<T> getRight(){
        return Right;
    }

    /** set the left node of the tree
     * @param L
     */

    public void setLeft(Node<T> L){
        Left = L;
    }

    /** set the right node of the tree
     * @param R
     */

    public void setRight(Node<T> R){
        Right = R;
    }

    /** get the first data item in the node
     * @return
     */
    public T getData(){
        return data;
    }
}
