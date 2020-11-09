package tp2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import tp2.entities.Car;
import tp2.entities.User;
import tp2.utils.ItemsGenerator;

/**
 *
 * @author tactfactory
 *
 *  - Cr�er un programme qui permet, en utilisant la fonction "stream()" sur la variable users,
 *      d'afficher les informations suivantes :
 *    - 1 : Le nombre d'utilisateur
 *    - 2 : Le nombre d'utilisateur dans la premi�re lettre du pr�nom commence par "a"
 *    - 3 : Le nombre d'utilisateur dont le nom et le pr�nom contienent exactement 5 caract�res
 *    - 4 : Le nombre d'utilisateur dont le full name contient entre 13 et 16 caract�res
 *    - 5 : Les utilisateurs poss�dant une voiture de la marque "marque1"
 *    - 6 : La premi�re voiture avec le plus haut kilom�trage
 *    - 7 : La liste des voitures avec le plus haut kilom�trage
 *    - 8 : La marque poss�dant le plus de voiture avec le nombre de voiture poss�d�
 *    - 9 : Les marques poss�dant le moins de voiture avec chacune des voitures pour chaque marque
 *    -10 : La liste des utilisateurs tri�e par nom puis par pr�nom
 */
public class Tp2 {

  public static void main(String[] args) {
    List<User> users = ItemsGenerator.generateUsers();

    for (User user : users) {
      System.out.println(user);
    }

    long nbUsers = users.stream().count();
    System.out.println(String.format("%s %d", "Nombre d'utilisateur", nbUsers));

    long nbUsersA = users.stream().filter(x -> x.getFirstname().startsWith("a")).count();
    System.out.println(
        String.format("%s %d", "Nombres d'utilisateur dans la premi�re lettre du pr�nom commence par \"a\"", nbUsersA));

    long nbUsersFLName5 = users.stream().filter(x -> x.getFirstname().length() == 5).filter(x -> x.getLastname().length() == 5).count();
    System.out.println(String.format("%s %d",
        "Les utilisateurs dont le nom et le pr�nom contienent exactement 5 caract�res", nbUsersFLName5));

    long nbUsersFullname1316 = users.stream().filter(x -> x.getLastname().length() >= 13).filter(x -> x.getLastname().length() <= 16).count();;
    System.out.println(String.format("%s %d", "Les utilisateurs dont le full name contient entre 13 et 16 caract�res",nbUsersFullname1316));

    List<User> usersCarMarque1 = users.stream().filter(x -> "marque1".equals(x.getCar().getCarType().getMark())).collect(Collectors.toList());
    System.out.println("Les utilisateurs poss�dant une voiture de la marque \"marque1\"");
    for (User user : usersCarMarque1) {
      System.out.println(String.format("\t%s", user));
    }

    Optional<Car> carMaxMileage = users.stream().collect(Collectors.maxBy(Comparator.comparingLong(x -> x.getCar().getMileage()))).map(x -> {
    	return x.getCar();
    });
    System.out.println(String.format("%s %s", "La voiture avec le plus haut kilom�trage", carMaxMileage));

    // 7 : La liste des voitures avec le plus haut kilom�trage
//    List<Car> carMaxMileages = users.stream();
//    System.out.println("La liste des voitures avec le plus haut kilom�trage");
//    for (Car car : carMaxMileages) {
//      System.out.println(String.format("\t%s", car));
//    }

    // 8 : La marque poss�dant le plus de voiture avec le nombre de voiture poss�d�
//    Entry<String, List<User>> markMaxCar = users.stream();
//    System.out.println(String.format("%s est %s avec %d voitures", "La marque poss�dant le plus de voiture",
//        markMaxCar.getKey(), markMaxCar.getValue().size()));

    // 9 : Les marques poss�dant le moins de voiture avec chacune des voitures pour chaque marque
//    int minCars = users.stream();
//    List<Entry<String, List<Car>>> markMinCars = users.stream();
//    System.out.println("Les marques poss�dant le moins de voiture avec chacune des voitures pour chaque marque");
//    for (Entry<String, List<Car>> entry : markMinCars) {
//      System.out.println("\t" + entry.getKey() + " :");
//      for (Car car : entry.getValue()) {
//        System.out.println("\t\t" + car);
//      }
//    }

    // 10 : La liste des utilisateurs tri�e par nom puis par pr�nom
//    List<User> sortedUsers = users.stream();
//    System.out.println("La liste des utilisateurs tri�e par nom puis par pr�nom");
//    for (User user : sortedUsers) {
//      System.out.println("\t" + user);
//    }
  }

}
