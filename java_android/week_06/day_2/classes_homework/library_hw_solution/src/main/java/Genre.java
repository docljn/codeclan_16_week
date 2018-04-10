public enum Genre {

    THRILLER("An exciting plot, typically involving crime or espionage."),
    CRIME("action or activity considered to be evil, shameful, or wrong."),
    ROMANCE("love in a sentimental or idealized way."),
    FANTASY("Idea with no basis in reality.");

    private String description;


    Genre(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
