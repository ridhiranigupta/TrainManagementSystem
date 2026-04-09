import java.util.*;
import java.util.regex.*;

class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}

public class TrainManagementSystem {

    public static void main(String[] args) {

        System.out.println("===========================================");
        System.out.println(" UC11 - Validate Train ID and Cargo Code");
        System.out.println("===========================================\n");

        Scanner scanner = new Scanner (System.in);
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        CharSequence trainId = scanner.nextLine();
        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        CharSequence cargoID = scanner.nextLine();

        Pattern trainPattern = Pattern.compile("TRN-\\d{4}");
        Pattern cargoPattern = Pattern.compile("PET-[A-Z]{2}");

        boolean isTrainValid = trainPattern.matcher(trainId).matches();
        boolean isCargoValid = cargoPattern.matcher(cargoID).matches();

        System.out.println("Validation Results:");
        System.out.println("Train ID Valid: "+isTrainValid);
        System.out.println("Cargo Code Valid: "+isCargoValid);

        System.out.println("UC11 validation completed...");
    }
}