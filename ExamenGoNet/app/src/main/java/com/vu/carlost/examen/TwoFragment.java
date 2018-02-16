package com.vu.carlost.examen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.vu.carlost.examen.R;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;


/**
 * Created by CarlosT on 15/02/2018.
 */

public class TwoFragment extends Fragment {
    View view;

    //Constructor
    public TwoFragment(){
        //
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_two, container, false);


        LinearLayout layout = (LinearLayout) view.findViewById(R.id.linear);
        for (int i = 0; i < 10; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setId(i);
            imageView.setPadding(2, 2, 2, 2);
            imageView.setImageBitmap(BitmapFactory.decodeResource(
                    getResources(), R.drawable.ic_claro));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), tfActivity.class);
                    startActivity(intent);
                }
            });
            layout.addView(imageView);
        }

        LinearLayout layout1 = (LinearLayout) view.findViewById(R.id.linear_1);
        for (int i = 0; i < 10; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setId(i);
            imageView.setPadding(2, 2, 2, 2);
            imageView.setImageBitmap(BitmapFactory.decodeResource(
                    getResources(), R.drawable.ic_tuenti));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), tfActivity.class);
                    startActivity(intent);
                }
            });
            layout1.addView(imageView);
        }
        LinearLayout layout2 = (LinearLayout) view.findViewById(R.id.linear_2);
        for (int i = 0; i < 10; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setId(i);
            imageView.setPadding(2, 2, 2, 2);
            imageView.setImageBitmap(BitmapFactory.decodeResource(
                    getResources(), R.drawable.ic_entel));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), tfActivity.class);
                    startActivity(intent);
                }
            });
            layout2.addView(imageView);
        }

        return view;


    }
}