
    public class AVLTree {
        NodeAvl root;

        public AVLTree() {
            root = null;
        }

        // Get the height of a node
        private int height(NodeAvl node) {
            return node == null ? 0 : node.height;
        }

        // Get balance factor
        private int getBalance(NodeAvl node) {
            return node == null ? 0 : height(node.left) - height(node.right);
        }

        // Right Rotate
        private NodeAvl rightRotate(NodeAvl y) {
            NodeAvl x = y.left;
            NodeAvl T2 = x.right;

            // Perform rotation
            x.right = y;
            y.left = T2;

            // Update heights
            y.height = Math.max(height(y.left), height(y.right)) + 1;
            x.height = Math.max(height(x.left), height(x.right)) + 1;

            // Return new root
            return x;
        }

        // Left Rotate
        private NodeAvl leftRotate(NodeAvl x) {
            NodeAvl y = x.right;
            NodeAvl T2 = y.left;

            // Perform rotation
            y.left = x;
            x.right = T2;

            // Update heights
            x.height = Math.max(height(x.left), height(x.right)) + 1;
            y.height = Math.max(height(y.left), height(y.right)) + 1;

            // Return new root
            return y;
        }
        public void insert(Patient data) {
            root = insertRec(root, data);
        }
        // Insert data into AVL tree
        private NodeAvl insertRec(NodeAvl node, Patient data) {
            if (node == null) {
                return new NodeAvl(data); // Create a new node
            }

            // Insert recursively
            if (data.getPatientID() < node.data.getPatientID()) {
                node.left = insertRec(node.left, data);
            } else if (data.getPatientID() > node.data.getPatientID()) {
                node.right = insertRec(node.right, data);
            } else {
                return node; // Duplicate keys not allowed
            }

            // Update height of this node
            node.height = 1 + Math.max(height(node.left), height(node.right));

            // Check balance and rotate if unbalanced
            int balance = getBalance(node);

            // Left-Left Case
            if (balance > 1 && data.getPatientID() < node.left.data.getPatientID()) {
                return rightRotate(node);
            }

            // Right-Right Case
            if (balance < -1 && data.getPatientID() > node.right.data.getPatientID()) {
                return leftRotate(node);
            }

            // Left-Right Case
            if (balance > 1 && data.getPatientID() > node.left.data.getPatientID()) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }

            // Right-Left Case
            if (balance < -1 && data.getPatientID() < node.right.data.getPatientID()) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }

            return node; // Return the unchanged node pointer
        }

        public void addPatientID(Patient data) {
            root = insertRec(root, data);
        }

        public void preOrder(NodeAvl node) {
            if (node != null) {
                node.data.getPatientInfo();
                preOrder(node.left);
                preOrder(node.right);
            }
        }

        public void printPatients() {
            System.out.println("Patient IDs in PreOrder:");
            preOrder(root);

        }

        public NodeAvl search(int data) {
            return searchRec(root,data);
        }

        public NodeAvl searchRec(NodeAvl root,int key) {
            // base case: root is null or the key is found
            if (root == null||root.data.getPatientID()==key) {
                return root;
            }
            if (key>root.data.getPatientID()) {
                return searchRec(root.right,key);
            }

            return searchRec(root.left,key);
        }


        public Queuee PreorderApp(){
          Queuee queuee= preOrderAppRec(root);
          return queuee;
        }

        public Queuee preOrderAppRec(NodeAvl node) {
            Queuee app=new Queuee();
            if (node != null) {
                app.enqueue(node.data.getAppointment());
                preOrder(node.left);
                preOrder(node.right);
            }

            return app;

        }
    }

