public class Library {
    private Book[] bookArray;

    public Library(int libSize){
        this.bookArray = new Book[libSize];
    }

    public void add(Book book) {
        int freeIndex = this.lookingForFreeIndex();
        if(freeIndex >= 0){
            this.bookArray[freeIndex] = book;
        } else {
            throw new RuntimeException("Критическая ошибка: библиотека заполнена полностью! Завершение работы");
        }
    }

    public Book findBookByName(String name){
        for (Book book : this.bookArray) {
            if (book != null && book.getName().equals(name))
                return book;
        }
        return null;
    }

    public void findAndPrintBookByName(String name){
        Book book = this.findBookByName(name);
        if(book != null){
            book.print();
            System.out.println();
        } else {
            System.out.println("Книга с таким названием не найдена");
        }
    }

    public void changeBookPubYear(String name, int newPubYear){
        Book book = this.findBookByName(name);
        if(book != null){
            book.setPubYear(newPubYear);
        } else {
            System.out.println("Книга с таким названием не найдена");
        }
    }

    private int lookingForFreeIndex(){
        for(int i = 0; i < this.bookArray.length; i++)
            if(this.bookArray[i] == null){
                return i;
            }
        return -1;
    }

    public void print(){
        for(int i = 0; i < this.bookArray.length; i++){
            if(this.bookArray[i] != null){
                System.out.println("Книга в библиотеке с номером " + i +": " + this.bookArray[i]);
            }
        }
    }

}
