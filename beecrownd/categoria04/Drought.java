import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** 
 * 
 * Beecrownd 1023
 * link -> https://judge.beecrowd.com/en/problems/view/1023
 * 
 * @author Thomas Neuenschwander
 * @since 11/12/2024
*/
record Residency(int population, double consumption) {
    public double consumptionPerPerson(){
        return population == 0 ? 0 :  consumption / population;
    }
}

record City(Residency[] residences) {

    public Double calculateAverageConsumption() {
        int numPeople = 0;
        Double consumption = 0.0;
        for(Residency res : residences){
            numPeople += res.population();
            consumption += res.consumption();
        }
        return consumption/numPeople;
    }

  // -------------------- SORT IN ASCENDING ORDER OF CONSUMPTION ----------------
    private void sortByConsumptionPerPerson() {
        int tam = residences.length;
        for(int i = 1; i < tam; i++){
            Residency piv = residences[i];
            int j = i-1;
            while((j >= 0) && piv.consumptionPerPerson() < residences[j].consumptionPerPerson()){
                residences[j+1] = residences[j];
                j--;
            }
            residences[j+1] = piv;
        }
    }

  // -------------------- LIST CONSUMPTION SORTED -------------------------
    public void showConsumption(){
        sortByConsumptionPerPerson();
        for(Residency res : residences)
            System.out.print(res.population()+"-"+res.consumptionPerPerson()+" ");
        System.out.println();
    }
    
}


public class Drought {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<City> cities = new ArrayList<>();

        int n = sc.nextInt();
        while (n != 0) 
        {
            Residency[] residences = new Residency[n];

            for(int i = 0; i < n; i++) 
                residences[i] = new Residency(sc.nextInt(), sc.nextInt());


            cities.add(new City(residences));

            n = sc.nextInt();
        }

        int cityNumber = 1;
        for(City city: cities){
            System.out.println("Cidade# "+cityNumber+":");
            city.showConsumption();
            System.out.println("Consumo medio: "+ city.calculateAverageConsumption()+" m3.");
        }

        sc.close();
    }
}
