import controller.JACkController;
import model.JACkModel;
import view.JACkView;

public class Main {

    public static void main(String[] args) {
        JACkModel model = new JACkModel();
        JACkView view = new JACkView();
        JACkController controller = new JACkController(model,view);
    }

}
