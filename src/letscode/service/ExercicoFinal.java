package letscode.service;



        import java.io.IOException;
        import java.nio.file.Files;
        import java.nio.file.Path;
        import java.nio.file.Paths;
        import java.util.ArrayList;
        import java.util.List;

        import static com.letscode.service.OscarMetodos.*;

public class ExercicioFinal {

    public static void main(String[] args) {

        List<OscarWinner> maleList = readLines(Paths.get("male.csv"));
        List<OscarWinner> femaleList = readLines(Paths.get("female.csv"));

        List<OscarWinner> allOscarWinnerList = new ArrayList(maleList.size() + femaleList.size());
        allOscarWinnerList.addAll(maleList);
        allOscarWinnerList.addAll(femaleList);

        System.out.println("Ator mais jovem a ganhar um Oscar: " + getAtorMaisJovemGanharOscar(maleList));
        System.out.println("--------------------------------------------------");
        System.out.println("Atriz que foi mais vezes premiada: " + getAtrizMaisVezPremiada(femaleList));
        System.out.println("--------------------------------------------------");
        getTudoSobreAPessoa(allOscarWinnerList, "Spencer Tracy");
        System.out.println("--------------------------------------------------");
        getAtoresQueReceberamMaisDeUmOscar(allOscarWinnerList);
        System.out.println("--------------------------------------------------");
        System.out.println("Atriz entre 20 e 30 anos que foi mais vezes vencedora: "+ getAtrizEntreIdades(maleList));
    }

    private static List<OscarWinner> readLines(Path file){
        try {
            List<String> lines = Files.readAllLines(file);
            List<OscarWinner> oscarWinnerList = new ArrayList<>();

            lines.stream().skip(1).forEach(line -> {
                String[] linesSplited = line.split(";");
                oscarWinnerList.add(new OscarWinner(
                        Integer.parseInt(linesSplited[1].trim()),
                        Integer.parseInt(linesSplited[2].trim()),
                        linesSplited[3].trim(),
                        linesSplited[4].trim()));
            });
            return oscarWinnerList;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}