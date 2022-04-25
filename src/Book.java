import java.util.Objects;

public class Book {
    private String name;
    private Author author;
    private int pubYear;

    public Book(String name, Author author, int pubYear){
        this.name = name;
        this.author = author;
        this.pubYear = pubYear;
    }

    public Book(String name, String authName, String authSecondName, int pubYear){
        this.name = name;
        this.author = new Author(authName, authSecondName);
        this.pubYear = pubYear;
    }

    public String getName(){
        return this.name;
    }

    public Author getAuthor(){
        return this.author;
    }

    public int getPubYear(){
        return this.pubYear;
    }

    public void setName(String s){
        this.name = s;
    }

    public void setAuthor(Author author){
        this.author = author;
    }

    public void setPubYear(int pubYear){
        this.pubYear = pubYear;
    }

    public String toString(){
        return "[" + this.name + ". " + this.author.toString() + ". " + this.pubYear + "]";
    }
    public void print(){
        System.out.print(this.name + " за авторством " + this.author.getName() + " " + this.author.getSecondName()
                + " была опубликована в " + this.pubYear + " году");
    }

    public boolean equals(Object book){
        if(this.getClass() != book.getClass()){
            return false;
        }
        Book book1 = (Book) book;
        if(this.getAuthor().equals(book1.getAuthor()) && this.getName().equals(book1.getName()) && this.getPubYear() == book1.getPubYear()){
            return true;
        }
        return false;
    }

    public int hashCode(){
        return Objects.hashCode(this.toString());
    }

}
