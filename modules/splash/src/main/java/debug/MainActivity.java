package debug;

import com.zcj.findpet.core.activities.ProxyActivity;
import com.zcj.findpet.core.delegate.AwesomeDelegate;
import com.zcj.findpet.splash.countdown.SplashCountdownDelegate;

/**
 * Created by zcj on 2018/4/6 9:54
 */
public class MainActivity extends ProxyActivity {

    @Override
    public AwesomeDelegate setRootDelegate() {
        return new SplashCountdownDelegate();
    }
}
