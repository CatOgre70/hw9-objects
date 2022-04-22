public class Main {
    public static void main(String[] args) {

        // Part 1. Mandatory tasks

        // Task 1. Basic operations with classes & objects

        Author auth1 = new Author("Иван", "Иванов");
        Book book1 = new Book("Большая энциклопедия высказываний в Интернете", "Петр",
                "Петров", 2022);

        Book book2 = new Book("Малая энциклопедия Интернет-мемов", auth1, 2015);

        System.out.println("Автор первой книги: " + book1.getAuthor());
        System.out.println("book1 = " + book1);
        System.out.println("book2 (было)  = " + book2);
        book2.setPubYear(2016);
        System.out.println("book2 (стало) = " + book2);
        System.out.println();

        // Part 2. Difficult tasks

        // Task 2. Book array operations

        Book[] bookArray = new Book[10];

        bookArray[4] = book1;
        bookArray[7] = book2;
        Book book3 = new Book("Средняя энциклопедия Интернет-монстров", "Одноглаз",
                "Безруков", 2077);

        int freeIndex = lookingForFreeIndex(bookArray);
        if(freeIndex >= 0) {
            bookArray[freeIndex] = book3;
        } else {
            throw new RuntimeException("Критическая ошибка: каталог книг заполнен полностью! Завершение работы");
        }
        printBookArray(bookArray);
        System.out.println();

        // Task 3. Library class

        Library lib = new Library(10);
        lib.add(book1);
        lib.add(book2);
        lib.add(book3);
        Book book4 = lib.findBookByName("Средняя энциклопедия Интернет-монстров");
        if(book4 != null) {
            book4.print();
            System.out.println();
        } else {
            System.out.println("Книга с таким названием не найдена");
        }
        lib.findAndPrintBookByName("Малая энциклопедия Интернет-монстров");
        lib.changeBookPubYear("Средняя энциклопедия Интернет-монстров", 2076);
        lib.findAndPrintBookByName("Средняя энциклопедия Интернет-монстров");
        System.out.println("\n");

        // Final Library state
        System.out.println("Финальное состояние нашей библиотеки:");
        lib.print();

    }

    public static int lookingForFreeIndex(Book[] bArray){
        for(int i = 0; i < bArray.length; i++)
            if(bArray[i] == null){
                return i;
            }
        return -1;
    }

    public static void printBookArray(Book[] bArray){
        for(int i = 0; i < bArray.length; i++){
            if(bArray[i] != null){
                System.out.println("Книга в каталоге с номером " + i +": " + bArray[i]);
            }
        }
    }

}