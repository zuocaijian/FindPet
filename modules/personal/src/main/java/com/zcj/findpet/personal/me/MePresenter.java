package com.zcj.findpet.personal.me;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.zcj.image.ImageLoader;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * Datetime: 2018/4/10 9:52
 * Author: zcj
 */
public class MePresenter implements MeContract.Presenter {

    private MeContract.View mView;
    private MeContract.Model mModel;

    private Context mContext;
    private int mClickIndex;
    private ObservableEmitter<ClickEvent> mEmitter;
    private Disposable mClickDisposable;

    public MePresenter(Context context, MeContract.View view) {
        this.mContext = context;
        this.mView = view;
        this.mModel = new MeModel();
    }

    @Override
    public void start() {
        Observable
                .<ClickEvent>create(new ObservableOnSubscribe<ClickEvent>() {
                    @Override
                    public void subscribe(ObservableEmitter<ClickEvent> emitter) throws Exception {
                        mEmitter = emitter;
                    }
                })
                .buffer(1000, TimeUnit.MILLISECONDS)
                .map(new Function<List<ClickEvent>, Integer>() {
                    @Override
                    public Integer apply(List<ClickEvent> clickEvents) throws Exception {
                        return clickEvents.size();
                    }
                })
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer >= 2;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mClickDisposable = d;
                    }

                    @Override
                    public void onNext(Integer integer) {
                        mView.showToast("1s内点击了" + integer + "次", false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showToast("error", false);
                    }

                    @Override
                    public void onComplete() {
                        mView.showToast("complete", false);
                    }
                });
    }

    @Override
    public void testRx() {
        mEmitter.onNext(new ClickEvent(++mClickIndex));
    }

    @Override
    public void loadImg(ImageView view) {
        ImageLoader
                .getInstance()
                //.load("http://www.gif5.net/img/images/2016/06/23/NWFXOTVZNko1YTZ6.gif")
                .load("https://www.baidu.com/img/superlogo_c4d7df0a003d3db9b65e9ef0fe6da1ec.png?where=super")
                .with(mContext)
                .into(view);
    }

    @Override
    public void onLifeCycleChanged(@NonNull LifecycleOwner owner, @NonNull Lifecycle.Event event) {
    }

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
    }

    @Override
    public void onStart(@NonNull LifecycleOwner owner) {
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
    }

    @Override
    public void onStop(@NonNull LifecycleOwner owner) {
    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        if (mEmitter != null) {
            mEmitter.onComplete();
            mEmitter = null;
        }
        if (mClickDisposable != null) {
            if (!mClickDisposable.isDisposed()) {
                mClickDisposable.dispose();
            }
            mClickDisposable = null;
        }
    }
}
