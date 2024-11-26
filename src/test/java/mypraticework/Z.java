package mypraticework;

public class Z {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		X obj1 = new Y();
		obj1.method();
		Y obj2 = new Y();
		obj2.method();

				String message = "Your confirmation code is 228890";

				// Extract only digits
				String number = message.replaceAll("[^0-9]", "");

				System.out.println("Extracted Number: " + number);
			}
		}


