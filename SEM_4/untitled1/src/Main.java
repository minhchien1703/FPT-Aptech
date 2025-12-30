import java.util.*;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        List<String> List = new ArrayList<>();
//        List.add("Jenny");
//        List.add("Peter");
//        List.add("Peter");
//        List.add("Tom");
//        String name = List.get(0);
//        System.out.println("name" + name);
//        System.out.println("LIST:");
//        for (int i = 0; i < List.size() - 1; i++) {
//            System.out.println("name" + List.get(i));
//        }
//
//        HashMap<String, String> hashMap = new HashMap<>();
//        hashMap.put("Male", "KYOTO");
//        hashMap.put("Male", "ADIKATO");
//        hashMap.put("Female", "SUKYO");
//        String hName = hashMap.get("Female");
//        System.out.println("name" + hName);
//        System.out.println("\nHASHMAP:");
//        System.out.println(hashMap);
//
//        Deque<Integer> ll = new LinkedList<>();
//        ll.add(2);
//        ll.add(3);
//        ll.add(3);
//        ll.add(4);
//        System.out.println("\nDEQUE: ");
//        System.out.println(ll);
//        int check = ll.removeFirst();
//        System.out.println("\nREMOVE AFTER DEQUE: " + check);
//        System.out.println(ll);
//
//        List<String> rawEmails = java.util.List.of("O@gmail.com", "O@gmail.com", "V@gmail.com");
//        HashSet<String> hs = new HashSet<>();
//        for (var email : rawEmails) {
//            hs.add(email.toLowerCase());
//        }
//        System.out.println("\nHASHSET: ");
//        System.out.println(hs);
//        System.out.println(hs.contains("O@gmail.com".toLowerCase()));


// ENJOY COLLECTIONS
        var performanceAnalysis = new ListPerformanceAnalysis();
        performanceAnalysis.InsertInToList();

        System.out.println("\n1. List");
        System.out.println("\n2. LinkedList");
        System.out.println("\n3. Queue");
        System.out.println("\n3. HashMap");
        int options = sc.nextInt();

        switch (options) {
            case 1:
                while (true) {
                    System.out.println("\n1. GET ALL");
                    System.out.println("\n2. UPDATE");
                    System.out.println("\n3. CREATE");
                    System.out.println("\n4. DELETE");
                    System.out.println("\n5. CANCEL");
                    int action = sc.nextInt();
                    sc.close();
                    if (action == 1) {
                        var list = performanceAnalysis.GetAllList();
                        if (!list.isEmpty()) {
                            System.out.println(list);
                        } else {
                            System.out.println("List is null!");
                        }
                    } else if (action == 2) {

                    } else if (action == 5) {
                        break;
                    }
                }

                break;
            case 2:
                System.out.println("\n1. GET ALL");
                System.out.println("\n2. UPDATE");
                System.out.println("\n3. CREATE");
                System.out.println("\n4. DELETE");

                break;
            case 3:
                System.out.println("\n1. GET ALL");
                System.out.println("\n2. UPDATE");
                System.out.println("\n3. CREATE");
                System.out.println("\n4. DELETE");
                int action = sc.nextInt();

                if (action == 1) {
                    var list = performanceAnalysis.GetAllList();

                } else if (action == 2) {

                }

                break;
            case 4:
                System.out.println("\n1. GET ALL");
                System.out.println("\n2. UPDATE");
                System.out.println("\n3. CREATE");
                System.out.println("\n4. DELETE");

                break;

            default:
                System.out.println("Choose again!");
        }





    }
}