import java.util.*;

public class lab6
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        RBtree tree = new RBtree();

        System.out.println("Введіть кількість елементів: ");
        int n = scanner.nextInt();
        int[]arr = new int[n];
        Random rand = new Random();
        System.out.println("Введіть 1 для випадкових чисел або 2 для впорядкованих:");
        int choice = scanner.nextInt();

        if (choice == 1)
        {
            for (int i = 0; i < n; i++)
            {
                arr[i] = rand.nextInt(100);
            }
        }
        else
        {
            for (int i = 0; i < n; i++)
            {
                arr[i] = i + 1;
            }
        }

        System.out.println("Елементи для додавання: " + Arrays.toString(arr));

        for (int num : arr)
        {
            tree.insert(num);
        }

        System.out.println("\nОбхід дерева:");
        tree.inorder();

        System.out.println("\nВідображення дерева:");
        tree.printTree();
    }
}
