package main;

//Main Class for Ride-Sharing Application
public class RideSharingApp {
 public static void main(String[] args) {
     // User Authentication (Singleton Pattern)
     UserAuth userAuth = UserAuth.getInstance();
     userAuth.login("john_doe");

     // Factory Method Pattern: Vehicle creation
     VehicleFactory carFactory = new CarFactory();
     Vehicle car = carFactory.createVehicle();
     car.bookRide();

     VehicleFactory bikeFactory = new BikeFactory();
     Vehicle bike = bikeFactory.createVehicle();
     bike.bookRide();

     // Abstract Factory Pattern: Payment method selection
     PaymentFactory creditCardFactory = new CreditCardFactory();
     PaymentMethod creditCard = creditCardFactory.createPaymentMethod();
     creditCard.pay(20.0);

     PaymentFactory paypalFactory = new PayPalFactory();
     PaymentMethod paypal = paypalFactory.createPaymentMethod();
     paypal.pay(15.0);
 }
}

//==================== Singleton Pattern ====================
class UserAuth {
 private static UserAuth instance;
 private String userName;

 private UserAuth() {}

 public static UserAuth getInstance() {
     if (instance == null) {
         instance = new UserAuth();
     }
     return instance;
 }

 public void login(String userName) {
     this.userName = userName;
     System.out.println("User logged in: " + userName);
 }

 public String getUserName() {
     return userName;
 }
}

//==================== Factory Method Pattern ====================
//Vehicle Interface
interface Vehicle {
 void bookRide();
}

//Concrete Vehicle Classes
class Car implements Vehicle {
 @Override
 public void bookRide() {
     System.out.println("Car ride booked successfully!");
 }
}

class Bike implements Vehicle {
 @Override
 public void bookRide() {
     System.out.println("Bike ride booked successfully!");
 }
}

class Scooter implements Vehicle {
 @Override
 public void bookRide() {
     System.out.println("Scooter ride booked successfully!");
 }
}

//Vehicle Factory
abstract class VehicleFactory {
 public abstract Vehicle createVehicle();
}

class CarFactory extends VehicleFactory {
 @Override
 public Vehicle createVehicle() {
     return new Car();
 }
}

class BikeFactory extends VehicleFactory {
 @Override
 public Vehicle createVehicle() {
     return new Bike();
 }
}

class ScooterFactory extends VehicleFactory {
 @Override
 public Vehicle createVehicle() {
     return new Scooter();
 }
}

//==================== Abstract Factory Pattern ====================
//Payment Method Interface
interface PaymentMethod {
 void pay(double amount);
}

//Concrete Payment Methods
class CreditCard implements PaymentMethod {
 @Override
 public void pay(double amount) {
     System.out.println("Paid $" + amount + " using Credit Card.");
 }
}

class PayPal implements PaymentMethod {
 @Override
 public void pay(double amount) {
     System.out.println("Paid $" + amount + " using PayPal.");
 }
}

class Cash implements PaymentMethod {
 @Override
 public void pay(double amount) {
     System.out.println("Paid $" + amount + " using Cash.");
 }
}

//Payment Factory
interface PaymentFactory {
 PaymentMethod createPaymentMethod();
}

class CreditCardFactory implements PaymentFactory {
 @Override
 public PaymentMethod createPaymentMethod() {
     return new CreditCard();
 }
}

class PayPalFactory implements PaymentFactory {
 @Override
 public PaymentMethod createPaymentMethod() {
     return new PayPal();
 }
}

class CashFactory implements PaymentFactory {
 @Override
 public PaymentMethod createPaymentMethod() {
     return new Cash();
 }
}

