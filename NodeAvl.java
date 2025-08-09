public class NodeAvl {

        Patient data; // Patient ID
        int height; // For AVL tree balancing
        NodeAvl left, right;

        public NodeAvl(Patient data) {
            this.data = data;
            this.height = 1; // Start height as 1 for a new node
            this.left = null;
            this.right = null;
        }
    }

