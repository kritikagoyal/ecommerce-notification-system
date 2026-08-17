import java.util.ArrayList;
import java.util.List;

public class LocationChecker extends FraudChecker{

    List<String> blacklist = new ArrayList<String>();

    @Override
    public boolean check(Order order) {
        if (blacklist.contains(order.getCountry())) {
            return false;
        }
        System.out.println("[Fraud Check] LocationChecker: PASSED");
        return checkNext(order);
    }
}
