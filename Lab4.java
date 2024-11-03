// інтерфейс Customer
interface Customer {
    void createContract();          // оформить договор
    void terminateContract();       // розірвати договір
    void renewContract();           // поновити договір
    void updatePersonalData(String name, String address);  // змінити персональні дані
    void addPurchase(double amount);                       // додати покупку
    void receivePayment(double amount);                    // отримати оплату
    void addDiscount(double discount);                     // додати знижку
    double getBalance();
}

// клас реалізує інтерфейс Customer
class RegularCustomer implements Customer {
    private String name;
    private String address;
    private String contractStatus;
    private double balance;
    private double discount;

    // конструктор класу покупець
    public RegularCustomer(String name, String address) {
        this.name = name;
        this.address = address;
        this.contractStatus = "Contract is not formalized";
        this.balance = 0.0;
        this.discount = 0.0;
    }
    // створюємо контракт
    @Override
    public void createContract() {
        contractStatus = "Contract is executed";
        System.out.println("The contract is drawn up for the client " + name);
    }
    // розриваємо контракт
    @Override
    public void terminateContract() {
        // перевіряємо чи був створений контракт
        if (!contractStatus.equals("Contract is not formalized")) {
            contractStatus = "Contract terminated";
            System.out.println("Contract terminated for the client " + name);
        } else {
            System.out.println("Cannot terminate contract: it is not formalized for client " + name);
        }
    }
    // поновлюємо контракт
    @Override
    public void renewContract() {
        // перевіряємо, чи був розірваний контракт
        if (contractStatus.equals("Contract terminated")) {
            contractStatus = "Contract is executed";
            System.out.println("Contract renewed for the client " + name);
        } else {
            System.out.println("Contract is already active for the client " + name);
        }
    }
    // поновлюємо персональні дані покупця
    @Override
    public void updatePersonalData(String name, String address) {
        this.name = name;
        this.address = address;
        System.out.println("Personal data updated for the client: " + name + ", address: " + address);
    }
    // додаємо покупку
    @Override
    public void addPurchase(double amount) {
        // Применяем скидку к стоимости покупки
        double discountedPrice = amount - (amount * (discount / 100)); // Применяем скидку
        if (discountedPrice <= balance) {
            balance -= discountedPrice; // Уменьшаем баланс на стоимость покупки со скидкой
            System.out.println("Purchase added for the amount: " + discountedPrice);
        } else {
            System.out.println("Insufficient balance for the purchase of: " + discountedPrice);
        }
    }
    // плата за товари
    @Override
    public void receivePayment(double amount) {
        balance -= amount;
        System.out.println("Payment for the amount received: " + amount);
    }
    // додаємо "знижку" користувачу
    @Override
    public void addDiscount(double discount) {
        this.discount = discount;
        System.out.println("Added a discount: " + discount + "%");
    }
    // перевірка балансу (баланс - скільки клієнт повинен заплатити)
    @Override
    public double getBalance() {
        return balance;
    }
}

// приклад використання
public class Main {
    public static void main(String[] args) {
        Customer customer = new RegularCustomer("Ярослав", "Кривий Ріг, вул. Якась, 47");

        customer.createContract();
        // customer.updatePersonalData("Бебрік", "Львів, вул. Пітонська, 18");
        customer.addPurchase(100.0);
        customer.receivePayment(50.0);
        customer.addDiscount(10.0);

        System.out.println("Баланс клієнта: " + customer.getBalance());

        customer.terminateContract();
        customer.renewContract();

    }
}
