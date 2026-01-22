/** The representation of an AVLTree operations
 * @Author Sivuyise Matwa, credit: Husein Suleman
 * @param <T>
 */
public class AVLTree<T extends Comparable<T>> implements AVLInterface<T>{
    /** the root of the AVLTree
     */
    public Node<T> root;
    /** Counter for number of insert comparisons
     */
    int counter = 0;
    /** Counter for number of search comparisons
     */
    int counter1 = 0;

    /** The height of the AVLTree from the root
     * @return the height of the root
     */
    public int getHeight(){
        return getHeight(root);
    }

    /** The height from the node
     * @param node
     * @return the height of the node
     */
    public int getHeight(Node<T> node){
        if (node == null)
            return -1;
        else
            return 1+ Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
    }

    private int height(Node<T> node){
        return node != null ? node.height : -1;
        // if node is not null return node.height else is null return -1
    }

    private int balance(Node<T> node){
        return height(node.getRight()) - height(node.getLeft());
    }

    /** Updating the height of the AVLTree every after insertion
     * @param node
     */
    public void updateTheHeight(Node<T> node){
        node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
    }

    private Node<T> rotateRight(Node<T> node){
        Node<T> leftNode = node.getLeft();
        Node<T> centerNode = leftNode.getRight();
        node.setLeft(centerNode);
        leftNode.setRight(node);
        updateTheHeight(node);
        updateTheHeight(leftNode);
        return leftNode;
    }

    private Node<T> rotateLeft(Node<T> node){
        Node<T> rightNode = node.getRight();
        Node<T> centerNode = rightNode.getLeft();
        rightNode.setRight(node);
        node.setRight(centerNode);
        updateTheHeight(node);
        updateTheHeight(rightNode);
        return rightNode;
    }

    private Node<T> applyRotation(Node<T> node) {
        int balance = balance(node);
        if (balance < -1) {
            // left heavy
            if (balance(node.getLeft()) > 0) {
                node.setLeft(rotateLeft(node.getLeft()));
            }
            return rotateRight(node);
        }
        if (balance > 1) {
            // right heavy
            if (balance(node.getRight()) < 0) {
                node.setRight(rotateRight(node.getRight()));
            }
            return rotateLeft(node);
        }
        return node;

    }

    /** Insert the data into an AVLTree
     * @param d
     * @param d1
     * @param d2
     */
    @Override
    public void insert(T d, T d1, T d2) {
        if (root == null) {
            root = insert(d, d1, d2, null);
        }
        else{
            insert(d, d1, d2, root);
        }
    }

    private Node<T> insert(T d, T d1, T d2, Node<T> node){
        if(node == null){
            return new Node<>(d, d1,d2, null, null);
        }

        int result = d.compareTo(node.data);

        if (result < 0)
        {
            if (node.Left == null) {
                counter++;
                node.Left = new Node<>(d, d1, d2, null, null);
            }
            else {
                counter++;
                insert(d, d1, d2, node.Left);
            }
        }
        else if(result>0)
        {

            if (node.Right == null) {
                counter++;
                node.Right = new Node<>(d, d1, d2, null, null);
            }
            else {
                counter++;
                insert(d, d1, d2, node.Right);
            }
        }
        else {
            counter++;
            return node;
        }
        return applyRotation(node);

    }

    /** Search for the @Param d in the AVLTree
     * @param d
     * @return the second item in the node
     */

    @Override
    public T search(T d) {
        return search(root, d);
    }
    private T search(Node<T> node, T data){
        if(node == null){
            return null;
        }
        if (data.compareTo(node.data) == 0){
            counter1++;
            return node.data1;
        }
        else if (data.compareTo(node.data) < 0){
            counter1++;
            return search(node.Left, data );
        }
        else{
            counter1++;
            return search(node.Right, data);
        }
    }
    /** Search for the @Param data in the AVLTree
     * @param data
     * @return the third item in the node
     */
    @Override
    public T searchScore(T data){
        return searchScore(root, data);
    }

    private T searchScore(Node<T> node, T data) {
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.data) == 0) {
            return node.data2;
        } else if (data.compareTo(node.data) < 0) {
            return searchScore(node.Left, data);
        } else {
            return searchScore(node.Right, data);
        }
    }
}
