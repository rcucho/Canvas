package pe.edu.upc.canvas;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import java.util.Arrays;

import pe.edu.upc.canvas.databinding.ActivityMainBinding;
import pe.edu.upc.canvas.models.Circle;
import pe.edu.upc.canvas.viewmodels.CustomViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        CustomViewModel viewModel = new CustomViewModel();
        activityMainBinding.setVariable(BR.customViewModel, viewModel);
        activityMainBinding.executePendingBindings();

        //viewModel.backgroundFill.set(Color.YELLOW);
        //viewModel.setCircleList(Arrays.asList(new Circle(200,400), new Circle(400,400)));

    }
}