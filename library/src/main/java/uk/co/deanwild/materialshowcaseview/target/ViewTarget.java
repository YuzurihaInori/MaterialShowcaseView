package uk.co.deanwild.materialshowcaseview.target;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;


public class ViewTarget implements Target {

    private final View mView;

    //这里的view应该就是要绑定的view
    public ViewTarget(View view) {
        mView = view;
    }

    // TODO: 2016/6/28 这里存在一个问题，如果是fragment+id就无法使用
    //根据activity对象和id获取view对象
    public ViewTarget(int viewId, Activity activity) {
        mView = activity.findViewById(viewId);
    }

    @Override
    public Point getPoint() {
        int[] location = new int[2];
        //获取全局坐标系（括了通知栏的高度）中view所在位置的x和y值，
        mView.getLocationInWindow(location);
        
        //获取view的中心点坐标
        int x = location[0] + mView.getWidth() / 2;
        int y = location[1] + mView.getHeight() / 2;

        //创建一个点
        return new Point(x, y);
    }

    @Override
    public Rect getBounds() {
        int[] location = new int[2];
        //获取全局坐标系（括了通知栏的高度）中view所在位置的x和y值，
        mView.getLocationInWindow(location);

        //返回一个矩形，大小为view的测量宽高
        return new Rect(
                location[0],
                location[1],
                location[0] + mView.getMeasuredWidth(),
                location[1] + mView.getMeasuredHeight()
        );
    }
}
