import java.util.ArrayList;
import java.util.List;

public class Filter {

    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        String msgStart = "Запускаем фильтрацию";
        logger.log(msgStart);
        for (int i = 0; i < source.size(); i++) {
            if (source.get(i) < treshold) {
                logger.log(String.format("Элемент \"%d\" не проходит", source.get(i)));
            } else {
                logger.log(String.format("Элемент \"%d\" проходит", source.get(i)));
                result.add(source.get(i));
            }
        }
        return result;
    }
}
