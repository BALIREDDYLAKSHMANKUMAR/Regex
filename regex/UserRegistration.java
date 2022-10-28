package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FunctionalInterface
interface patternMatcher {
    boolean pattern(String value, String pattern);
}

public class UserRegistration {
    Scanner SC = new Scanner(System.in);
    User UO = new User();

    patternMatcher patternChecker = (value, pattern) -> {
        Pattern patternObject = Pattern.compile(pattern);
        Matcher matchObject = patternObject.matcher(value);
        if (matchObject.matches()) {
            return true;
        } else {
            return false;
        }
    };

    void UserRegistrationMain() throws InvalidInputException {
        Boolean isValid;

        try {
             System.out.println("Please enter first name: ");
            String firstName = SC.nextLine();
            isValid = patternChecker.pattern(firstName, "^[A-Z]{1}[a-z]{3,}");
            if (isValid) {
                UO.setFirstName(firstName);
                System.out.println(UO.getFirstName());
            } else {
                throw new InvalidInputException();
            }

            System.out.println("Please enter last name: ");
            String lastName = SC.nextLine();
            isValid = patternChecker.pattern(lastName, "^[A-Z]{1}[a-z]{3,}");
            if (isValid) {
                UO.setLastName(lastName);
                System.out.println(UO.getLastName());
            } else {
                throw new InvalidInputException();
            }

            System.out.println("Please enter Email Id: ");
            String emailId = SC.nextLine();

            isValid = patternChecker.pattern(emailId, "^[a-z]{1}[a-zA-Z0-9+-.]*@[a-z0-9]*.[a-z]*(.[a-z]*?)$");
            if (isValid) {
                UO.setEmailId(emailId);
                System.out.println(UO.getEmailId());
            } else {
                throw new InvalidInputException();
            }

            System.out.println("Please enter Phone number: ");
            String phoneNumber = SC.nextLine();
            isValid = patternChecker.pattern(phoneNumber, "^[91]{2}[ ]{1}[0-9]{10}$");
            if (isValid) {
                UO.setPhoneNumber(phoneNumber);
                System.out.println(UO.getPhoneNumber());
            } else {
                throw new InvalidInputException();
            }

            System.out.println("Please enter Password: ");
            String password = SC.nextLine();
            isValid = patternChecker.pattern(password, "^(?=.*[a-z])(?=.*[A-Z])((?=.*[!@#&?/*~$^]{1})).{8,}$");
            if (isValid) {
                UO.setPassword(password);
                System.out.println(UO.getPassword());
            } else {
                throw new InvalidInputException();
            }
        } catch (InvalidInputException e) {
        	System.out.println("Invalid Input detected!");
        }
        SC.close();
    }

}
