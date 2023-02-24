import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Test");
        Car electro = new ElectricCar("Andrei"
                ,new ArrayList<Pasager>()
                ,TypeOfCar.ELECTRIC);
        Car electro1 = new ElectricCar("Paul"
                ,TypeOfCar.ELECTRIC);
        Car combust = new CombustCar("Ion"
                ,new ArrayList<Pasager>()
                ,TypeOfCar.COMBUST);
        Car combust1 = new CombustCar("Sebi"
                ,TypeOfCar.COMBUST);
        List<Car> cars = new ArrayList<>();
        cars.add(electro);
        cars.add(combust);
        cars.add(electro1);
        cars.add(combust1);
        electro.addPasager("Claudiu");
        electro1.addPasager("Sab","Tata");
        combust.addPasager("Sab","Tata","mama");

    }
}
enum TypeOfCar{
    ELECTRIC,
    COMBUST
}

class Pasager{
    private Integer id ;
    private String name;
    private static Integer count =1 ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.id = count++;
    }

    public Pasager( String name) {
        this.name = name;
    }
}
abstract class Car{
    protected String sofer ;
    protected ArrayList<Pasager> pasagers;
    protected TypeOfCar typeOf ;

    public String getSofer() {
        return sofer;
    }

    public void setSofer(String sofer) {
        this.sofer = sofer;
    }

    public ArrayList<Pasager> getPasagers() {
        return pasagers;
    }

    public void setPasagers(ArrayList<Pasager> pasagers) {
        this.pasagers = pasagers;
    }

    public TypeOfCar getTypeOf() {
        return typeOf;
    }

    public void setTypeOf(TypeOfCar typeOf) {
        this.typeOf = typeOf;
    }

    abstract void removePasager(String numePasager);

    void addPasager(Pasager pasager){pasagers.add(pasager);}

    abstract void addPasager(String pasager);
    abstract void addPasager(String pasager1,String pasager2,String pasager3);
    abstract void addPasager(String pasager1,String pasager2);
    abstract void addPasager(ArrayList<Pasager> pasagers);
    abstract String getTypeOF();

}

class ElectricCar extends Car{

    @Override
    void addPasager(String pasager1, String pasager2, String pasager3) {
        this.pasagers.add(new Pasager(pasager1));
        this.pasagers.add(new Pasager(pasager2));
        this.pasagers.add(new Pasager(pasager3));
    }

    @Override
    void addPasager(String pasager1, String pasager2) {
        this.pasagers.add(new Pasager(pasager1));
        this.pasagers.add(new Pasager(pasager2));
    }

    @Override
    void removePasager(String numePasager) {
        Boolean exists = false ;

        for (Pasager pasager : pasagers) {
            if(pasager.getName().equals(numePasager)) {
                pasagers.remove(pasager);
                exists =true;

                System.out.println("A fost exclus");
                break;
            }
        }
        if(!exists) System.out.println("Nu a fost exclus");
    }

    @Override
    void addPasager(String pasager) {
        pasagers.add(new Pasager(pasager));
    }

    public ElectricCar(String sofer, ArrayList<Pasager> pasagers, TypeOfCar typeOf ) {
        this.sofer = sofer;
        this.pasagers = pasagers;
        this.typeOf = typeOf;
    }
    public ElectricCar(String sofer,  TypeOfCar typeOf ) {
        this.sofer = sofer;
        this.pasagers = null;
        this.typeOf = typeOf;
    }

    @Override
    void addPasager(Pasager pasager) {
        this.pasagers.add(pasager);
    }

    @Override
    void addPasager(ArrayList<Pasager> pasagers) {
        this.pasagers.addAll(pasagers);
    }

    @Override
    String getTypeOF() {
        return "electric";
    }
}
class CombustCar extends Car{
    @Override
    void addPasager(String pasager) {
        pasagers.add(new Pasager(pasager));
    }

    public CombustCar(String sofer, ArrayList<Pasager> pasagers, TypeOfCar typeOf ) {
        this.sofer = sofer;
        this.pasagers = pasagers;
        this.typeOf = typeOf;
    }
    public CombustCar(String sofer, TypeOfCar typeOf ) {
        this.sofer = sofer;
        this.pasagers = null;
        this.typeOf = typeOf;
    }
    @Override
    String getTypeOF() {
        return "combustibil";
    }
    @Override
    void addPasager(String pasager1, String pasager2, String pasager3) {
        this.pasagers.add(new Pasager(pasager1));
        this.pasagers.add(new Pasager(pasager2));
        this.pasagers.add(new Pasager(pasager3));
    }

    @Override
    void addPasager(String pasager1, String pasager2) {
        this.pasagers.add(new Pasager(pasager1));
        this.pasagers.add(new Pasager(pasager2));
    }
    @Override
    void addPasager(Pasager pasager) {
        this.pasagers.add(pasager);
    }

    @Override
    void addPasager(ArrayList<Pasager> pasagers) {
        this.pasagers.addAll(pasagers);
    }
    @Override
    void removePasager(String numePasager) {
        Boolean exists = false ;

        for (Pasager pasager : pasagers) {
            if(pasager.getName().equals(numePasager)) {
                pasagers.remove(pasager);
                exists =true;

                System.out.println("A fost exclus");
                break;
            }
        }
        if(!exists) System.out.println("Nu a fost exclus");
    }
}
class Fabric{

    private ArrayList<Car> cars ;

    public Integer getCount(){
        return cars.size();
    }
}
