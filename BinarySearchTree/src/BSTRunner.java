import java.util.*;

public class BSTRunner {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        for(int i = -20; i < 21; i++) {
            data.add(i);
            data.add(i);
        }

        Scanner s = new Scanner(System.in);
        System.out.print("Enter seed for shuffling: ");
        int seed = s.nextInt();
        Random rand = new Random(seed);
        int low = data.get(0), high = data.get(data.size() - 1);
        Collections.shuffle(data, rand);
        Set<Integer> set = new HashSet<>();

        BST<Integer> b1 = new BST<>();
        System.out.print("appending ");
        for(int i = 0; i < 20; i++) {
            int n = data.get(i);
            System.out.print(n + " ");
            b1.add(n);
            set.add(n);
        }
        System.out.println();


        StringBuilder list = new StringBuilder();
        StringBuilder outputs = new StringBuilder();
        for(int i = -10; i < 11; i++) {
            list.append(String.format("%3d| ", i));
            outputs.append(String.format("  %s| ", b1.search(i) ? "T" : "F"));
        }
        System.out.println(list);
        System.out.println(outputs);

        System.out.println();
        System.out.printf("Size (should be %d): %d%n", set.size(), b1.size());

        System.out.printf("Longest: %d, Shortest End: %d, Shortest Leaf: %d%n",
                b1.longest(), b1.shortestEnd(), b1.shortestLeaf());

        System.out.println();
        System.out.println("In order: " + b1.inOrder());
        System.out.println("Preorder: " + b1.preOrder());
        System.out.println("Postorder: " + b1.postOrder());
        System.out.println();



    }
}
