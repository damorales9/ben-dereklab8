import java.lang.Comparable;

/**
 * Class for a binary tree that stores type E objects.
 * @author Koffman and Wolfgang
 **/
// [[ BinaryTree must implement 'Comparable<BinaryTree<E>>' so that
// a binary tree can be put on the priority queue.  BinaryTree's definition 
// compares only the roots, which is sufficient for the Huffman tree, but
// otherwise insane.
// this is a great anti-goodness examples where the authors are cleaver at the
// expense of code maintainability.  as we will in this lab, a good
// object0oriented programmer would use a class hierarchy to sort this issue. ]]


public class BinaryTree<E extends Comparable<E>> 
  implements Comparable<BinaryTree<E>>
{
  /** Class to encapsulate a tree node. */
  protected class Node<E extends Comparable<E>> implements Comparable<Node<E>>
  {
    /** The information stored in this node. */
    protected E data;

    /** Reference to the left child. */
    protected Node<E> left;

    /** Reference to the right child. */
    protected Node<E> right;

    /**
     * Construct a node with given data and no children.
     * @param data The data to store in this node
     */
    protected Node(E data)
    {
      this.data = data;
      left = null;
      right = null;
    }

    public int compareTo(Node<E> otherGuy)
    {
      return data.compareTo(otherGuy.data);
    }

    /**
     * Returns a string representation of the node.
     * @return A string representation of the data fields
     */
    @Override
    public String toString() { return data.toString(); }
  }

  /** The root of the binary tree */
  protected Node<E> root;


  /**
   * Constructs a new binary tree with data in its root,leftTree
   * as its left subtree and rightTree as its right subtree.
   */
  public BinaryTree(E data)
  {
    root = new Node<E>(data);
    root.left = null;
    root.right = null;
  }

  /**
   * Constructs a new binary tree with data in its root,leftTree
   * as its left subtree and rightTree as its right subtree.
   */
  public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree)
  {
    root = new Node<E>(data);
    root.left = leftTree == null ? null : leftTree.root;
    root.right = rightTree == null ? null : rightTree.root;
  }


  /**
   * Return the data field of the root
   * @return the data field of the root
   *     or null if the root is null
   */
  public E getData()
  {
    return root == null ? null : root.data;
  }

  @Override
  public int compareTo(BinaryTree<E> otherGuy)
  {
    return root.compareTo(otherGuy.root);
  }


  @Override
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    preOrderTraverse(root, 1, sb);
    return sb.toString();
  }

  /**
   * Perform a preorder traversal.
   * @param node The local root
   * @param depth The depth
   * @param sb The string buffer to save the output
   */
  private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb)
  {
    for (int i = 1; i < depth; i++)
      sb.append("  ");

    if (node == null)
    {
      sb.append("null\n");
    }
    else
    {
      sb.append(node.toString());
      sb.append("\n");
      preOrderTraverse(node.left, depth + 1, sb);
      preOrderTraverse(node.right, depth + 1, sb);
    }
  }
}
