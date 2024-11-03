import java.util.ArrayList;
import java.util.List;

//базовый клас печатного издания
class PrintEdtion {
    //поля
    private String name;
    private String author;
    //конструктор
    public PrintEdtion(String name, String author) {
        this.name = name;
        this.author = author;
    }
    //геттер поля имени
    public String getName() {
        return name;
    }
    //геттер поля автора
    public String getAuthor() {
        return author;
    }
}

//подкласс книга
class Book extends PrintEdtion {
    //конструктор подкласса книга
    public Book(String name, String author) {
        super(name, author);    //super вызывает констуктор базового класса
    }
}
//подкласс журнал
class Magazine extends PrintEdtion {
    //конструктор подкласса журнал
    public Magazine(String name, String author) {
        super(name, author);    //super вызывает констуктор базового класса
    }
}

//класс книжный магазин
class BookStore {
    //список который хранит экземпляры наследников класса PrintEdition
    private List<PrintEdtion> publications;
    //конуструктор, который инициализирует пустой список, создавая экземпляр ArrayList
    public BookStore() {
        this.publications = new ArrayList<>();
    }

    //метод, который добавляет обьект класса PrintEdition
    public void addPublication(PrintEdtion publication) {
        this.publications.add(publication);
    }

    //метод для подсчета количества экземляров класса Book
    public int countBooks() {
        int count = 0;
        for (PrintEdtion publication : this.publications) {
            //с помощью оператора instanceof проверяем наличие экземпляров класса Book
            //в списке publications
            if (publication instanceof Book) {
                count++;
            }
        }
        //возвращаем колво экземпляров класса Book
        return count;
    }

    //метод для подсчета количества экземляров класса Magazine
    public int countMagazines() {
        int count = 0;
        for (PrintEdtion publication : this.publications) {
            //с помощью оператора instanceof проверяем наличие экземпляров класса Magazine
            //в списке publications
            if (publication instanceof Magazine) {
                count++;
            }
        }
        //возвращаем колво экземпляров класса Magazine
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        BookStore store = new BookStore();

        //добавляем книги и журналы
        store.addPublication(new Book("Lord Of The Mysteries", " Guimi Zhi Zhu"));
        store.addPublication(new Book("harry potter and the philosopher's stone", "J. K. Rowling"));
        store.addPublication(new Magazine("National Geographic", "Nathan Lump"));
        store.addPublication(new Magazine("Science", "Holden Thorp"));

        //выводи количество книг и журналов
        System.out.println("Books count: " + store.countBooks());
        System.out.println("Magazine count: " + store.countMagazines());
    }
}
