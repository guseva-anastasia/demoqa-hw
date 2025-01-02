package helpers;

import com.github.javafaker.Faker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestData {


    Faker faker = new Faker(new Locale("en"));

    public
    String firstName = faker.name().firstName(), // Emory
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            telephoneNumber = faker.phoneNumber().subscriberNumber(10),
            shortTelephoneNumber = faker.phoneNumber().subscriberNumber(9),
            subject = faker.options().option("Hindi", "English", "Maths", "Physics", "Chemistry", "Biology", "Computer Science", "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History", "Civics"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            picture = faker.options().option("Cat.jpg", "Dog.png","Bird.svg"),
            userAddress = faker.address().fullAddress(),
            userPermanentAddress = faker.address().fullAddress(),
            userState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            userCity = getRandomCity(userState),
            BirthDay,
            BirthMonth,
            BirthYear;




    public String getRandomCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };

    }

    public TestData() {
        Date birthDate = faker.date().birthday(18, 70);
        DateFormat dayFormat = new SimpleDateFormat("d", Locale.UK);
        BirthDay = dayFormat.format(birthDate);
        DateFormat monthFormat = new SimpleDateFormat("MMMMM", Locale.UK);
        BirthMonth = monthFormat.format(birthDate);
        DateFormat yearFormat = new SimpleDateFormat("yyyy", Locale.UK);
        BirthYear =  yearFormat.format(birthDate);

    }

}