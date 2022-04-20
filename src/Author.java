public class Author {
    private String name;
    private String secondName;

    public Author(String name, String secondName){
        this.name = name;
        this.secondName = secondName;
    }

    public String getName(){
        return this.name;
    }

    public String getSecondName(){
        return this.secondName;
    }

    public void setName(String s){
        this.name = s;
    }

    public void setSecondName(String s){
        this.secondName = s;
    }

    public String toString(){
        return this.secondName + " " + this.name;
    }

}
