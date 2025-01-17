


//     a) Lag en klasse som representerer en planet og kall denne Planet.
//        Det vi ønsker å vite om en gitt planet er navn, radius og masse
//        En planet skal kunne opprettes ved hjelp av en konstruktør på følgende måte:
//
//              Planet planet = new Planet("Mars", 3889.5, 6.39E23);
//              (Husk å gjøre instansvariablene private, og lag get- og set-metoder.
//              Da får vi en innkapsling av disse (ett av prinsippene i OOP).)



public class Planet {

    private String navn;
    private double radius;
    private double masse;

    public Planet(String n, double rad, double ma){
        navn = n;
        radius = rad;
        masse = ma;
    }

    public void print(){
        System.out.println("Planeten " + navn + " har en radius på " + radius + "km og en masse på " + masse + " kg");
    }

    private void setNavn(String navn){this.navn = navn;}
    private void setRadius(double radius){this.radius = radius;}
    private void setMasse(double masse){this.masse = masse;}

    public String getNavn() {return navn;}
    public double getRadius() {return radius;}
    public double getMasse() {return masse;}
}
