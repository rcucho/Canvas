package pe.edu.upc.canvas.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import pe.edu.upc.canvas.models.Circle;

public class CustomView extends View {

    private Paint mPaint;
    private int backgroundFill;
    private List<Circle> circleList;
    private List<Paint> paintList;
    private Circle mCircle;
    private float mCircleRadio = 100;

    ///para el evento ontouch
    private Path mPath;

    public CustomView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        paintList = new ArrayList<>();
        circleList = new ArrayList<>();

    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        int i = 0;
        for(Circle circle : getCircleList()){
            canvas.drawCircle(circle.getX(),circle.getY(),mCircleRadio, paintList.get(i));
        }

    }

    public void setBackgroundFill(@ColorInt int backgroundFill){
        this.backgroundFill = backgroundFill;
    }
    public List<Circle> getCircleList(){
        return circleList;
    }
    public void setCircleList(List<Circle> circles){
        this.circleList = circles;
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean onTouchEvent(MotionEvent event){
        float xDown = event.getX(),yDown = event.getY();
        final float xp = xDown, yp = yDown;

        List<Circle> list = circleList.stream().filter(x-> isInside(x.getX(),x.getY(),mCircleRadio,xp,yp)).collect(Collectors.toList());

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                xDown = event.getX();
                yDown = event.getY();


                mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
                mPaint.setStyle(Paint.Style.FILL);
                mPaint.setColor(Color.BLUE);
                paintList.add(mPaint);
                mCircle = new Circle(xDown, yDown);
                mPath = new Path();
                mPath.moveTo(xDown, yDown);

                if(list.size() == 0)
                    circleList.add(mCircle);
                break;
            case MotionEvent.ACTION_MOVE:

                float xMoved = 0, yMoved = 0;
                xMoved = event.getX();
                yMoved = event.getY();

                if (list.size() > 0){
                    mCircle = list.get(list.size()-1);
                    mCircle.setX(xMoved);
                    mCircle.setY(yMoved);
                }
                else {
                    mCircle.setX(xMoved);
                    mCircle.setY(yMoved);
                }
                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        invalidate();
        return true;
    }

    private boolean isInside(float xCircle, float yCircle, float radio, float x, float y){
        double x2 = Math.pow(x-xCircle, 2);
        double y2 = Math.pow(y-yCircle, 2);
        if (x2 + y2 <= radio*radio)
            return true;
        else
            return false;
    }
}


