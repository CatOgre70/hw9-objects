public class Main {
    public static void main(String[] args) {

        // Part 1. Mandatory tasks

        Author auth1 = new Author("Иван", "Иванов");
        Book book1 = new Book("Большая энциклопедия высказываний в Интернете", "Петр",
                "Петров", 2022);
        Author auth2 = book1.getAuthor();
        Book book2 = new Book("Малая энциклопедия Интернет-мемов", auth1, 2015);

        System.out.println("Автор первой книги: " + auth2);
        System.out.println("book1 = " + book1);
        System.out.println("book2 (было)  = " + book2);
        book2.setPubYear(2016);
        System.out.println("book2 (стало) = " + book2);

    }
}