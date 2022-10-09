import java.util.Scanner;

public class InputData {
    Scanner scanner = new Scanner(System.in);

    public String getStringInput() {
        return scanner.next();
    }

    public int getMenuValue() {
        try {
            int value = scanner.nextInt();
            if (value <= 0 || value > 5) {
                throw new ExceptionRange();
            }
            return value;
        } catch (ExceptionRange ex) {
            System.out.println("rango incorrecto, intente nuevamente...");
            scanner.nextLine();
            return getMenuValue();
        } catch (Exception e) {
            System.out.println("opcion incorrecta o no valida,intente nuevamente...");
            scanner.nextLine();
            return getMenuValue();
        }
    }

    public double getAmountValue() {
        try {
            double value = scanner.nextDouble();
            if (value < 0) {
                throw new ExceptionRange();
            }
            return value;
        } catch (ExceptionRange ex) {
            System.out.println("rango incorrecto, intente nuevamente...");
            scanner.nextLine();
            return getAmountValue();
        } catch (Exception e) {
            System.out.println("opcion incorrecta o no valida,intente nuevamente...");
            scanner.nextLine();
            return getAmountValue();
        }
    }
}

class ExceptionRange extends Exception {
}
