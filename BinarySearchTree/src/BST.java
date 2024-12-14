
public class BST <T extends Comparable<T>>{
    private Node<T> root;

    public BST() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public BST<T> add(T value) {
        if (isEmpty()) {
            root = new Node(value);
        }else if(search(value)){
            return this;
        }else{
            root.add(value);
        }
        return this;
    }

    public boolean search(T value) {
        if(isEmpty()){
            return false;
        }else{
            return root.search(value);
        }
    }

    public String inOrder() {
        StringBuilder myStringBuilder = new StringBuilder();
        if(!isEmpty()){
            root.inOrder(myStringBuilder);
        }
        return myStringBuilder.toString();
    }

    public String preOrder() {
        StringBuilder sb = new StringBuilder();
        if(!isEmpty()){
            root.preOrder(sb);
        }
        return sb.toString();
    }

    public String postOrder() {
        StringBuilder sb = new StringBuilder();
        if(!isEmpty()){
            root.postOrder(sb);
        }
        return sb.toString();
    }

    public int size() {
        if(isEmpty()){
            return 0;
        }else{
            return root.size();
        }
    }

    public int longest() {
        if(isEmpty()){
            return 0;
        }else{
            return root.longestLeaf();
        }
    }

    public int shortestLeaf() {
        if (isEmpty()) {
            return 0;
        } else {
            return root.shortestLeaf();
        }
    }

    public int shortestEnd() {
        if (isEmpty()) {
            return 0;
        } else {
            return root.shortestEnd();
        }
    }

    public String toString(){
        if(isEmpty()){
            return "";
        }else{
            return root.toString();
        }
    }
}


