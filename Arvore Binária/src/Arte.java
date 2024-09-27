import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Arte {

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.esquerda), height(root.direita));
    }

    public static void printTree(Node root) {
        int height = height(root);
        int maxWidth = (int) Math.pow(2, height) - 1; // Número máximo de nós no último nível
        printSubtree(Collections.singletonList(root), 1, height, maxWidth);
    }

    private static void printSubtree(List<Node> nodes, int level, int totalHeight, int maxWidth) {
        if (nodes.isEmpty() || allNodesNull(nodes)) {
            return;
        }

        int floor = totalHeight - level;
        int edgeLines = (int) Math.pow(2, Math.max(floor - 1, 0));
        int firstSpaces = (int) Math.pow(2, floor) - 1;
        int betweenSpaces = (int) Math.pow(2, floor + 1) - 1;

        printSpaces(firstSpaces);

        List<Node> newNodes = new ArrayList<>();
        for (Node node : nodes) {
            if (node != null) {
                System.out.print(node.valor);
                newNodes.add(node.esquerda);
                newNodes.add(node.direita);
            } else {
                System.out.print(" ");
                newNodes.add(null);
                newNodes.add(null);
            }
            printSpaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printSpaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printSpaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).esquerda != null) {
                    System.out.print("/");
                } else {
                    printSpaces(1);
                }

                printSpaces(i + i - 1);

                if (nodes.get(j).direita != null) {
                    System.out.print("\\");
                } else {
                    printSpaces(1);
                }

                printSpaces(edgeLines + edgeLines - i);
            }
            System.out.println();
        }

        printSubtree(newNodes, level + 1, totalHeight, maxWidth);
    }

private static void printSpaces(int count) {
    for (int i = 0; i < count; i++) {
        System.out.print(" ");
    }
}

private static boolean allNodesNull(List<Node> nodes) {
    for (Node node : nodes) {
        if (node != null) {
            return false;
        }
    }
    return true;
}
}
