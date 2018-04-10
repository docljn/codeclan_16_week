public class Book {

    private Genre genre;
    private String title;
    private String author;

    public Book(String title, String author, Genre genre){
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public Genre getGenre() {

        return genre;
    }

    public String getTitle() {
        return title;
    }

    public String getGenreDescription(){
        return this.genre.getDescription();
    }
}
