public class InternalNode extends Node
{
  protected Node left;
  protected Node right;

  public InternalNode(Node nodeOne, Node nodeTwo)
  {
     super(nodeOne.count + nodeTwo.count);
     left = nodeOne;
     right = nodeTwo;
  }

  public void dump(String code)
  {
    left.dump(code);
    right.dump(code);;
  }

  public String toString()
  {
    return "" + left.toString() + " "  + right.toString();
  }
}
