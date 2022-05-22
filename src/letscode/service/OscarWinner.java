package letscode.service;


        import java.util.Objects;

public class OscarWinner
{
    private int  year;
    private int age;
    private String name;
    private String movie;

    public OscarWinner(int year, int age, String name, String movie) {
        this.year = year;
        this.age = age;
        this.name = name;
        this.movie = movie;
    }

    public int getYear() {
        return year;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getMovie() {
        return movie;
    }

    @Override
    public String toString() {
        return  "year=" + year +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", movie='" + movie + '\''
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OscarWinner that = (OscarWinner) o;
        return year == that.year && age == that.age && name.equals(that.name) && movie.equals(that.movie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, age, name, movie);
    }
}
