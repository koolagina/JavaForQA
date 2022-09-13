package lesson5;
//1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
//2. Конструктор класса должен заполнять эти поля при создании объекта.
//3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
//4. Создать массив из 5 сотрудников.
//Пример:
//Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
//persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
//persArray[1] = new Person(...);
//...
//persArray[4] = new Person(...);
//
//5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
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
        //System.out.println("ФИО сотрудника: " + employee.getName() + "; Должность: " + employee.getPosition() + "; email: " + employee.getEmail() + "; Телефон: " + employee.getPhone() + "; Зарплата: " + employee.getSalary() + "; Возраст: " + employee.getAge());

    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }
}

