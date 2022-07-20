import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // Fazer conexão HTTP e buscar os top 250 filmes
        String url = "https://alura-filmes.herokuapp.com/conteudos";
        URI address = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(address).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // Extrair dados(Título, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // Exibir e manipular dados
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println(" Título: " + filme.get("title"));
            System.out.println(" Poster: " + filme.get("image"));
            System.out.println("Classificação: " + filme.get("imDbRating"));
            
        }
        
    }
}