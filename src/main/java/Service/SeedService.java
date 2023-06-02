package Service;

import Activity.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Trieda funguje ako úložisko všetkých aktivít, rozdelených podľa typov.
 *
 */
public class SeedService {
    public static List<Activity> getSportActivities() {
        List<Activity> sportActivities = new ArrayList<>();

        sportActivities.add(new SportActivity("Tennis", 60, "Play tennis at the Drienova court", 15, "Tennis", "Tennis racket, tennis ball"));
        sportActivities.add(new SportActivity("Ice Hockey", 90, "Play ice hockey in the Aupark shopping centre", 20, "Ice Hockey", "Skates, pads, stick, puck"));
        sportActivities.add(new SportActivity("Indoor Swimming", 60, "Swim in an Olympic-sized pool", 7, "Swimming", "Swimsuit, towel, shampoo"));
        sportActivities.add(new SportActivity("Football Match", 60, "Play a game of football with friends or strangers", 0, "Football", "Ball and football boots"));
        sportActivities.add(new SportActivity("Cycling Tour", 120, "Explore the city on a rented bicycle", 10, "Cycling", "Bike and helmet"));

        return sportActivities;
    }
    public static List<Activity> getCultureActivities() {
        List<Activity> cultureActivities = new ArrayList<>();

        cultureActivities.add(new CultureActivity("Theatre Play", 120, "Watch a theatre play at Bratislava National Theatre", 20, "Theatre"));
        cultureActivities.add(new CultureActivity("Art Gallery", 60, "Visit Danubiana Meulensteen Art Museum", 10, "Art Gallery"));
        cultureActivities.add(new CultureActivity("Folk Dance Performance", 30, "Watch a traditional Slovak folk dance performance", 5, "Folk Dance"));
        cultureActivities.add(new CultureActivity("Classical Music Concert", 100, "Listen to a classical music concert at Reduta Theatre", 15, "Music"));
        cultureActivities.add(new CultureActivity("Museum Tour", 80, "Take a guided tour of Bratislava City Museum", 10, "Museum"));

        return cultureActivities;
    }

    public static List<Activity> getNatureActivities() {
        List<Activity> natureActivities = new ArrayList<>();

        natureActivities.add(new NatureActivity("Hiking in the Little Carpathians", 120, "Explore the beautiful hills and forests of the Little Carpathians on a guided hike", 0, "hilly"));
        natureActivities.add(new NatureActivity("Danube River Cruise", 40, "Take a relaxing cruise along the Danube River and enjoy the scenic views", 15, "water"));
        natureActivities.add(new NatureActivity("Mountain Biking in Bratislava Forest Park", 90, "Experience the thrill of mountain biking through the forested hills of Bratislava Forest Park", 20, "hilly"));
        natureActivities.add(new NatureActivity("Kayaking on the Danube River", 90, "Paddle along the Danube River and take in the city's stunning skyline from the water", 15, "water"));
        natureActivities.add(new NatureActivity("Hiking in the Devinska Kobyla National Nature Reserve", 120, "Hike in the stunning Devinska Kobyla National Nature Reserve", 0, "mountainous"));

        return natureActivities;
    }

    public static List<Activity> getCuisineActivities() {
        List<Activity> cuisineActivities = new ArrayList<>();

        cuisineActivities.add(new CuisineActivity("Traditional Slovak Cuisine", 60, "Experience traditional Slovak cuisine in a cozy restaurant in the heart of Bratislava", 10, "Bryndzové halušky", "Slovak"));
        cuisineActivities.add(new CuisineActivity("Authentic Asian Flavors", 60, "Enjoy a fusion of Asian flavors in a modern restaurant with a view of the Danube river", 8, "Sushi", "Asian"));
        cuisineActivities.add(new CuisineActivity("Greek Delights", 60, "Taste the flavors of Greece in a beautiful Greek taverna in the old town of Bratislava", 6, "Souvlaki","Greek"));
        cuisineActivities.add(new CuisineActivity("Authentic Italian Cuisine", 60, "Indulge in authentic Italian cuisine in a cozy trattoria in Bratislava", 10, "Margherita Pizza","Italian"));
        cuisineActivities.add(new CuisineActivity("Flavors of the Middle East", 60, "Experience the exotic flavors of the Middle East in a traditional Arabian restaurant in Bratislava", 12, "Hummus and Pita", "Middle Eastern"));

        return cuisineActivities;
    }

    public static List<Activity> getHistoryActivities() {
        List<Activity> historyActivities = new ArrayList<>();

        historyActivities.add(new HistoryActivity("Bratislava Castle Tour", 45, "Visit the historical Bratislava Castle", 0, "Castle"));
        historyActivities.add(new HistoryActivity("Old Town Walking Tour", 45, "Explore the historical Old Town of Bratislava", 0, "Old Town"));
        historyActivities.add(new HistoryActivity("Jewish History Walking Tour", 100, "Discover the rich Jewish history of Bratislava", 0, "Jewish"));
        historyActivities.add(new HistoryActivity("Devin Castle Visit", 120, "Experience the beauty and history of Devin Castle", 5, "Castle"));
        historyActivities.add(new HistoryActivity("Communist History Tour", 100, "Explore Bratislava's communist past", 0, "Communist"));

        return historyActivities;
    }
}
