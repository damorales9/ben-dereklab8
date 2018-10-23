import java.io.PrintStream;
import java.util.PriorityQueue;

public class HuffmanExampleBook 
{
  public static class HuffData implements Comparable<HuffData>
  {
    private int count;
    private Character letter;

    public HuffData(int count, Character letter)
    {
      this.count = count;
      this.letter = letter;
    }

    public int compareTo(HuffData h) { return count - h.count; }
    public String toString() { return "["+letter+", "+count+"]"; }

    private int getCount() { return count; }
  }

  /** A reference to the completed Huffman tree. */
  protected BinaryTree<HuffData> huffTree;



  public PriorityQueue<BinaryTree<HuffData>> encodeExample()
  { 
    PriorityQueue <BinaryTree<HuffData>> pq = new PriorityQueue<>();
    pq.add (new BinaryTree<HuffData> (new HuffData(50, 'a')));
    pq.add (new BinaryTree<HuffData> (new HuffData(30, 'b')));
    pq.add (new BinaryTree<HuffData> (new HuffData(25, 'c')));
    pq.add (new BinaryTree<HuffData> (new HuffData(10, 'd')));
    pq.add (new BinaryTree<HuffData> (new HuffData(5, 'e')));
    return pq;
  }


  public HuffmanExampleBook()
  {
    PriorityQueue <BinaryTree<HuffData>> theQueue = encodeExample();

    while (theQueue.size() > 1)      // Build the tree.
    {
      BinaryTree<HuffData> left = theQueue.poll();
      BinaryTree<HuffData> right = theQueue.poll();
      int wl = left.getData().getCount();
      int wr = right.getData().getCount();
      HuffData sum = new HuffData(wl + wr, null);
      theQueue.offer(new BinaryTree<HuffData> (sum, left, right));
    }

    huffTree = theQueue.poll();   // Extract queue's single item.
  }


  public String toString()
  {
    return huffTree.toString();
  }


  public static void main (String [] args)
  {
    HuffmanExample h = new HuffmanExample();
    System.out.println(h);
  }
}
