import java.util.List;

public class StarRating {

    public String toString() {

        String url = "https://imdb-api.com/en/API/MostPopularMovies/k_9w0jvobo";

        ExtratorDeConteudo extrator = new ExtratorDeConteudo();

        var http = new Client();
        String json = http.buscaDados(url);

        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        for (int i = 0; i < 10; i++) {

            Conteudo conteudo = conteudos.get(i);

            Double avaliacao = Double.parseDouble(conteudo.getRating());

            if (Math.round(avaliacao) == 1) {
                return "\u2B50";
            } else if (Math.round(avaliacao) == 2) {
                return "\u2B50\u2B50";
            } else if (Math.round(avaliacao) == 3){
                return "\u2B50\u2B50\u2B50";
            } else if (Math.round(avaliacao) == 4){
                return "\u2B50\u2B50\u2B50\u2B50";
            } else if (Math.round(avaliacao) == 5){
                return "\u2B50\u2B50\u2B50\u2B50\u2B50";
            } else if (Math.round(avaliacao) == 6){
                return "\u2B50\u2B50\u2B50\u2B50\u2B50\u2B50";
            } else if (Math.round(avaliacao) == 7){
                return "\u2B50\u2B50\u2B50\u2B50\u2B50\u2B50\u2B50";
            } else if (Math.round(avaliacao) == 8){
                return "\u2B50\u2B50\u2B50\u2B50\u2B50\u2B50\u2B50\u2B50";
            } else if (Math.round(avaliacao) == 9){
                return "\u2B50\u2B50\u2B50\u2B50\u2B50\u2B50\u2B50\u2B50\u2B50";
            } else {
                return "\u2B50\u2B50\u2B50\u2B50\u2B50\u2B50\u2B50\u2B50\u2B50\u2B50";
            }

        }
        return toString();
    }

}
