import org.json.JSONArray;
import org.json.JSONObject;

import javax.sound.midi.SysexMessage;
import java.io.BufferedReader;
import java.util.*;
import java.util.regex.Pattern;

public  class Main {
    public static void main(String[] args) {


    }

    private Map<Integer, List<String>> getFrequency(List<String> list) {

        Map<String, Integer> map = new HashMap<>();

        for (String s : list) {
            String[] strings = s.split(",");
            for (String str : strings) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }

        Map<Integer, List<String>> ans = new TreeMap<>((a, b) -> b - a);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            if (ans.get(entry.getValue()) == null) {
                ans.put(entry.getValue(), new ArrayList<>());
            }

            List<String> l = ans.get(entry.getValue());
            l.add(entry.getKey());
        }

        return ans;
    }
}









interface Stack  {

    void push(int data);
    int pop();

    int peek();

    boolean isEmpty();

}


class StackImpl implements Stack {

    private LinkedList list;
    public StackImpl() {
        this.list = new LinkedList();
    }

    @Override
    public void push(int data) {
        list.add(data);
    }

    @Override
    public int pop() {
        return list.remove();
    }

    @Override
    public int peek() {
        return list.peek();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}


class LinkedList {

    private DataNode head;

    public void add(int data) {

        DataNode node = new DataNode(data);
        if (head == null) {
            head = node;
        } else {
            node.setNext(head);
            head = node;
        }
    }

    public int remove() {

        if (head == null) {
            return -1;
        }

        int data = head.getVal();
        head = head.getNext();

        return data;
    }

    public int peek() {
        if (head == null) {
            return -1;
        }
        return head.getVal();
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }
}


class DataNode {

    private int val;
    private DataNode next;

    public DataNode(int data) {
        this.val = data;
    }
    public int getVal() {
        return this.val;
    }

    public void setVal(int data) {
        this.val = data;
    }

    public void setNext(DataNode node) {
        this.next = node;
    }

    public DataNode getNext() {
        return this.next;
    }

}

































