package com.demo.spin_wheel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bluehomestudio.luckywheel.OnLuckyWheelReachTheTarget;
import com.bluehomestudio.luckywheel.WheelItem;
import com.demo.spin_wheel.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
List<WheelItem>wheelItemList =new ArrayList<>();
String points;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());


WheelItem wheelItem1 = new WheelItem(ResourcesCompat.getColor(getResources(), R.color.r1,null),
        BitmapFactory.decodeResource(getResources(),R.drawable.coins),"0 %");
    wheelItemList.add(wheelItem1);
        WheelItem wheelItem2 = new WheelItem(ResourcesCompat.getColor(getResources(), R.color.r2,null),
                BitmapFactory.decodeResource(getResources(),R.drawable.coins),"1%");
        wheelItemList.add(wheelItem2);
        WheelItem wheelItem3 = new WheelItem(ResourcesCompat.getColor(getResources(), R.color.r1,null),
                BitmapFactory.decodeResource(getResources(),R.drawable.coins),"10 %");
        wheelItemList.add(wheelItem3);
        WheelItem wheelItem4 = new WheelItem(ResourcesCompat.getColor(getResources(), R.color.r2,null),
                BitmapFactory.decodeResource(getResources(),R.drawable.coins),"20%");
        wheelItemList.add(wheelItem4);

        WheelItem wheelItem5 = new WheelItem(ResourcesCompat.getColor(getResources(), R.color.r1,null),
                BitmapFactory.decodeResource(getResources(),R.drawable.coins),"40 %");
        wheelItemList.add(wheelItem5);
        WheelItem wheelItem6 = new WheelItem(ResourcesCompat.getColor(getResources(), R.color.r2,null),
                BitmapFactory.decodeResource(getResources(),R.drawable.coins),"5 %");
        wheelItemList.add(wheelItem6);
        WheelItem wheelItem7 = new WheelItem(ResourcesCompat.getColor(getResources(), R.color.r1,null),
                BitmapFactory.decodeResource(getResources(),R.drawable.coins),"80 %");
        wheelItemList.add(wheelItem7);
        WheelItem wheelItem8 = new WheelItem(ResourcesCompat.getColor(getResources(), R.color.r2,null),
                BitmapFactory.decodeResource(getResources(),R.drawable.coins),"100 %");
        wheelItemList.add(wheelItem8);

binding.speen.addWheelItems(wheelItemList);



binding.speen.setLuckyWheelReachTheTarget(new OnLuckyWheelReachTheTarget() {
    @Override
    public void onReachTarget() {
        WheelItem itemSelected=wheelItemList.get(Integer.parseInt(points)-1);
        String poins_amount=itemSelected.text;
        Toast.makeText(MainActivity.this, poins_amount, Toast.LENGTH_SHORT).show();
    }
});



binding.speenBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Random random=new Random();
        Toast.makeText(MainActivity.this, "spin", Toast.LENGTH_SHORT).show();
        points=String.valueOf(random.nextInt(10));
        if(points.equals("0"))
       {points=String.valueOf(1);}

   binding.speen.rotateWheelTo(Integer.parseInt(points));


    }
});





    }
}