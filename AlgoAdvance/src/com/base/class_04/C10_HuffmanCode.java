package com.base.class_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 1.统计出各个字符的权
 * 2.得出hafuman编码
 * 3.对数据进行对应压缩：根据编码映射转换，再将转换厚的byte数组转成2进制拼接的字符串，字符串每8位转成十进制byte数组
 * 4.读入压缩数据和编码
 * 5.对应编码开始解码：将十进制byte数组转成二进制，将二进制拼接成字符串，字符串遍历，遍历到了相应的编码即转
 */
/**
 * https://blog.csdn.net/qq_28889087/article/details/88874336
 * https://blog.csdn.net/qq_45163122/article/details/107880552
 * @author dankejun
 * @create 2020/9/915:30
 */
public class C10_HuffmanCode {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println("原数组长度: " + contentBytes.length);//40
        System.out.println(Arrays.toString(contentBytes));//40

//
        byte[] huffmanCodeBytes = huffmanZip(contentBytes);
        System.out.println("huffmanCodeBytes" + Arrays.toString(huffmanCodeBytes));
//      
        System.out.println("start to decode====>");
        byte[] bytes = decode(huffmanCodes, huffmanCodeBytes);
        System.out.println(new String(bytes));
    }

    //数据的解压
    private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, b));
        }
        System.out.print(stringBuilder);
        System.out.println();

        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        
        // 每取一个字符，与之前的拼接，在编码map中对应的，没找到继续，找到了解码，拼接字符清空，继续下个下标查找
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length();) {
            int count = 1;
            boolean flag = true;
            Byte b = null;

            while (flag) {
                String key = stringBuilder.substring(i, i + count);
                b = map.get(key);
                if (b == null) {
                    count++;
                } else {
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }
        byte[] b = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }

    //把压缩的byte数组中的十进制数转化为2进制数
    private static String byteToBitString(boolean flag, byte b) {
        int temp = b;
        if (flag) {
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }

    //封装压缩操作
    private static byte[] huffmanZip(byte[] bytes) {
        List<Node> nodes = getNodes(bytes);

        Node root = creatHuffmanTree(nodes);

        Map<Byte, String> huffmanCodes = getCodes(root);

        byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);

        return huffmanCodeBytes;
    }

    /**
     *
     * @param bytes 原始的字符串对应的数组
     * @param huffmanCodes  生成的哈夫曼树编码map
     * @return 返回哈夫曼编码处理后的byte[]
     */
    private static byte[] zip(byte[] bytes , Map<Byte,String> huffmanCodes) {
        StringBuilder builder = new StringBuilder();

        for (byte b : bytes) {
            builder.append(huffmanCodes.get(b));
        }

        int len;
        if (builder.length() % 8 == 0) {
            len = builder.length() / 8;
        } else {
            len = builder.length() / 8 + 1;
        }

        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;
        for (int i = 0; i < builder.length(); i = i + 8) {
            String strByte;
            if (i + 8 > builder.length()) {
                strByte = builder. substring(i);
            } else {
                strByte = builder.substring(i, i + 8);
            }
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte,2);
            index++;
        }
        return huffmanCodeBytes;
    }

    static Map<Byte, String> huffmanCodes = new HashMap<>();

    static StringBuilder stringBuilder = new StringBuilder();

    private static Map<Byte, String> getCodes(Node root) {
        if (root == null) {
            return null;
        }
        getCodes(root.left, "0", stringBuilder);
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }
    /**
     * 将传入的node节点的所有叶子节点哈夫曼编码得到，并放入到huffmanCode集合中
     * @param node  传入节点
     * @param code  路径，左0右1
     * @param stringBuilder 用于拼接路径
     */
    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder builder = new StringBuilder(stringBuilder);
        builder.append(code);
        if (node != null) {
            if (node.data == null) {
                getCodes(node.left, "0", builder);
                getCodes(node.right, "1", builder);
            } else {
                huffmanCodes.put(node.data, builder.toString());
            }
        }
    }



    /**
     *
     * @param bytes 接收字节数组
     * @return 返回的就算List
     */
    private static List<Node> getNodes(byte[] bytes) {
        List<Node> nodes = new ArrayList<>();

        Map<Byte, Integer> counts = new HashMap<>();
        for (Byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count+1);
            }
        }

        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    //通过List创建哈夫曼树
    private static Node creatHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(null,leftNode.weight+rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;

            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}

//创建节点
class Node implements Comparable<Node>{
    Byte data;
    int weight;
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight-o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }
    
}
