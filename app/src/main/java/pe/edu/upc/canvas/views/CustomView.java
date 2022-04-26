package pe.edu.upc.canvas.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;

import java.util.Collections;
import java.util.List;

import pe.edu.upc.canvas.models.Circle;

public class CustomView extends View {

    private Paint mPaint = new Paint();
    private int backgroundFill;
    private List<Circle> circleList = Collections.emptyList();

    ///para el evento ontouch
    private Path mPath = new Path();

    public CustomView(Context context, @Nullable AttributeSet attributeSet) {

        super(context, attributeSet);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        mPaint.setColor(backgroundFill);
        canvas.drawPaint(mPaint);

        mPaint.setColor(Color.BLUE);
        /*for(Circle model : getCircleList()) {
            canvas.drawCircle(model.getX(), model.getY(), 100, mPaint);
        }*/
        /// para el evento ontouch
        if (accion =="down"){
            mPath.moveTo(iniTouchX,iniTouchY);
            canvas.drawCircle(iniTouchX, iniTouchY, 100, mPaint);
        }
        if (accion == "move") {
            mPath.moveTo(iniTouchX, iniTouchY);
            canvas.drawCircle(iniTouchX, iniTouchY, 100, mPaint);
        }
        if (accion == "up")
            mPath.moveTo(iniTouchX, iniTouchY);
            canvas.drawCircle(iniTouchX, iniTouchY, 100, mPaint);

        canvas.drawPath(mPath,mPaint);
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

    ///para el evento ontouch
    float iniTouchX = 50;
    float iniTouchY = 50;
    String accion = "accion";

    @Override
    public boolean onTouchEvent(MotionEvent event){
        iniTouchX = event.getX();
        iniTouchY = event.getY();
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            accion = "down";
        }
        if (event.getAction() == MotionEvent.ACTION_MOVE){
            accion = "move";
        }
        if(event.getAction() == MotionEvent.ACTION_UP){
            accion = "up";
        }

        invalidate();
        return true;
    }
}


