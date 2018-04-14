package debug;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zcj.findpet.core.activities.ProxyActivity;
import com.zcj.findpet.core.delegate.AwesomeDelegate;
import com.zcj.findpet.personal.me.MeDelegate;

/**
 * Created by zcj on 2018/4/6 9:54
 */
public class MainActivity extends ProxyActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public AwesomeDelegate setRootDelegate() {
        return new MeDelegate();
    }
}
