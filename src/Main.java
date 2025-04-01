import com.olympic.bean.ScannerBean;
import com.olympic.service.OlympicService;

public class Main {
    public static void main(String[] args) {

        ScannerBean.getScanner();
        new OlympicService().homePage();
        ScannerBean.closeScanner();
    }
}