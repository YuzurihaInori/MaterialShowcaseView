package uk.co.deanwild.materialshowcaseview.target;

import android.graphics.Point;
import android.graphics.Rect;


public interface Target {

    //内部实现接口，不知道干嘛用的 
    Target NONE = new Target() {
        @Override
        public Point getPoint() {
            return new Point(1000000, 1000000);
        }

        @Override
        public Rect getBounds() {
            Point p = getPoint();
            return new Rect(p.x - 190, p.y - 190, p.x + 190, p.y + 190);
        }
    };

    Point getPoint();

    Rect getBounds();
}
