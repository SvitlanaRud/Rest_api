package SerializationDeserializationWithRestAssured;

public class VideoGame {

    String name;
    String releaseDate;
    String category;
    String rating;
    int id;
    int reviewScore;


    public VideoGame(){

    }
    public VideoGame(String name, int reviewScore, String releaseDate, String category, String rating, int id){
        this.name = name;
        this.reviewScore = reviewScore;
        this.releaseDate = releaseDate;

        this.category = category;
        this.rating = rating;
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "VideoGame{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", reviewScore=" + reviewScore +
                '}';
    }

}
