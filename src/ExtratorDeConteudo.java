import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudo {

    List<Conteudo> extraiConteudos(String json) {

        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        for (Map<String, String> atributos : listaDeAtributos) {
            String title = atributos.get("title");
            String rating = atributos.get("imDbRating");
            String urlImage = atributos.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");
            var conteudo = new Conteudo(title, urlImage, rating);
            conteudos.add(conteudo);
        }

        return conteudos;
    }

}
