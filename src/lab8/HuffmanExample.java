import java.util.PriorityQueue;
public class HuffmanExample
{
  public Node encodeExample()
  {
     return runExample();
  }

  public Node runExample()
  {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new LetterNode('a', 50));
    pq.offer(new LetterNode('b', 30));
    pq.offer(new LetterNode('c', 25));
    pq.offer(new LetterNode('d', 10));
    pq.offer(new LetterNode('e', 5));

    while(pq.size() > 1)
    {
      Node node1 = pq.poll();
      Node node2 = pq.poll();
      InternalNode newNode = new InternalNode(node1, node2);
      pq.offer(newNode);
    }
  }

  public static void main (String[] args)
  {
     HuffmanExample h = new HuffmanExample();
     Node finalTree = h.encodeExample();
     System.out.println("final tree = " + finalTree);
     //finalTree.dump("");
  }
  
}
