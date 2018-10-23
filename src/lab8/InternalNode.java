public class InternalNode extends Node
{
  protected Node left;
  protected Node right;

  public InternalNode(Node nodeOne, Node nodeTwo)
  {
     super(count);
     count = nodeOne.count + nodeTwo.count;
     left = nodeOne;
     right = nodeTwo;
  }

  public void dump(String code)
  {
    System.out.println("the code for " + letter + " is " + code);
  }
}
