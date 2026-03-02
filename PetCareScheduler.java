import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PetCareScheduler {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Pet> pets = new HashMap<>();
    private static Map<String, Appointment> appointment =  new HashMap<>();

    public static void main(String[] args) {
        boolean running = true;
        while(running) {
            System.out.println("\n=== Pet Care Scheduler ===");
            System.out.println("1. Register Pets");
            System.out.println("2. Schedule Appointments");
            System.out.println("3. Store Data");
            System.out.println("4. Display Records");
            System.out.println("5. Generate Reports");
            System.out.println("6. Save and Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case '1':
                    registerPet();
                    break;
                case '2':
                    scheduleAppointments();
                    break;
                case '3':
                    storeDate();
                    break;
                case '4':
                    displayData();
                    break;
                case '5':
                    generateReports();
                    break;
                case '6':
                    savePetsToFile();
                    running = false;
                    System.out.println("Data saved. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-6.");
            }
        }
    }

    private static void registerPet() {

        System.out.print("Enter Pet ID: ");
		String id = scanner.nextLine().trim();  // Read and trim input

		if (pets.containsKey(id)) {
			System.out.println("Error: Pet ID already exists.");
			return;  // Stop and return early if duplicate found
		}

		System.out.print("Enter Pet Name: ");
		String name = scanner.nextLine().trim();

		System.out.print("Enter Pet Species: ");
		String species = scanner.nextLine().trim();

        System.out.print("Enter Pet Age: ");
        int age = scanner.nextInt();

        System.out.print("Enter Pet Owner Name: ");
		String ownerName = scanner.nextLine().trim();

		System.out.print("Enter Pet Contact Info: ");
		String contactInfo = scanner.nextLine().trim();

		Pet pet = new Pet(id, name, species, age, ownerName, contactInfo);

		pets.put(id, pet);

		System.out.println("Pet registered successfully on " + pet.getJoinDate());
    }

    private static void scheduleAppointments() {
        System.out.print("Enter Pet ID: ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String id = scanner.nextLine().trim();

        Pet pet = pets.get(id);

        if (pet == null) {
            System.out.println("Error: Pet ID not found");
            return;
        }

        LocalDateTime dateAppointment = null;

        while(true) {
            System.out.print("Enter a Date with this format (yyyy-MM-dd HH:mm): ");
            String date = scanner.nextLine().trim();

            try {
                dateAppointment = LocalDateTime.parse(date, formatter);
                if (dateAppointment.isAfter(LocalDateTime.now())) {
                    break;
                } else {
                    System.out.println("The date/time must be in the future. Please try again.");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. Please use yyyy-MM-dd HH:mm.");
            }
        }
    }
}