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
        System.out.println();

        // Part 3. Homework #10. Mandatory tasks. Methods with contract

        Author auth3 = new Author("Одноглаз", "Безруков");

        if(auth3.equals(book3.getAuthor())){
            System.out.println("Автор \"" + auth3 + "\" уже есть в библиотеке");
        } else {
            System.out.println("Автор \"" + auth3 + "\" может быть добавлен в библиотеку");
        }

        if(auth3.hashCode() == book3.getAuthor().hashCode()){
            System.out.println("Похоже, что автор \"" + auth3 + "\" уже есть в библиотеке");
        } else {
            System.out.println("Выглядит так, что автор \"" + auth3 + "\" может быть добавлен в библиотеку");
        }

        book4 = new Book("Средняя энциклопедия Интернет-монстров", "Одноглаз",
                "Безруков", 2077);

        if(book4.equals(book3)){
            System.out.println("Книга " + book4 + " уже есть в библиотеке");
        } else {
            System.out.println("Книгу " + book4 + " можно добавить в библиотеку");
        }

        if(book4.hashCode() == book3.hashCode()){
            System.out.println("Похоже, чсто книга " + book4 + " уже есть в библиотеке");
        } else {
            System.out.println("Выгладит так, что книгу " + book4 + " можно добавить в библиотеку");
        }

        // Test code from difficult tasks

        System.out.println("Authors:");
        Author stephenKing = new Author("Stephen", "King");
        Author stephenKing2 = new Author("Stephen", "King");
        Author levTolstoy = new Author("Lev", "Tolstoy");
        System.out.println("Author copies equal: " + stephenKing.equals(stephenKing2));
        System.out.println("Author copies equal by hashCode: " + (stephenKing.hashCode() == stephenKing2.hashCode()));
        System.out.println("Authors equal: " + stephenKing.equals(levTolstoy));
        System.out.println("Authors equal by hashCode: " + (stephenKing.hashCode() == levTolstoy.hashCode()));

        System.out.println(stephenKing);
        System.out.println(levTolstoy);

        System.out.println("==============================");

        System.out.println("Books:");
        Book theStand = new Book("The Stand", stephenKing, 1976);
        Book theStand2 = new Book("The Stand", stephenKing, 1976);
        Book warAndPeace = new Book("War and Peace", levTolstoy, 1869);
        System.out.println("Book copies equal: " + theStand.equals(theStand2));
        System.out.println("Book copies equal by hashCode: " + (theStand.hashCode() == theStand2.hashCode()));
        System.out.println("Books equal: " + theStand.equals(warAndPeace));
        System.out.println("Books equal by hashCode: " + (theStand.hashCode() == warAndPeace.hashCode()));
        System.out.println(theStand);
        System.out.println(warAndPeace);

        System.out.println("==============================");

        Library library = new Library(2);
        library.add(theStand);
        library.add(warAndPeace);
        System.out.println(library);

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