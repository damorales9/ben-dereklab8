public abstract class Node implements Comparable<Node>
{
  protected int count;

  public Node(int initialCount)
  {
    count = initialCount;
  }

  public int compareTo(Node otherGuy)
  {
    return count - otherGuy.count;
  }

  public abstract void dump(String code);
}
