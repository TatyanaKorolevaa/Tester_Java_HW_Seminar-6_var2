import java.util.*;


public class PhoneBook {
    private static Map<String, List<String>> phoneNote = new HashMap<>();

    public static void main(String[] args) {
        int menuOption = 1;

        String name = "";
        String phone = "";
        while (menuOption > 0){
            menuOption = menu();

            switch (menuOption){
                case 1:
                name = readStrConsole("ФИО: ");
                    phone = readStrConsole("Номер: ");
                    setPhone(name, phone);
                    break;
                case 2:
                name = readStrConsole("ФИО: ");
                    List<String> phones = getPhones(name);
                    if(phones.size() == 0) {
                        System.out.println("Контакт не найден!");
                    }else {
                        System.out.println(phones.toString());
                    }
                    break;
            }
        }

    }

    public static int menu(){
        System.out.println("1 - Добавить контакт");
        System.out.println("2 - Найти контакт");
        System.out.println("0 - Выход");
        return readIntConsole("Выберите действие: ");
    }

    public static List<String> getPhones(String name) {
        return phoneNote.getOrDefault(name, new ArrayList<>());
    }
    
    public static void setPhone(String name, String phoneNumber) {
        if (phoneNote.containsKey(name)) {
            if (!phoneNote.get(name).contains(phoneNumber)) {
                phoneNote.get(name).add(phoneNumber);
            }
        } else {
            List<String> phoneList = new ArrayList<>();
            phoneList.add(phoneNumber);
            phoneNote.put(name, phoneList);
        }
    }

    public static String readStrConsole(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.next();
    }
  
    public static int readIntConsole(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextInt();
    }

}
