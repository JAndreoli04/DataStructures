public class Node <T extends Comparable<T>>  {
    private Node<T> left;
    private Node<T> right;
    private final T data;

    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }
    public Node getRight() {
        return right;
    }
    public void setRight(Node right) {
        this.right = right;
    }

    public boolean hasRight() {
        return right != null;
    }

    public boolean hasLeft() {
        return left != null;
    }
    public boolean isLeaf() {
        return ! hasLeft() && ! hasRight();
    }

    public void add(T value) {
        if(data.compareTo(value) > 0) {
            if(hasLeft()){
                left.add(value);
            }else{
                left = new Node(value);
            }
        }else{
            if(hasRight()){
                right.add(value);
            }else{
                right = new Node(value);
            }
        }
    }

    public boolean search(T value) {
        //boolean found = false;
        if(data == null){
            return false;
        }
        if(data.equals(value)){
           return true;
        }else{
            if(data.compareTo(value) > 0 && hasLeft()){
                return left.search(value);
            }else if (data.compareTo(value) < 0 && hasRight()){
                return right.search(value);
            }
        }
        return false;
    }

    public void inOrder(StringBuilder sb) {
        if(hasLeft()){
            left.inOrder(sb);
        }
        sb.append(data);
        if(hasRight()){
            right.inOrder(sb);
        }
    }

    public void preOrder(StringBuilder sb) {
        sb.append(data);
        if(hasLeft()){
            left.preOrder(sb);
        }
        if(hasRight()){
            right.preOrder(sb);
        }

    }

    public void postOrder(StringBuilder sb) {
        if(hasLeft()){
            left.postOrder(sb);
        }
        if(hasRight()){
            right.postOrder(sb);
        }
        sb.append(data);
    }

    public int size() {
        int count = 1;
        if(hasLeft()){
            count += left.size();
        }
        if(hasRight()){
            count += right.size();
        }
        return count;
    }

    public int longestLeaf() {
        if(isLeaf()){
            return 1;
        }
        int leftDepth = Integer.MIN_VALUE;
        int rightDepth = Integer.MIN_VALUE;
        if(hasLeft()){
            leftDepth = left.longestLeaf();
        }
        if(hasRight()){
            rightDepth = right.longestLeaf();
        }
        return 1+ Math.max(leftDepth, rightDepth);
    }


    public int shortestLeaf() {
        if(isLeaf()){
            return 1;
        }
        int leftDepth = Integer.MAX_VALUE;
        int rightDepth = Integer.MAX_VALUE;
        if(hasLeft()){
            leftDepth = left.shortestLeaf();
        }
        if(hasRight()){
            rightDepth = right.shortestLeaf();
        }
        return 1+ Math.min(leftDepth, rightDepth);
    }

    public int shortestEnd() {
       if(!hasLeft() || !hasRight()){
           return 1;
       }
       int leftDepth = Integer.MAX_VALUE;
       int rightDepth = Integer.MAX_VALUE;
       if(hasLeft()){
           leftDepth = left.shortestEnd();
       }
       if(hasRight()){
           rightDepth = right.shortestEnd();
       }
       return 1+ Math.min(leftDepth, rightDepth);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(data);
        if(hasLeft()){
            sb.append(left.toString());
        }
        if(hasRight()){
            sb.append(right.toString());
        }
        return sb.toString();
    }
}
