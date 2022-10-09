import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Atm {
    
    private double amount;
    public List<String> historicalMovements = new ArrayList<>();    
    
    public Atm(){
        this.amount = 0;
    }
    
    public void cashOut(double amount) throws ExceptionAmountNotAllowed{
        double resultSet = this.amount - amount;
        if( resultSet < 0 )
            throw new ExceptionAmountNotAllowed();
        String movement = "Saldo anterior: "+this.amount + ", Saldo retirado: "+amount+" saldo actual: "
                            + resultSet + ", Fecha: " + getCurrentDate();
        this.amount = resultSet;
        historicalMovements.add(movement);
    }
    
    public void setAmount(double amount){
        this.amount = amount;
    }
    
    public double getAmount(){
        return this.amount;
    }
    
    public void showAmount(){
        System.out.println("Saldo actual es de: " + this.amount);
    }
    
    public void showMovements(){
        for(String movement: historicalMovements)
            System.out.println(movement);
    }
    
    public String getCurrentDate(){
        LocalDateTime dateObj = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateObj.format(formatter);
    }


}

class ExceptionAmountNotAllowed extends Exception{
    
}
