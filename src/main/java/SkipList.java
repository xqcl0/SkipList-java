import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class SkipList<K extends Comparable<K>, V> {
    // 跳表的最大高度
    public static final int MAX_LEVEL = 32;
    // 跳表的头节点
    private Node<K, V> header;  // 头节点
    // 跳表中的节点数量
    private int nodeCount;
    // 跳表当前的最高层级
    private int skipListLevel;
    // 数据持久化保存文件路径
    public static final String STORE_FILE = "./store";

    private static class Node<K extends Comparable<K>, V> {
        public K key;
        public V value;
        public int level;
        ArrayList<Node<K, V>> forwards;

        public Node(K key, V value, int level) {
            this.key = key;
            this.value = value;
            this.level = level;
            this.forwards = new ArrayList<>(Collections.nCopies(level + 1, null));
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private static int generateRandomLevel() {
        int level = 1;
        Random random = new Random();
        while (random.nextInt(2) == 1) {
            level++;
        }
        return Math.min(level, MAX_LEVEL);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        int value = sc.nextInt();
        int level = sc.nextInt();
        Node<Integer,Integer> node = new Node<>(key, value, level);
        System.out.println(node.getKey() + " " + node.getValue());
    }

}
