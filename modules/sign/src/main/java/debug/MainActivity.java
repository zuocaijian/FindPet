package debug;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;

import com.zcj.findpet.core.activities.ProxyActivity;
import com.zcj.findpet.core.delegate.AwesomeDelegate;
import com.zcj.findpet.sign.signin.SignInDelegate;

/**
 * Created by zcj on 2018/4/6 9:54
 */
public class MainActivity extends ProxyActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    @Override
    public AwesomeDelegate setRootDelegate() {
        return new SignInDelegate();
    }
}
