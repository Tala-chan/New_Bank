import java.util.ArrayList;

public class Transaktionskonto extends Account{
    ArrayList<Integer> historik= new ArrayList<Integer>();

    public Transaktionskonto(User owner, int balance){
        super(owner, balance);
    }

    @Override
    public void transaction() {
        super.transaction();
        historik.add(amount);
    }

    @Override
    public void list(){
        System.out.println(historik.toString());
    }
}
