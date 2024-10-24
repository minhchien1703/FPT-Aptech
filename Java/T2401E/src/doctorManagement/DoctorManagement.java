package doctorManagement;

import javax.print.Doc;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class DoctorManagement {
        HashMap<String, Doctor> hashMap = new HashMap<>();
        DoctorHash doctorHash;
        Doctor doctor;

        public DoctorManagement() {
            try {
                Doctor doc1 = new Doctor("Doc1", "Doctor1", "Spec1", 1);
                Doctor doc2 = new Doctor("Doc2", "Doctor2", "Spec2", 2);
                Doctor doc3 = new Doctor("Doc3", "Doctor3", "Spec3", 3);
                hashMap.put(doc1.getCode(), doc1);
                hashMap.put(doc2.getCode(), doc2);
                hashMap.put(doc3.getCode(), doc3);
                doctorHash = new DoctorHash(hashMap);
                doctorHash.displayAll();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    public void createDoctor() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("\n1. Add Doctor");
            System.out.println("2. Update Doctor");
            System.out.println("3. Delete Doctor");
            System.out.println("4. Search Doctor");
            System.out.println("5. Exit");
            System.out.print("Enter your choose:");
            int choose;
            choose = scanner.nextInt();
            scanner.nextLine();
            switch (choose) {
                case 1:
                    try{
                        System.out.print("Enter code: ");
                        String code = scanner.nextLine();
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter spec: ");
                        String spec = scanner.nextLine();
                        int intergerAvail;
                        while (true) {
                            try {
                                System.out.print("Enter avail: ");
                                String avail = scanner.nextLine();
                                System.out.println("\n");
                                intergerAvail = doctorHash.checkAvailability(avail);
                                if (intergerAvail > 0) {
                                    break;
                                }
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        Doctor doc = new Doctor(name, code, spec, intergerAvail);
                        boolean check = doctorHash.addDoctor(doc);
                        if (check)
                            System.out.println("\nAdd success.\n");
                        doctorHash.displayAll();
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.print("Enter Doctor code update: ");
                        String code = scanner.nextLine();
                        Doctor getDocByCode = hashMap.get(code);
                        if (!hashMap.containsKey(doctor.getCode()))
                            throw new Exception("Doctor code doesn’t exist !");

                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter spec: ");
                        String spec = scanner.nextLine();
                        int integerAvail;
                        while (true) {
                            try {
                                System.out.print("Enter avail: ");
                                String avail = scanner.nextLine();
                                integerAvail = doctorHash.checkAvailability(avail);
                                if(integerAvail > 0) {
                                    break;
                                }
                                Doctor doc = new Doctor(code, name, spec, integerAvail);
                                boolean check = doctorHash.updateDoctor(doc);
                                if (check)
                                    System.out.println("\nUpdate success.\n");

                                doctorHash.displayAll();
                            } catch (Exception e) {
                                throw new Exception(e.getMessage());
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 3:
                    System.out.print("Enter Doctor code: ");
                    String code = scanner.nextLine();
                    try {
                        doctor = hashMap.get(code);
                        boolean check = doctorHash.deleteDoctor(doctor);
                        if (check)
                            System.out.println("\nDelete success.\n");
                        doctorHash.displayAll();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.print("Enter Doctor search: ");
                        String text = scanner.nextLine();
                        HashMap<String, Doctor> hashMapDoctorSearching;
                        hashMapDoctorSearching = doctorHash.searchDoctor(text);
                        if (hashMapDoctorSearching == null)
                            throw new Exception("Data is null !");

                        Set<String> keys = hashMapDoctorSearching.keySet();
                        Iterator<String> keyIterator = keys.iterator();
                        while(keyIterator.hasNext()) {
                            String key = keyIterator.next();
                            doctor = hashMapDoctorSearching.get(key);
                            doctor.display();
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 5:
                    System.out.println("\nExit Success!");
                    return;
                default:
                    System.err.println("Please choose 1 to 5.");
                    break;
            }
        }

    }

}
