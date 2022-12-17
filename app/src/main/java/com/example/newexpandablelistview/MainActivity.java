package com.example.newexpandablelistview;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ExpandableListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newexpandablelistview.ExpandableLISTADAPTER.ExpandableLIST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;

    List<String> head_list_names;
    HashMap<String, List<String>> child_list_names;

    public int lastExpandPoint = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = findViewById(R.id.main_expandable_list_container);


        prepareData();

        ExpandableLIST expandableLIST = new ExpandableLIST(MainActivity.this, head_list_names, child_list_names);
        expandableListView.setAdapter(expandableLIST);

        expandableListView.setOnGroupExpandListener(i -> {

            if (lastExpandPoint != -1 && lastExpandPoint != i) {
                expandableListView.collapseGroup(lastExpandPoint);
            }
            lastExpandPoint = i;
        });

    }


    public void prepareData() {
//
//        String[] head_name = getResources().getStringArray(R.array.head_list);
//        String[] child_name = getResources().getStringArray(R.array.child_list);

        head_list_names = new ArrayList<>();
        child_list_names = new HashMap<>();

        //Create Head Title like this
        head_list_names.add("1.Android");
        head_list_names.add("2.Java");
        head_list_names.add("3.C Programme");
        head_list_names.add("4.Python");
        head_list_names.add("5.Kotlin");


//        Create Child List Like this
        List<String> OneChild = new ArrayList<>();
        OneChild.add("1.1 Hello Android");
        OneChild.add("1.2 OverView Android");
        OneChild.add("1.3 Install Android");
        OneChild.add("1.4 First Android");

        List<String> java = new ArrayList<>();
        java.add("1.1 Hello Java");
        java.add("1.2 OverView Java");
        java.add("1.3 Install Java Kit");
        java.add("1.4 First Java");


        List<String> programme_c = new ArrayList<>();
        programme_c.add("1.1 Hello C PROGRAMME");
        programme_c.add("1.2 OverView C PROGRAMME");
        programme_c.add("1.3 Install C PROGRAMME Kit");
        programme_c.add("1.4 First C PROGRAMME");


        List<String> python = new ArrayList<>();
        python.add("1.1 Hello PYTHON");
        python.add("1.2 OverView PYTHON");
        python.add("1.3 Install PYTHON Kit");
        python.add("1.4 First PYTHON");


        List<String> kotlin = new ArrayList<>();
        kotlin.add("1.1 Hello KOTLIN");
        kotlin.add("1.2 OverView KOTLIN");
        kotlin.add("1.3 Install KOTLIN Kit");
        kotlin.add("1.4 First KOTLIN");


//        Add Child List Under One by One Head Title Name Like This
        child_list_names.put(head_list_names.get(0), OneChild);
        child_list_names.put(head_list_names.get(1), java);
        child_list_names.put(head_list_names.get(2), programme_c);
        child_list_names.put(head_list_names.get(3), python);
        child_list_names.put(head_list_names.get(4), kotlin);




//      Add Head and Child List Title
//        for (int i = 0; i < head_name.length; i++) {
//            head_list_names.add(head_name[i]);
//            List<String> child = new ArrayList<>();
//            child.add(child_name[i]);
//
//            child_list_names.put(head_list_names.get(i), child);
//
//        }


    }


}