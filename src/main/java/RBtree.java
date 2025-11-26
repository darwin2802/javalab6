public class RBtree
{
    private RBnode root;
    private final RBnode NIL;

    public RBtree() {
        NIL = new RBnode(0);
        NIL.color = false;
        root = NIL;
    }

    public void insert(int key)
    {
        RBnode node = new RBnode(key);
        node.left = node.right = NIL;
        RBnode y = null;
        RBnode x = root;

        while (x != NIL)
        {
            y = x;
            if (node.data < x.data)
                x = x.left;
            else
                x = x.right;
        }

        node.parent = y;
        if (y == null)
            root = node;
        else if (node.data < y.data)
            y.left = node;
        else
            y.right = node;
        if (node.parent == null)
        {
            node.color = false;
            return;
        }

        if (node.parent.parent == null)
            return;

        fixInsert(node);
    }

    private void fixInsert(RBnode k)
    {
        RBnode u;
        while (k.parent.color == true)
        {
            if (k.parent == k.parent.parent.right)
            {
                u = k.parent.parent.left;
                if (u.color == true)
                {
                    u.color = false;
                    k.parent.color = false;
                    k.parent.parent.color = true;
                    k = k.parent.parent;
                } else
                {
                    if (k == k.parent.left)
                    {
                        k = k.parent;
                        rightRotate(k);
                    }
                    k.parent.color = false;
                    k.parent.parent.color = true;
                    leftRotate(k.parent.parent);
                }
            }
            else
            {
                u = k.parent.parent.right;

                if (u.color == true)
                {
                    u.color = false;
                    k.parent.color = false;
                    k.parent.parent.color = true;
                    k = k.parent.parent;
                }
                else
                {
                    if (k == k.parent.right)
                    {
                        k = k.parent;
                        leftRotate(k);
                    }
                    k.parent.color = false;
                    k.parent.parent.color = true;
                    rightRotate(k.parent.parent);
                }
            }
            if (k == root)
                break;
        }
        root.color = false;
    }

    private void leftRotate(RBnode x)
    {
        RBnode y = x.right;
        x.right = y.left;
        if (y.left != NIL)
            y.left.parent = x;
        y.parent = x.parent;
        if (x.parent == null)
            root = y;
        else if (x == x.parent.left)
            x.parent.left = y;
        else
            x.parent.right = y;
        y.left = x;
        x.parent = y;
    }

    private void rightRotate(RBnode x)
    {
        RBnode y = x.left;
        x.left = y.right;
        if (y.right != NIL)
            y.right.parent = x;
        y.parent = x.parent;
        if (x.parent == null)
            root = y;
        else if (x == x.parent.right)
            x.parent.right = y;
        else
            x.parent.left = y;
        y.right = x;
        x.parent = y;
    }

    public void inorder()
    {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(RBnode node)
    {
        if (node != NIL) {
            inOrderRec(node.left);
            System.out.print(node.data + " ");
            inOrderRec(node.right);
        }
    }

    public void printTree()
    {
        printInOrder(root, "", true);
    }

    private void printInOrder(RBnode node, String indent, boolean last)
    {
        if (node != NIL)
        {
            System.out.print(indent);
            if (last)
            {
                System.out.print("R----");
                indent += "     ";
            } else
            {
                System.out.print("L----");
                indent += "|    ";
            }
            String sColor = node.color ? "RED" : "BLACK";
            System.out.println(node.data + "(" + sColor + ")");
            printInOrder(node.left, indent, false);
            printInOrder(node.right, indent, true);
        }
    }
}
