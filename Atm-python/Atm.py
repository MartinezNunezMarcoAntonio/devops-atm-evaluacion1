
import sys;
from datetime import datetime

class InputData :
    def getStringInput(self) :
        return input()

    def getMenuValue(self) :
        try :
            value = int(input())
            if (value <= 0 or value > 5) :
                raise Exception("ExceptionRange")
            return value
        except Exception as e:
            print("opcion incorrecta o no valida,intente nuevamente...")
            return self.getMenuValue()

    def getAmountValue(self) :
        try :
            value = float(input())
            if (value < 0) :
                raise Exception("ExceptionRange")
            return value
        except Exception as e:
            print("opcion incorrecta o no valida,intente nuevamente...")
            return self.getAmountValue()


class Atm :
    amount = 0.0
    historicalMovements = []

    def __init__(self) :
        self.amount = 0

    def cashOut(self, amount) :
        resultSet = self.amount - amount
        if (resultSet < 0) :
            raise Exception("ExceptionAmountNotAllowed")
        movement = "Saldo anterior: " + str(self.amount) + ", Saldo retirado: " + str(amount) + \
        " saldo actual: " + str(resultSet) + ", Fecha: " + self.getCurrentDate()
        self.amount = resultSet
        self.historicalMovements.append(movement)

    def setAmount(self, amount) :
        self.amount = amount

    def getAmount(self) :
        return self.amount

    def showAmount(self) :
        print("Saldo actual es de: " + str(self.amount))

    def showMovements(self) :
        for movement in self.historicalMovements :
            print(movement)

    def getCurrentDate(self) :
        now = datetime.now()
        return now.strftime("%d/%m/%Y %H:%M:%S")

class App :
    inputs = InputData()
    atm = Atm()

    def main() :
        if (not App.pinIngressRequestAuthorization("1235", 3)) :
            sys.exit(0)
        App.showWelcomeAndData("Tiburcio", 1000)
        App.showMainMenu()
        App.redirectSelectedOption(App.inputs.getMenuValue())

    def redirectSelectedOption(option) :
        if (option == 1):
            App.atm.showAmount()
        elif (option == 2):
            App.cashOut()
        elif (option == 3):
            App.atm.showMovements()
        elif (option == 4):
            App.showMainMenu()
        elif (option == 5):
            sys.exit(0)
        print("---------Seleccione una opcion mas del Menu----------")
        App.redirectSelectedOption(App.inputs.getMenuValue())

    def cashOut() :
        print("Escriba la cantidad a retirar...")
        try :
            App.atm.cashOut(App.inputs.getAmountValue())
            print("Retirado exitosamente")
        except Exception as e :
            print("Operacion no permitida, no tiene suficiente dinero(Lo saca dramaticamente a patadas...)")

    def showMainMenu() :
        print(".:: Menu principal ::.")
        print("1.- Consultar saldo ")
        print("2.- Retirar saldo")
        print("3.- Historico de movimientos")
        print("4.- Volver a mostrar este menu")
        print("5.- Salir")

    def pinIngressRequestAuthorization(defaultPin, tries) :
        print("Ingrese el pin tiene " + str(tries) + " intentos")
        i = 0
        while (i < tries) :
            if (defaultPin == App.inputs.getStringInput()) :
                return True
            i += 1
        return False

    def showWelcomeAndData(name, amount) :
        App.atm.setAmount(amount)
        print("Bienvenido " + name + " usted tiene $" + str(amount) + " pesos disponibles")


if __name__ == "__main__":
    App.main()
