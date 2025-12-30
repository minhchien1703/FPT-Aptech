import Entity.User;

import java.util.*;

public class ListPerformanceAnalysis {
    private final int  insert_target = 10;
    public List<String> list = new ArrayList<>();
    public LinkedList<String> linkedList = new LinkedList<>();
    public Queue<String> queue = new LinkedList<>();
    public HashMap<Integer, User> userHashMap = new HashMap<>();

    public ListPerformanceAnalysis() {}

    public void InsertInToList() {
        for (int i = 1; i <= insert_target; i++) {
            list.add("LIST-Peter " + i);
            linkedList.add("LINKED-LIST-Peter " + i);
            userHashMap.put(i, new User("Peter " + i, 10 + i));
        }
        System.out.println("\n Insert successfully!");
    }

//    LIST CRUD
    public List<String> GetAllList() {
        return list;
    }


//    LINKED LIST CRUD
    public LinkedList<String> GetAllLinkedList() {
        return linkedList;
    }
//    QUEUE

    public Queue<String> getQueue() {
        return queue;
    }

//    HASHMAP CRUD
    public HashMap<Integer, User> getAll() {
        return userHashMap;
    }







}
