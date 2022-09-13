package lesson5;

public class Employee {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Имя: %s \tДолжность: %s \nEmail: %s \tНомер телефона: %s \nЗарплата: %d \tВозраст: %d \n",
                name, position, email, phone, salary, age);
    }

    public void print() {
        System.out.println(this);
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "89231423112", 30000, 30);
        employees[1] = new Employee("Popov Vasiliy", "SEO", "popov@mailbox.com", "89191423125", 60000, 50);
        employees[2] = new Employee("Krapivina Tatyana", "Marketolog", "tanya@mailbox.com", "89231423112", 25000, 41);
        employees[3] = new Employee("Kruglik Petr", "Tester", "krug@mailbox.com", "89681428552", 30000, 30);
        employees[4] = new Employee("Yusupova Larisa", "Engineer", "lara@mailbox.com", "89971423117", 30000, 45);


        for (Employee employee : employees)
            if (employee.getAge() >= 40) employee.print();
   }

    public int getAge() {
        return age;
    }
}

