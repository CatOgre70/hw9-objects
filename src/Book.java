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

}
