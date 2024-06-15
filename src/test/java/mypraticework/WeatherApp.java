package mypraticework;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Scanner;

public class WeatherApp {

	static String myurl = "https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22";

	private static void getPressureData() {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the date (YYYY-MM-DD HH:00:00): ");
		String date = scanner.nextLine();
		// scanner.close();

		Response response = RestAssured.get(myurl);

		int statusCode = response.getStatusCode();
		System.out.println("Status Code: " + statusCode);

		String responseBody = response.getBody().asString();
		System.out.println("Response Body:");
		System.out.println(responseBody);
		if (response.statusCode() == 200) {
			String pressure = response.jsonPath().getString("list.find { it.dt_txt == '" + date + "' }.main.pressure");
			System.out.println("Pressure on " + date + ": " + pressure + " hPa");
		} else {
			System.out.println("Error fetching data from the API.");
		}
	}

	private static void getWeatherData() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the date (YYYY-MM-DD HH:00:00): ");
		String date = scanner.nextLine();
		// scanner.close();

		Response response = RestAssured.get(myurl);

		int statusCode = response.getStatusCode();
		System.out.println("Status Code: " + statusCode);

		String responseBody = response.getBody().asString();
		System.out.println("Response Body:");
		System.out.println(responseBody);

		if (response.statusCode() == 200) {
			String temp = response.jsonPath().getString("list.find { it.dt_txt == '" + date + "' }.main.temp");
			System.out.println("Temperature on " + date + ": " + temp + " °K");
		} else {
			System.out.println("Error fetching data from the API.");
		}
	}

	private static void getWindSpeedData() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the date (YYYY-MM-DD HH:00:00): ");
		String date = scanner.nextLine();
		// scanner.close();

		Response response = RestAssured.get(myurl);

		int statusCode = response.getStatusCode();
		System.out.println("Status Code: " + statusCode);

		String responseBody = response.getBody().asString();
		System.out.println("Response Body:");
		System.out.println(responseBody);

		if (response.statusCode() == 200) {
			String windSpeed = response.jsonPath().getString("list.find { it.dt_txt == '" + date + "' }.wind.speed");
			System.out.println("Wind Speed on " + date + ": " + windSpeed + " m/s");
		} else {
			System.out.println("Error fetching data from the API.");
		}
	}

	public static void main(String[] args) throws Throwable {

		Scanner scanner = null;
		int choice = 0;

		do {
			scanner = new Scanner(System.in);
			System.out.println("\nOptions:");
			System.out.println("1. Get weather");
			System.out.println("2. Get Wind Speed");
			System.out.println("3. Get Pressure");
			System.out.println("0. Exit");
			System.out.print("Enter your choice: ");

			choice = scanner.nextInt();
			// scanner.close();

			switch (choice) {
			case 1:
				getWeatherData();
				break;
			case 2:
				getWindSpeedData();
				break;
			case 3:
				getPressureData();
				break;
			case 0:
				System.out.println("Exiting the program.");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}

		} while (choice != 0);

		scanner.close();

	}
}
