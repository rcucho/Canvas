package pe.edu.upc.canvas.viewmodels;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableInt;
import androidx.databinding.library.baseAdapters.BR;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.canvas.models.Circle;

public class CustomViewModel extends BaseObservable {

    public final ObservableInt backgroundFill = new ObservableInt();
    @Bindable
    private List<Circle> circleList = new ArrayList<>();

    public List<Circle> getCircleList(){
        return circleList;
    }

    public void setCircleList(List<Circle> circleList){
        this.circleList = circleList;
        notifyPropertyChanged(BR.circleList);
    }
}
