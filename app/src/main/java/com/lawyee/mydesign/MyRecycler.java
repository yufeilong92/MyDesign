package com.lawyee.mydesign;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * @Author : YFL  is Creating a porject in YFPHILPS
 * @Email : yufeilong92@163.com
 * @Time :2017/1/18 09:44
 * @Purpose :
 */
public class MyRecycler extends RecyclerView {

    private OnBOttomCallback mOnBOttomCallback;

    public OnBOttomCallback getmOnBOttomCallback() {
        return mOnBOttomCallback;
    }

    public void setmOnBOttomCallback(OnBOttomCallback mOnBOttomCallback) {
        this.mOnBOttomCallback = mOnBOttomCallback;
    }

    private interface OnBOttomCallback{
        void onButtom();
    }


    public MyRecycler(Context context) {
        super(context);
    }

    public MyRecycler(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecycler(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onScrolled(int dx, int dy) {
        if (isSlideToBottom()){
            mOnBOttomCallback.onButtom();
        }
    }

    public boolean isSlideToBottom(){
        return this !=null&& this.computeVerticalScrollExtent()+this.computeVerticalScrollOffset()
                >=this.computeVerticalScrollRange();
    }
}
