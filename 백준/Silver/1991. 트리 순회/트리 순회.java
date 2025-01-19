import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    char value;
    Node leftChild;
    Node rightChild;

    public Node(char value) {
        this.value = value;
    }
}

    public class Main {

        static Node[] tree;
        static StringBuilder sb;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            sb = new StringBuilder();

            int N = Integer.parseInt(br.readLine()); // 노드의 개수
            tree = new Node[N + 1];

            while (N-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                char parentValue = st.nextToken().charAt(0);
                char leftValue = st.nextToken().charAt(0);
                char rightValue = st.nextToken().charAt(0);

                if (tree[parentValue - 'A'] == null) { // 아직 부모 노드 생성 전
                    tree[parentValue - 'A'] = new Node(parentValue);
                }

                if (leftValue != '.') {
                    tree[leftValue - 'A'] = new Node(leftValue);
                    tree[parentValue - 'A'].leftChild = tree[leftValue - 'A'];
                }

                if (rightValue != '.') {
                    tree[rightValue - 'A'] = new Node(rightValue);
                    tree[parentValue - 'A'].rightChild = tree[rightValue - 'A'];
                }

            }

            preOrder(tree[0]);
            sb.append("\n");
            inOrder(tree[0]);
            sb.append("\n");
            postOrder(tree[0]);
            sb.append("\n");

            System.out.println(sb);

        }

        // 전위 순회
        private static void preOrder(Node node) {
            if (node == null) return;
            sb.append(node.value);
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }

        private static void inOrder(Node node) {
            if (node == null) return;
            inOrder(node.leftChild);
            sb.append(node.value);
            inOrder(node.rightChild);
        }

        private static void postOrder(Node node) {
            if (node == null) return;
            postOrder(node.leftChild);
            postOrder(node.rightChild);
            sb.append(node.value);
        }



    }
