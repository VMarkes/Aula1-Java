import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        String url = "https://imdb-api.com/en/API/MostPopularMovies/k_9w0jvobo";
        ExtratorDeConteudo extrator = new ExtratorDeConteudo();

        var http = new Client();
        String json = http.buscaDados(url);

        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var generator = new StickerMaker();

        StarRating star = new StarRating();

        for (int i = 0; i < 10; i++) {

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String fileName = conteudo.getTitulo() + ".png";

            generator.make(inputStream, fileName);

            System.out.println(conteudo.getTitulo());
            System.out.println(conteudo.getUrlImagem());
            System.out.println(star);

            System.out.println("De 1 a 10, qual nota você dá para este filme?");
            Scanner sdc_recebe = new Scanner(System.in);
            String sdc_armazena = sdc_recebe.nextLine();
            int resposta = Integer.parseInt(sdc_armazena);

            System.out.println("Thanks!");
            System.out.println();

        }
    }
}
