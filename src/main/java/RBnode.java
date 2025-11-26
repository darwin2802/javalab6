public class RBnode
{
    int data;
    RBnode left, right, parent;
    boolean color;

    public RBnode(int data)
    {
        this.data = data;
        left = right = parent = null;
        color = true;
    }
}
