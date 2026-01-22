/** The interface for the implementation of the AVLTree
 * @Author Sivuyise Matwa
 * Date: 19 mARCH 2024
 */
public interface AVLInterface<T extends Comparable<T>> {
    /** Insert the data in the tree
     * @param d
     * @param d1
     * @param d2
     */
    void insert(T d, T  d1, T d2);

    /** Search for the first item in the node
     * @param d
     * @return the get item in the node
     */
    T search(T d);

    /** Search for the first item in the node
     * @param data
     * @return the third item in the node
     */
    T searchScore(T data);
}
