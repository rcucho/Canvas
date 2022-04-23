package pe.edu.upc.canvas.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
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
        for(Circle model : circleList)
            canvas.drawCircle(model.getX(), model.getY(), 100, mPaint);
    }

    public void setBackgroundFill(@ColorInt int backgroundFill){
        this.backgroundFill = backgroundFill;
    }

    public void setCircleList(List<Circle> circles){
        this.circleList = circles;
    }

}


