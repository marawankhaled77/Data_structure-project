public class BST {
    NodeBst root;


    public BST() {
        root = null;
    }

    public int bfs() {
    int d=0;

        QueueBst q = new QueueBst();
        q.enQueue(root);
        while (!q.isEmpty()) {
            NodeBst n = q.deQueue();
            d= n.data;
            if (n.left != null) {
                q.enQueue(n.left);
            }
            if (n.right != null) {
                q.enQueue(n.right);

            }
            return n.data;
        }return d;

    }


    public NodeBst insertRec (NodeBst root, int data) {
        NodeBst newNode = new NodeBst(data);
        if (root == null) {
            return newNode;
        }
        if (data>root.data) {
            root.right = insertRec(root.right, data);
        }
        else if (data<root.data) {
            root.left = insertRec(root.left, data);
        }
        return root;
    }
    public NodeBst insert(int data) {
        root = insertRec(root, data);
        return root;
    }
    public NodeBst searchRec(NodeBst root,int key) {
        // base case: root is null or the key is found
        if (root == null||root.data==key) {
            return root;
        }
        if (key>root.data) {
            return searchRec(root.right,key);
        }

        return searchRec(root.left,key);
    }
    public NodeBst search(int data) {
        return searchRec(root,data);
    }
    public NodeBst deleteRec(NodeBst root,int key) {
        if (root == null) {
            return null;
        }
        if (key>root.data) {
            root.right = deleteRec(root.right,key);
        }
        else if (key<root.data) {
            root.left = deleteRec(root.left,key);
        }
        else {
            // node with only one child or no child
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }

            // node with 2 children find minimum in right
            root.data=findMin(root.right);
            root.right=deleteRec(root.right,root.data);

        }
        return root;

    }
    public NodeBst deleteNode(int data) {
        return deleteRec(root,data);
    }

    public int findMin(NodeBst root) {
        if (root == null) {
            return -1;
        } else if (root.left==null) { // most left leaf node
            return root.data;

        }
        return findMin(root.left);
    }
    public int findMax(NodeBst root) {
        if (root == null) {
            return -1;
        }
        else if (root.right==null) {
            return root.data;
        }
        return findMax(root.right);
    }
    public void preOrderRec(NodeBst root) {
        if (root != null) {
            System.out.print(root.data+" ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }
    public void preorder(){
        preOrderRec(root);
        System.out.println();
    }
    public int findHeight(NodeBst root) {
        if (root == null) {
            return -1;
        }
        return 1+Math.max(findHeight(root.left),findHeight(root.right));
    }








}
