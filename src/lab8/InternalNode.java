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
    return;
  }

  public String toString()
  {
    return "( " + left.toString() + " ^ " + super.count + " ^ "  + right.toString() + " )";
  }
}
