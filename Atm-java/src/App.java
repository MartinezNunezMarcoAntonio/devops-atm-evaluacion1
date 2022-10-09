
public class App {
    static InputData inputs = new InputData();
    static Atm atm = new Atm();

    public static void main(String[] args) {
        if( !pinIngressRequestAuthorization("1235", 3))
            System.exit(0);
        showWelcomeAndData("Tiburcio", 1000);
        showMainMenu();
        redirectSelectedOption(inputs.getMenuValue());
    }

    public static void redirectSelectedOption(int option) {
        switch (option) {
            case 1:
               atm.showAmount();
                break;
            case 2:
                cashOut();
                break;
            case 3:
                atm.showMovements();
                break;
            case 4:
                showMainMenu();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                break;
        }
        System.out.println("---------Seleccione una opcion mas del Menu----------");
        redirectSelectedOption(inputs.getMenuValue());
    }

    public static void cashOut() {
        System.out.println("Escriba la cantidad a retirar...");
        try {
            atm.cashOut(inputs.getAmountValue());
            System.out.println("Retirado exitosamente");
        } catch (Exception e) {
            System.out.println("Operacion no permitida, no tiene suficiente dinero(Lo saca dramaticamente a patadas...)");
        }
    }

    public static void showMainMenu() {
        System.out.println(".:: Menu principal ::.");
        System.out.println("1.- Consultar saldo ");
        System.out.println("2.- Retirar saldo");
        System.out.println("3.- Historico de movimientos");
        System.out.println("4.- Volver a mostrar este menu");
        System.out.println("5.- Salir");
    }

    public static boolean pinIngressRequestAuthorization(String defaultPin, int tries) {
        System.out.println("Ingrese el pin tiene " + tries + " intentos");
        for (int i = 0; i < tries; i++)
            if (defaultPin.equals(inputs.getStringInput()))
                return true;
        return false;
    }

    public static void showWelcomeAndData(String name, int amount) {
        atm.setAmount(amount);
        System.out.println("Bienvenido " + name + " usted tiene $" + amount + " pesos disponibles");
    }

}
