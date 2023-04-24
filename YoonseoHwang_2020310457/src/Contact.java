import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Contact {
	
	static HashMap<String, String> contact = new HashMap<>();

	public static void show() {		
		List<String> keyList = new ArrayList<>(contact.keySet());
        keyList.sort((s1, s2) -> s1.compareTo(s2));
        for (String key : keyList) {
            System.out.println(key + " " + contact.get(key));
        }
	}
	
	public static void find(String name) {
		String value = contact.get(name);
		if(value == null) {
			System.out.println("error");
			return;
		}
		System.out.println(value);
		return;
	}
	
	public static void add(String name, String number) {
		String temp = contact.get(name);
		String val = contact.put(name, number);
		if (val != null) {
			System.out.println("error");
			contact.put(name, temp);
			return;
		}
		return;
	}
	
	public static void delete(String name) {
		String val = contact.remove(name);
		if (val == null) {
			System.out.println("error");
		}
		return;
	}
	
public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		String lines = "asdf";
		
		while (lines != null ) {

			lines = scn.nextLine();
			
			String[] commands = lines.split(" ");
					
			
			if (commands[0].equals("show")) {
				show();
			}
			
			else if (commands[0].equals("find")) {
				find(commands[1]);
			}
			
			else if (commands[0].equals("add")) {
				if(commands.length < 3) {
					System.out.println("error");
				}
				else {
					add(commands[1], commands[2]);
				}
			}
			
			else if (commands[0].equals("delete")) {
				delete(commands[1]);
			}
			
		}
		
		scn.close();
		
	}
	
}
